package generator;

import CPP.Absyn.*;


/**
 * Find the R, and A attributes I dont know them now
 * @author soenke
 * old @param <LLVMValue>
 * new @param <String>
 *
 */

//mb : changed parameter LLVMValue to String
public class CompileExp implements Exp.Visitor<String, String>{
/**
 * Most of the functions are her always return the appended 
 * string that should be it
 */
	public String codegen(){
		return null;
		
	}
	public String LogErrorV(String str){
		System.out.println(str);
		return null;
		
	}
	
	@Override
	public String visit(ETrue p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit ETrue");
		
		return null;
	}

	@Override
	public String visit(EFalse p, String arg) {
		System.out.println("Visit EFalse");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visit(EInt p, String arg) {
		System.out.println("Visit EInt");
		//return LLVMConstantInteger.
		return null;
	}

	@Override
	public String visit(EDouble p, String arg) {
		System.out.println("Visit Double");
		//return LLVMConstant.getValue(p.double_);
		return null;
	}

	@Override
	public String visit(EString p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit EString");
		return null;
	}

	@Override
	public String visit(EId p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit EId");
		
		
		return null;
	}

	@Override
	public String visit(EApp p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit EApp");
		for(int index = 0; index < p.listexp_.size(); index++)
		{
			Compiler.eval(p.listexp_.get(index));
		}

		return null;
	}

	@Override
	public String visit(EPIncr p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit EPIncr");
		Compiler.eval(p.exp_);

		return null;
	}

	@Override
	public String visit(EPDecr p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit EPDecr");
		Compiler.eval(p.exp_);

		return null;
	}

	@Override
	public String visit(EIncr p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit EIncr");
		Compiler.eval(p.exp_);

		return null;
	}

	@Override
	public String visit(EDecr p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit EDecr");
		Compiler.eval(p.exp_);
		return null;
	}

	@Override
	public String visit(ETimes p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit ETimes");
		Compiler.eval(p.exp_1);
		Compiler.eval(p.exp_2);
		return null;
	}

	@Override
	public String visit(EDiv p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit EDiv");
		Compiler.eval(p.exp_1);
		Compiler.eval(p.exp_2);
		return null;
	}

	@Override
	public String visit(EPlus p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit EPlus");
		
		
		Compiler.eval(p.exp_1);
		Compiler.eval(p.exp_2);
		return null;
	}

	@Override
	public String visit(EMinus p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit EMinus");
		Compiler.eval(p.exp_1);
		Compiler.eval(p.exp_2);
		return null;
	}

	@Override
	public String visit(ELt p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit ELt");
		Compiler.eval(p.exp_1);
		Compiler.eval(p.exp_2);
		return null;
	}

	@Override
	public String visit(EGt p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit EGt");
		Compiler.eval(p.exp_1);
		Compiler.eval(p.exp_2);
		return null;
	}

	@Override
	public String visit(ELtEq p, String arg) {
		System.out.println("Visit ELtEq");
		Compiler.eval(p.exp_1);
		Compiler.eval(p.exp_2);
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visit(EGtEq p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit EGtEq");
		Compiler.eval(p.exp_1);
		Compiler.eval(p.exp_2);
		return null;
	}

	@Override
	public String visit(EEq p, String arg) {
		System.out.println("Visit EEq");
		Compiler.eval(p.exp_1);
		Compiler.eval(p.exp_2);
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visit(ENEq p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit ENEq");
		Compiler.eval(p.exp_1);
		Compiler.eval(p.exp_2);
		return null;
	}

	@Override
	public String visit(EAnd p, String arg) {
		// TODO Auto-generated method stub
		
		System.out.println("Visit EAnd");
		Compiler.eval(p.exp_1);
		Compiler.eval(p.exp_2);
		return null;
	}

	@Override
	public String visit(EOr p, String arg) {
		System.out.println("Visit EOr");
		// TODO Auto-generated method stub
		Compiler.eval(p.exp_1);
		Compiler.eval(p.exp_2);
		
		return null;
	}
	
	/**
	 * Exp = Assignement:
	 * z.B. x = 2;
	 */
	@Override
	public String visit(EAss p, String arg) {
		System.out.println("Visit EAss");
		Compiler.eval(p.exp_1);
		Compiler.eval(p.exp_2);
		
		return null;
	}

	@Override
	public String visit(ETyped p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit ETyped");
		return null;
	}
	
}
