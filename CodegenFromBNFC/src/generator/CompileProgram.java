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
		System.out.println("Visit PDefs");
		
		//
		for(int i =0 ; i< p.listdef_.size(); i++)
		{
			/**
			 * fuer jede Funktion wird eval(DFun) aus Compiler aufgerufen
			 * 
			 */
			
			//System.out.println("CompileProgram arg:");
			
			Compiler.eval(p.listdef_.get(i));
			
			
		}
		
		return null;
	}

}
