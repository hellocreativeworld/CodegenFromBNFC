package generator;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import CPP.Yylex;
import CPP.parser;
import CPP.Absyn.Program;


public class Main {

	static  String filename;
	public static void main(String[] args) {
		
		try {
			
			
			File f = new File("testfiles_cc/good07.cc");
			f.createNewFile();
			filename = f.getName();
			if(!f.exists()){
			System.out.println("File does not exist");
			}
			Yylex l = new Yylex(new FileReader(f));
			
			parser p = new parser(l);
				
				CPP.Absyn.Program parse_tree;
				try {
					parse_tree = p.pProgram();
					generate(parse_tree);
				} catch (Exception e) {
					
					System.out.println(e);
				}
				
		}catch(IOException e){
			System.out.println(e.getMessage());
		}

	}
	
	/**
	 * 
	 * implement the functions
	 * 			-read through the doc of llvm to find the correct string values for the functions
	 * print the string in an existing file
	 * make java to execute jasmin and with that text file
	 * For any 
	 * 
	 * 
	 * maybe it does make sense to do sysos in every visit and eval 
	 * @param parse_tree
	 */
	
	private static void generate(Program parse_tree) {
		//Compiler c = new Compiler();
		System.out.println(parse_tree.toString());
		
		/**
		 * es wird die Version von eval aufgerufen, die der Parameter angibt.
		 * Hier ist der Parameter Program (parse_tree ist vom Typ Program), 
		 * also wird in der Klasse Compiler, die Methode eval(Program) ausgerufen
		 */
		Compiler.eval(parse_tree);
		
		
		
		System.out.println("Modul: LLVM-Output="+Module.llvm_output);
		//Module.mod.dump();
		Filewriter.writeFile(filename);
	}
	
	

}
