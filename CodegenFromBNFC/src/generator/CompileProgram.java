package generator;

import CPP.Absyn.PDefs;
import CPP.Absyn.Program.Visitor;


/**
 * the R and A aastuff has to be evaluated
 * @author soenke
 *
 */
public class CompileProgram implements Visitor<String, String>{
/**
 * something about module i guess i havent yet read through the whole llvm
 * and ofc string work her too
 * 
 * Besuche alle Funktionsdefinitionen in der Liste
 * 
 * @param p : 
 */
	@Override
	public String visit(PDefs p, String arg) {
		System.out.println("I'm visiting PDefs (CompileProgram.java)");
		
		//
		for(int i =0 ; i< p.listdef_.size(); i++)
		{
			/**LLVM Funktionsdefinition Schluesselwort "define" */
			Module.buildString("define ");
			
			/**
			 * Innerhalb eines Programms wird fuer jede
			 * Funktionsdefinition eval(DFun) aufgerufen
			 * (aus Compiler.java)
			 */
			Compiler.eval(p.listdef_.get(i));
			Module.buildString("\n\n");
			
			
		}
		
		return null;
	}

}
