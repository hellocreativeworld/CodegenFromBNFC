package generator;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import CPP.PrettyPrinter;
import CPP.Yylex;
import CPP.parser;
import CPP.Absyn.Program;


public class Main {

	public static  String filename;

	public static void main(String[] args) {

		try 
		{

			File f = new File("testfiles_cc/good03.cc");
			
			//File f = new File("testfiles_cc/good13.cc");

			//For Debug:
//			System.out.println("f="+f.toString());
//			boolean testf = f.createNewFile();
//			System.out.println("File exists?"+!testf);

			filename = f.getName();

			//For Debug
			//System.out.println("filename="+filename);

			if(!f.exists())
			{
				System.out.println("File does not exist");
			}

			Yylex l = new Yylex(new FileReader(f));

			parser p = new parser(l);


			try 
			{
				CPP.Absyn.Program parse_tree = p.pProgram();

				System.out.println();
				System.out.println("Parse Succesful!");
				System.out.println();
				System.out.println("[Abstract Syntax]");
				System.out.println();
				System.out.println(PrettyPrinter.show(parse_tree));
				System.out.println();
				System.out.println("[Linearized Tree]");
				System.out.println();
				System.out.println(PrettyPrinter.print(parse_tree));


				generateCode(parse_tree);

			} catch (Exception e) 
			{
				// Error-Message
				System.out.println(e);
			}

		}catch(IOException e){
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Codegeneration:
	 * Durchlaufe den Abstrakten Syntaxbaum und 
	 * schreibe in jedem Konstruktor (Knoten des Syntaxbaums)
	 * den entsprechenden LLVM-Code in das LLVM-Module
	 * (z.B. Textfile good01.cc_output.txt)
	 * 
	 * 
	 * 
	 * implement the functions
	 * 			-read through the doc of llvm to find the correct string values for the functions
	 * print the string in an existing file
	 * 
	 * maybe it does make sense to do sysos in every visit and eval 
	 * @param parse_tree
	 */

	private static void generateCode(Program parse_tree) {

		//Compiler c = new Compiler();
		//System.out.println(parse_tree.toString());

		/**
		 * es wird die Version von eval aufgerufen, die der Parameter angibt.
		 * Hier ist der Parameter Program (parse_tree ist vom Typ Program), 
		 * also wird in der Klasse Compiler, die Methode eval(Program) ausgerufen
		 */
		Compiler.eval(parse_tree);


		System.out.println("Main.java: LLVM-Output: \n");
		System.out.println(Module.llvm_output);
		//Module.mod.dump();

		/**
		 * filename ist static, deshalb wird er innerhalb von 
		 * Filewriter mittels Main.filename aufgerufen
		 */
		Filewriter.writeFile();
	}

}
