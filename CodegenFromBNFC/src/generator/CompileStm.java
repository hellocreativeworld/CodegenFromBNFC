package generator;

import CPP.Absyn.SBlock;
import CPP.Absyn.SDecls;
import CPP.Absyn.SExp;
import CPP.Absyn.SIfElse;
import CPP.Absyn.SInit;
import CPP.Absyn.SReturn;
import CPP.Absyn.SReturnVoid;
import CPP.Absyn.SWhile;
import CPP.Absyn.Stm;

/**
 * evalute the R and A
 * @author soenke
 *
 */


public class CompileStm implements Stm.Visitor<String, String>{
/**
 * a lot of functions which are mostly similar to themselves and compileExp functions
 * String work 
 */
	@Override
	public String visit(SExp p, String arg) 
	{
		
		System.out.println("Visiting SExp");

		Compiler.eval(p.exp_);
		Module.builder("\n");
		return null;
	}

	
	/**
	 * Todo Special case
	 */
	@Override
	public String visit(SDecls p, String arg) {
		System.out.println("Visit SDecls");
//		for(int i =0; i< p.listid_.size(); i++)
//		{
//			Compiler.eval(p.listid_.get(i));
//		}
		
		// TODO Auto-generated method stub
		return null;
	}

	/***
	 * 
	 * 
	 * SInit. Stm ::= Type Id "=" Exp ";" ;
	 */
	@Override
	public String visit(SInit p, String arg) {
		System.out.println("Visit SInit");
		
		// Deklarations-Typ
		Compiler.eval(p.type_);
		
		Module.builder(p.id_+ "=");
		
		Compiler.eval(p.exp_);
		
		return null;
	}

	@Override
	public String visit(SReturn p, String arg) 
	{
		
		System.out.println("Visiting SReturn");
		Module.builder("ret ");
		Compiler.eval(p.exp_);
		return null;
	}

	@Override
	public String visit(SReturnVoid p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visiting SReturnVoid");
		Module.builder("ret void");
		return null;
	}

	@Override
	public String visit(SWhile p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visiting SWhile");
		Compiler.eval(p.exp_);
		Compiler.eval(p.stm_);
		return null;
	}
	
	
	/**
	 * SBlock ist z.B. innerhalb einer While-Schleife
	 * while() SBlock
	 * 
	 * <=> while(){ [Stm] }
	 * 
	 */
	@Override
	public String visit(SBlock p, String arg) 
	{
		System.out.println("I'm visiting SBlock now");
		
		for(int i=0; i<p.liststm_.size(); i++)
		{
			Module.builder("{"); // oeffnende SBlock-Klammer
			Compiler.eval(p.liststm_.get(i));
			Module.builder("}"); // schliessende SBlock-Klammer
		}
		
		return null;
	}

	@Override
	public String visit(SIfElse p, String arg) {
		
		System.out.println("Visit SIfElse");
		Compiler.eval(p.exp_);
		Compiler.eval(p.stm_1);
		Compiler.eval(p.stm_2);
		return null;
	}

}
