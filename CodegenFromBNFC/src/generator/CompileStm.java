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
		//SModule.builder("\n");
		return null;
	}

	
	/**
	 * TODO Special case
	 * 
	 * Deklarationen von Variablen (-listen)
	 * SDecls. Stm ::= Type [Id] ";" ;
	 * 
	 */
	@Override
	public String visit(SDecls p, String arg) {
		System.out.println("Visiting SDecls");
//		for(int i =0; i< p.listid_.size(); i++)
//		{
//			Compiler.eval(p.listid_.get(i));
//		}
		
		/**
		 * Deklarationstyp
		 */
		Compiler.eval(p.type_);
		
		/**
		 * Deklarationsliste
		 * listid ist eine Liste von Strings
		 */
		for(int i =0; i< p.listid_.size(); i++)
		{
			//Compiler.eval(p.listid_);
			
			/***
			 * SDecls . Stm ::= Type [Id] ";"
			 */
			// TODO SDecls in LLVM IR
			Module.buildString("%" + p.listid_.get(i)+"= alloca i32, align 4" + "\n");
		}
		
		
		return null;
	}

	/***
	 * Deklaration und Initialisierung von Variable
	 * 
	 * SInit. Stm ::= Type Id "=" Exp ";" ;
	 */
	@Override
	public String visit(SInit p, String arg) {
		System.out.println("Visit SInit");
		
		
		Module.buildString("%" + p.id_ + " = alloca ");
		
		//Module.builder("%" + Module.getNextIndex()+" = call");
		
		// Deklarations-Typ
		Compiler.eval(p.type_);
		
		Module.buildString( " "+p.id_ + ", " + "align 4\n\t");
		
		Compiler.eval(p.exp_);
		
		return null;
	}

	@Override
	public String visit(SReturn p, String arg) 
	{
		
		System.out.println("Visiting SReturn");
		
		/**
		 * LLVM 
		 * ret <type> <value>
		 */
		
		Module.buildString("ret ");
		Compiler.eval(p.exp_);
		return null;
	}

	@Override
	public String visit(SReturnVoid p, String arg) {
		
		System.out.println("Visiting SReturnVoid");
		
		/**
		 * LLVM: 
		 * ret void
		 */
		Module.buildString("ret void");
		return null;
	}

	@Override
	public String visit(SWhile p, String arg) {
		// TODO SWhile
		System.out.println("Visiting SWhile");
		
		
		/**
		 * LLVM: 
		 * br i1 <cond>, label <iftrue>, label <iffalse>
		 */
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
			Module.buildString("{"); // oeffnende SBlock-Klammer
			Compiler.eval(p.liststm_.get(i));
			Module.buildString("}"); // schliessende SBlock-Klammer
		}
		
		return null;
	}

	@Override
	public String visit(SIfElse p, String arg) {
		
		System.out.println("Visit SIfElse");
		/**
		 * LLVM: 
		 * br i1 <cond>, label <iftrue>, label <iffalse>
		 */
		Compiler.eval(p.exp_);
		Compiler.eval(p.stm_1);
		Compiler.eval(p.stm_2);
		return null;
	}

}
