package generator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Filewriter for output file
 * 
 * 
 * @author soenke
 *
 */
public class Filewriter {
	
	
	//private String outputname;
	
 
 
/**
 * uses the initiale file name like good01.cc and creates a File calles good01.cc_output.txt
 * with the llvm_output
 * @param fileName
 */
 public static void writeFile(String fileName)
 {
	 System.out.println("Filename(Filewriter)=" + Main.filename);
	 
	 StringBuilder sb = new StringBuilder();
	 sb.append(Main.filename).append("_output").append(".txt");
	 String outputname = sb.toString();
	 
	 System.out.println("outputname(Filewriter)=" + outputname);
	 
	 try(PrintStream out= new PrintStream(new FileOutputStream(outputname)))
	 {
		 
		 out.print(Module.llvm_output);
		 
	 }catch (FileNotFoundException e) {
		System.out.println(e.getMessage());
	}
 }
 
 public static void writeLLVMModuleToFile(String fileName)
 {
	 
 }
 
}
