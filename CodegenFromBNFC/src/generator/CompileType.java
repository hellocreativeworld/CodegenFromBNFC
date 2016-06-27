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
		Module.builder("bool");
		
		return null;
	}

	@Override
	public String visit(Type_int p, String arg) {
		
		System.out.println("I'm visiting Type_int now");
		
		/**
		 * int in LLVM : 
		 */
		Module.builder("i32");
		
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
		Module.builder("double");
		
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
		Module.builder("void");
		
		return null;
	}

	@Override
	public String visit(Type_string p, String arg) 
	{
		System.out.println("I'm visiting Type_string now");
		
		/**
		 * TODO
		 * String in LLVM : 
		 */
		//Module.builder("");
		
		return null;
	}

}
