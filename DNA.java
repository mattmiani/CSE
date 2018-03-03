//Matt Miani
//CSE 142
//TA: Aidan Hunt
// 2/27/18
// This program takes in a file containing nucleotide sequences and region
// identifiers, and creates an output file with certain information about
// those sequences; mass percentages of ACTG, list of codons, etc.

import java.util.*;
import java.io.*;

public class DNA {
   //class constants for minimum number of codons of a valid protein,
   //minimum combined percentage of cytosine and guanine for a valid protein
   //length of a codon
   //number of unique bases
   
   static int MIN_CODONS = 5;
   static double CG_PERCENT= 30.0;
   static int CODON_LENGTH =3;
   static int BASES = 4; 
   
   public static void main (String [] args)
   throws FileNotFoundException {
      
      Scanner user = new Scanner(System.in);
      
      File input = inputPrompt(user); //input prompt
      File output = outputPrompt(user); //output prompt
      PrintStream result = new PrintStream(output);
      
      Scanner fileScan = new Scanner(input);
      while (fileScan.hasNextLine()) {
         String line = fileScan.nextLine();
         
         if (line.contains(" ")) {
            result.println("Region Name: " + line);
         } else {
            scan(line, result);
            nucCount(line, result);
            double minPercent= calcPercent(line.toLowerCase(), result);
            String[] codons = codonSet(line, result);
            checkProtein(codons, result, minPercent);
         }
      }
   }
   
   //user prompt for input file
   public static File inputPrompt(Scanner user)
   throws FileNotFoundException {
      System.out.println("This program reports information about DNA");
      System.out.println("nucleotide sequences that may encode proteins.");
      System.out.print("Input file name? ");
      
      
      File input = new File(user.nextLine());
      while(!input.exists()) {
         System.out.print("File not found. ");
         input = new File(user.nextLine()) ;
      } 
      return input;    
   }
   //user prompt for output file
   public static File outputPrompt(Scanner user)
   throws FileNotFoundException {
      System.out.print("Output file name? ");
      
      File output = new File(user.nextLine());      
      return output;  
   }
   
   //goes through input file and finds nucleotide sequences to print
   public static void scan(String line, PrintStream result)
   throws FileNotFoundException {
      
      Scanner lineScan = new Scanner(line);
      String sequence = line.toUpperCase();
      
      result.println("Nucleotides: " + sequence);
   }
   
   //finds the number of each nucleotide base
   public static void nucCount(String input, PrintStream result)
   throws FileNotFoundException {
      int[] total = new int[BASES];
      String line = input.toUpperCase();
      String nuc = "ACGT";
      for (int i = 0; i<line.length(); i++) {
         char c = line.charAt(i);
         for (int j = 0; j<=CODON_LENGTH; j++) {
            if (c == nuc.charAt(j)) {
               total[j]++;
            }
         }
      }
      result.println("Nuc. Counts: " + Arrays.toString(total));
   }
   
   
   //separates nucleotide sequence into codons, returns as an array
   public static String[] codonSet(String input, PrintStream result)
   throws FileNotFoundException {
      String codons = input.toUpperCase().replace("-","");
      String[] codonSet = new String[ (codons.length()/CODON_LENGTH)];
      
      for (int i=0; i<=(codons.length()/CODON_LENGTH)-1; i++) {
         codonSet[i] = codons.substring(CODON_LENGTH*i, CODON_LENGTH*i+CODON_LENGTH);
      }
      result.println("Codons List: " + Arrays.toString(codonSet));
      return codonSet;
   }
   
   //calculates the mass percentage of each nucleotide base in the sequence
   //returns the combined percentage of cytosine and guanine
   public static double calcPercent(String line, PrintStream result)
   throws FileNotFoundException {
      double adenine = 135.128;
      double cytosine = 111.103;
      double thymine = 125.107;
      double guanine = 151.128;
      double junk = 100.000;
      
      double[] massSet = new double[5];
      massSet[0] = adenine;
      massSet[1] = cytosine;
      massSet[2] = guanine;
      massSet[3] = thymine;
      massSet[4] = junk;
      
      double[] rawMass = new double[5];
      String nuc = "acgt-";
      
      for (int i = 0; i<line.length(); i++) {
         char c = line.charAt(i);
         
         for (int j = 0;j<=BASES; j++){
            
            if (c==nuc.charAt(j)) {
               
               rawMass[j]+=massSet[j];
            }
         }
      }
      double sum =0.0;
      for(int i=0; i<rawMass.length; i++) {
         
         sum+= rawMass[i];
      }
      sum = Math.round(sum*10.0) / 10.0;
      
      double[] percent = new double[BASES];
      for (int i = 0; i<percent.length; i++) {
         percent [i] = Math.round( (rawMass[i]/sum)*1000.0) /10.0;
      }
      
      result.println("Total Mass%: " + Arrays.toString(percent) + " of " + sum);
      
      double cgPercent = percent[1] + percent[2];
      return cgPercent;
   }
   
   //uses the conditions in the spec to predict if the sequence could be a protein
   public static void checkProtein(String[] codonSet, PrintStream result, double cgPercent)
   throws FileNotFoundException {
      
      String[] stop = new String[3];
      stop[0] = "TAG";
      stop[1] = "TAA";
      stop[2] = "TGA";
      
      String end = codonSet[codonSet.length-1];
      boolean protein = false;
      
      if ((codonSet.length-1)>=MIN_CODONS-1){
         if (codonSet[0].equals("ATG")) {
            if (cgPercent>=30.0){
               for (int i = 0; i<=stop.length-1; i++){
                  if (stop[i].equals(end)) {
                     protein = true;
                  }
               }
            }
         }
      }
      else {
         protein = false;
      }
      
      if(protein) {
         result.println("Is Protein?: YES");
      }
      else {
         result.println("Is Protein?: NO");
      }
      result.println();
   }
}
