import java.util.*; 
import java.lang.*; 

public class Gradanator { 

      public static void main (String [] args) { 
      
      Scanner console = new Scanner(System.in); 
    
     System.out.println("This program reads exam/homework scores "); 
     System.out.println("and reports your overall course grade. "); 

      
   double midtermGrade = grades(console, "Midterm"); 
   double finalGrade = grades(console, "Final"); 
      
       

    System.out.print("Your overall score is: " + (finalGrade+midtermGrade)); 
      
      } 
      
      public static final double grades(Scanner console, String exam) {
      
      double endWeight = 0.0; 
      double endScore = 0.0; 
      double totalGrade = 0.0; 
      
              System.out.println(); 
   
         System.out.println(exam + ": "); 
         System.out.print("Weight (0-100)? "); 
         
         
         int weight = console.nextInt(); 
         endWeight+=weight; 
          
         
         System.out.print("Score earned? "); 
         
         int score = console.nextInt();   
         endScore+=score; 
        
         
         System.out.print("Were scores shifted (1=yes 2=no)? ");     
         
        if (console.nextInt()==1) { 
         System.out.print("Shift amount? "); 
         endScore+=console.nextInt(); 
        }
         
         System.out.println("Total points: " + endScore + " / 100"); 
         
         System.out.println("Weighted score = " + (endScore * (endWeight/100)) + " / " + weight); 
         
         totalGrade+= (endScore * (endWeight/100));
         
       return totalGrade; 
         
         
                 } 
       } 
         