//Matt Miani 
//CSE 142 
//TA: Aidan Hunt 
// 2/18/18

//This program reads a specially prepared input file and prompts the user for the 
//appropriate words in order to create a "MadLib". After creation, the user 
//can either create another MadLib, view the newly created one, or quit the program.


import java.util.*;
import java.io.*;

public class MadLibs   {
		
	public static void main(String []args) throws FileNotFoundException {
		
		Scanner user = new Scanner(System.in);
		startPrompt();
		madLibs(user);
	}
	
	public static void startPrompt(){
		System.out.println("Welcome to the game of Mad Libs.");
		System.out.println("I will ask you to provide various words");
		System.out.println("and phrases to fill in a story.");
		System.out.println("The result will be written to an output file.");
		System.out.println();
		System.out.print("(C)reate mad-lib, (V)iew mad-lib, (Q)uit? ");
		
	}
	
	public static void madLibs (Scanner user)  throws FileNotFoundException {
		String firstAnswer = user.nextLine();
		
		if (firstAnswer.startsWith("C") || firstAnswer.startsWith("c") ) {
			
			File madlib =  new File (create(user));
			System.out.println("Your madlib has been created!");
			System.out.print("(C)reate mad-lib, (V)iew mad-lib, (Q)uit? ");
			
			madLibs(user);
		}
		
		else if (firstAnswer.startsWith("V") || firstAnswer.startsWith("v")) {
			view(user);
			
		}
		
		else if (firstAnswer.startsWith("Q") || firstAnswer.startsWith("q") ) {
			return;
		}
		else {
			System.out.println("I don't understand. Try again. ");
			madLibs(user);
		}
		
	}
	
	public static void view (Scanner user) throws FileNotFoundException {
		System.out.print("Input file name: ");
		
		
		File input = new File(user.nextLine());
		
		while (!input.exists()) {
			System.out.print("File not found. Try again. ");
			input= new File (user.nextLine());
		}
		
		Scanner outScan = new Scanner (input);
		
		while (outScan.hasNextLine()){
			String line = outScan.nextLine();
			Scanner lineScan =  new Scanner (line);
			
			while (lineScan.hasNext()) {
				System.out.print(lineScan.next() + " " );
			}
			
			System.out.println();
		}
		System.out.print("(C)reate mad-lib, (V)iew mad-lib, (Q)uit? ");
		madLibs(user);
	}
	
	
	public static String create (Scanner user ) throws FileNotFoundException {
		
		System.out.print("Input file name: ");
		
		
		File input = new File(user.nextLine());
		while (!input.exists()) {
			System.out.print("File not found. Try again. ");
			input= new File (user.nextLine());
		}
		
		
		System.out.print("Output file name: ");
		String outName = user.nextLine();
		
		File output = new File(outName);
		
		PrintStream out = new PrintStream (output);
		
		Scanner fileScan = new Scanner (input);
		
		
		
		while (fileScan.hasNextLine() ) {
			String line = fileScan.nextLine();
			Scanner lineScan = new Scanner (line);
			
			while (lineScan.hasNext()) {
				String word = lineScan.next();
				
				if (word.startsWith("<") ) {
					
					String inside = word.substring(1, word.length()-1);
					String prompt = inside.toLowerCase();
					
					checkWord(prompt, user, out);
				}
				
				else {
					out.print(word+ " ");
					
				}
			}
			out.println();
		}
		
		
		return outName;
		
	}
   
   
   //write boolean method for checking words 
   //use boolean for a/an 
	
	public static void checkWord(String prompt,Scanner user, PrintStream out) {
		
      boolean vowel = false; 
      
      if (prompt.contains("-")){
			prompt = prompt.replace("-", " ");
         }
         
      if (prompt.charAt(0) == 'a'){
			vowel = true; 
         		}
		else if (prompt.charAt(0) == 'e'){
			vowel = true; 
		      }
		else if (prompt.charAt(0) == 'i'){
			vowel = true; 
		      }
		else if (prompt.charAt(0) == 'o'){
			vowel = true; 
		      }
		else if (prompt.charAt(0) == 'u'){
			vowel = true; 
		      }
				
       if (vowel == true) { 
            System.out.print("Please type an "+ prompt + ": ");
			String answer = user.nextLine();
			
			out.print( answer + " ");
            } 

		else if (vowel==false) {
			System.out.print("Please type a "+ prompt + ": ");
			String answer = user.nextLine();
			
			out.print( answer + " ");
		      }
		
	}
	
	
}