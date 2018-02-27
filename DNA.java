

import java.util.*;
import java.io.*;

public class DNA {
   static int MIN_CODONS = 5;
   static double CG_PERCENT= 30.0;
   static int CODON_LENGTH =3;
   
   
   public static void main (String [] args)
   throws FileNotFoundException {
      
      Scanner user = new Scanner(System.in);
      
     File input = prompt(user);
     scan(input); 
      //scan 
      //nucleotides
      //cgPercent
      //codon list
      //check protein 
   }
   
   
   public static File prompt(Scanner user)
   throws FileNotFoundException {
      System.out.println("This program reports information about DNA");
      System.out.println("nucleotide sequences that may encode proteins.");
      System.out.print("Input file name? ");
      
      
      File input = new File(user.nextLine());
      while(!input.exists()) {
         System.out.print("File not found. ");
         input = new File(user.nextLine()) ;
      }
      
      
      //scan(input);
      return input; 
      
   }
   
   //prompt needs to feed input file to here
   public static void scan(File in)
   throws FileNotFoundException {
      
      Scanner fileScan = new Scanner(in);
      Scanner user = new Scanner (System.in);
      
      System.out.print("Output file name? ");
      File out = new File (user.nextLine());
      PrintStream result = new PrintStream(out);
      
      
      
      while (fileScan.hasNextLine()) {
         String line = fileScan.nextLine();
         if (!line.contains(" ")){
            report(line, result);
            
         } else {
            //print region name to output
            result.println("Region Name: " + line);
            
         }
      }
      
      
      
   }
      public static void report(String input, PrintStream result)
   throws FileNotFoundException {
      
      int[] total = new int[4];
      
      
      String line = input.toUpperCase();
      String nuc = "ACGT";
      
      
      result.println("Nucleotides: " + line);
      ;
      for (int i = 0; i<line.length(); i++) {
         
         char c = line.charAt(i);
         for (int j = 0; j<=CODON_LENGTH; j++) {
            if (c == nuc.charAt(j)) {
               total[j]++;
            }
         }
      }
      result.println("Nuc. Counts: " + Arrays.toString(total));
      double cgPercent = calcPercent(input.toLowerCase(), result);
      
      String codons = input.toUpperCase().replace("-","");
      
      String[] codonSet = new String[(codons.length()/CODON_LENGTH)];
      
      for (int i = 0; i<= (codons.length()/CODON_LENGTH)-1; i++) {
         codonSet[i] = codons.substring(CODON_LENGTH*i, CODON_LENGTH*i+CODON_LENGTH);
      }
      
      result.println("Codons List: " + Arrays.toString(codonSet));
      checkProtein(codonSet, result, cgPercent);
      
   }
   
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
      //process by character
      //add to total sum \
      //add up amount of each
      //end with mass rawMassages
      
      //need array with nuc counts for easier math
      String nuc = "acgt-";
      
      for (int i = 0; i<line.length(); i++) {
         char c = line.charAt(i);
         
         for (int j = 0;j<=4; j++){
            
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
      
      double[] percent = new double[4];
      for (int i = 0; i<percent.length; i++) {
         percent [i] = Math.round( (rawMass[i]/sum)*1000.0) /10.0;
         // percent[i] = (rawMass[i]/sum) * 100;
      }
      
      result.println("Total Mass%: " + Arrays.toString(percent) + " of " + sum);
      
      double cgPercent = percent[1] + percent[2];
      return cgPercent;
   }
   public static void checkProtein(String[] codonSet, PrintStream result, double cgPercent)
   throws FileNotFoundException {
      
      
      //string array traversal for ending codon
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