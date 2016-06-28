package generator;
import java.util.HashMap;

public  class Module {

	static String llvm_output="";
	static HashMap<String, String> context = new HashMap<>(); // String funktionsmname String inhalt(llvm)
	
	
	/**
	 * Erstellt den LLVM-Code, also die LLVM IR des C++-Programms:
	 * 
	 * in jedem Knoten des Syntaxbaums wird die Funktion aufgerufen
	 * und die entsprechende LLVM-Anweisung an den bestehenden LLVM-Code
	 * angefuegt
	 * 
	 * Nach Programm-Ende steht in llvm_output die LLVM IR 
	 * des C++ Programms
	 * 
	 * @param str der anzuhaengende String
	 */
	static void builder(String str){
		StringBuilder sb = new StringBuilder();
		sb.append(llvm_output).append(str);
		llvm_output = sb.toString();
	}
}
