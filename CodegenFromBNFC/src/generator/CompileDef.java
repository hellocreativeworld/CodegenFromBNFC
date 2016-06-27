package generator;
import CPP.*;
import CPP.Absyn.*;

//The R and a has to be evaluated

public class CompileDef implements Def.Visitor<String, String> {
	/**
	 * create a string for that definition and write it in the text file
	 * go through all stuff that p has nad do the same 
	 */
	@Override
	public String visit(DFun p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("I'm Visiting DFun now (in CompileDef.java)");
		
		/**
		 * Funktions-Rueckgabetyp fuer LLVM
		 * int main
		 */
		Compiler.eval(p.type_);
		
		//System.out.println("DFun Id="+ p.id_ +"\n" + "DFun Type="+p.type_.equals());
		
		//LLVM Syntax
		//Module.builder("define" + p.type_+ "@"+p.id_);
		
		/***
		 * Liste der Funktionsparameter:
		 * Parameter werden besucht
		 */
		for(int i =0; i<p.listarg_.size(); i++)
		{
			Compiler.eval(p.listarg_.get(i));	
		}
		
		/***
		 * Liste der Statements einer Funktion
		 * Statements werden besucht
		 */
		for(int i =0; i<p.liststm_.size(); i++)
		{
			Compiler.eval(p.liststm_.get(i));	
		}
		
		return null;
	}

}
