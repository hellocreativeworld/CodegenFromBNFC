package generator;

import CPP.Absyn.Type.Visitor;
import CPP.Absyn.Type_bool;
import CPP.Absyn.Type_double;
import CPP.Absyn.Type_int;
import CPP.Absyn.Type_string;
import CPP.Absyn.Type_void;

public class CompileType implements Visitor<String, String> {

	@Override
	public String visit(Type_bool p, String arg) {
		
		System.out.println("I'm visiting Type_bool now");
		
		/**
		 * TODO
		 * bool in LLVM : 
		 */
		Module.buildString("bool");
		
		return null;
	}

	@Override
	public String visit(Type_int p, String arg) {
		
		System.out.println("I'm visiting Type_int now");
		
		/**
		 * int in LLVM : 
		 */
		Module.buildString("i32");
		
		return null;
	}

	@Override
	public String visit(Type_double p, String arg) 
	{
		System.out.println("I'm visiting Type_double now");
		
		/**
		 * TODO
		 * double in LLVM : 
		 */
		Module.buildString("double");
		
		return null;
	}

	@Override
	public String visit(Type_void p, String arg) 
	{
		System.out.println("I'm visiting Type_void now");
		
		/**
		 * TODO
		 * void in LLVM : 
		 */
		Module.buildString("void");
		
		return null;
	}

	@Override
	public String visit(Type_string p, String arg) 
	{
		System.out.println("Visiting Type_string");
		
		/**
		 * TODO
		 * String in LLVM : 
		 */
		//Module.builder("");
		
		return null;
	}

}
