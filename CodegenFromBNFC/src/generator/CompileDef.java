package generator;
import CPP.Absyn.DFun;
import CPP.Absyn.Def;

//The R and a has to be evaluated

/**
 * Besuche die Funktionsdefinition des Programms, 
 * 
 * z.B. int main(){}
 *
 */

public class CompileDef implements Def.Visitor<String, String> {
	/**
	 * create a string for that definition and write it in the text file
	 * go through the subtree of p and do the same 
	 */
	@Override
	public String visit(DFun p, String arg) 
	{
		
		System.out.println("I'm Visiting DFun now (CompileDef.java)");
		
		/**
		 * Rueckgabetyp der Funktion wird ermittelt fuer LLVM
		 * int main
		 */
		Compiler.eval(p.type_);
		
		
		//System.out.println("p.id_="+p.id_);
		
		//LLVM Syntax fuer Funktionsnamen 
		Module.buildString(" @" + p.id_);
		
		/***
		 * Liste der Funktionsparameter (Argumente):
		 * Parameter werden besucht
		 */
		
		Module.buildString("("); // oeffnende Klammer fuer die Argumentenliste
		
		for(int i =0; i<p.listarg_.size(); i++)
		{
			
			Compiler.eval(p.listarg_.get(i));
			
		}
		
		/**
		 * schliessende Klammer fuer die Argumentenliste,
		 * oeffnende Klammer fuer den Function-Body, 
		 * plus 2 Zeilenumbrueche
		 */
		Module.buildString("){\n\n\t");
		
		/***
		 * Liste der Statements einer Funktion:
		 * Statements werden besucht
		 * 
		 * wenn Statement-Liste nicht leer, 
		 * dann 
		 */
		if(p.liststm_.size() > 0)
		{
			//Module.builder("){\n entry: \n\t"); 
			
			
			
			for(int i =0; i<p.liststm_.size(); i++)
			{
				Compiler.eval(p.liststm_.get(i));
				
				/**
				 * Nach jedem Statement Zeilenumbruch und
				 * Tabulator einfuegen, sodass jedes Statement 
				 * in der eigenen Zeile steht und eingerueckt ist
				 */
				Module.buildString("\n\t");
			}
		}
//		else
//		{
//			/**
//			 * Wenn Funktions-Body leer, dann einfach Zeilenumbruch
//			 */
//			Module.builder("){\n");
//		}
		
		
		/**
		 * Wenn Funktionsrueckgabewert void
		 * und kein "return;" im Function-Body
		 */
		if(p.type_ instanceof CPP.Absyn.Type_void)
		{
			Module.buildString("\t ret void");
		}
		
		
		//For Debug
		//System.out.println("CompileDef.java: \n"+Module.llvm_output);
		
		// Schliessende Funktionsklammer }
		Module.buildString("\n}");
		
		
		return null;
	}

}
