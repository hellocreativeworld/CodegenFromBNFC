package generator;

import CPP.Absyn.*;

public class Compiler {
	
	public static void eval(Type t){
		System.out.println("Eval Expression:");
		
		 t.accept(new CompileType(), null);
		
		 return;
	}
	
	public static void eval(Exp e){
		System.out.println("Eval Expression:");
		
		 e.accept(new CompileExp(), null);
		
		 return;
	}
	
	public static void eval(Stm s){
		System.out.println("Eval Statement");
		
		s.accept(new CompileStm(), null);
		return ;
	}
	
	public static void eval(Arg a){
		System.out.println("Eval Argument");
		
		a.accept(new CompileArg(), null);
		return ;
	}
	
	public static void eval(Def d){
		System.out.println("Eval Function-Definition");
		
		d.accept(new CompileDef(), null);
		return ;
	}
	
	//eval -> accept -> visit
	
	
	public static void eval(Program p){
		System.out.println("Eval Programm");
		
		
		/***
		 * es wird CompileProgram aufgerufen, 
		 * es werden dort die PDefs besucht, 
		 * PDefs.   Program ::= [Def] ;
		 * also die Liste von Funktions-Definitionen
		 */
		
		p.accept(new CompileProgram(),null);
		
		return;
	}
	
	
	
}
