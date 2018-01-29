import java.util.*;
import java.lang.*;

public class Gradanator {
   
   public static void main (String [] args) {
      
      Scanner console = new Scanner(System.in);
      
      
      double midtermGrade = midGrades(console);
      double finalGrade = finalGrades(console);
      
      
      double hwkGrade = homework(console);
      
      calculate(midtermGrade, finalGrade, hwkGrade);
      
      
      
      
   }
   
   public static final double midGrades(Scanner console) {
      
      double endWeight = 0.0;
      double endScore = 0.0;
      double totalGrade = 0.0;
      
      System.out.println("This program reads exam//homework scores");
      System.out.println("and reports your overall course grade");
      System.out.println();
      
      System.out.println("Midterm: ");
      System.out.print("Weight (0-100)? ");
      
      
      int weight = console.nextInt();
      endWeight+=weight;
      
      
      System.out.print("Score earned? ");
      
      int score = console.nextInt();
      endScore+=score;
      
      
      System.out.print("Were scores shifted (1=yes 2=no)? ");
      
      if (console.nextInt()==1) {
         System.out.print("Shift amount? ");
         if (console.nextInt()+endScore > 100) {
            
            endScore = 100;
         }
         else {
            endScore+=console.nextInt();
         }
      }
      
      System.out.println("Total points: " + endScore + " / 100");
      
      System.out.printf("Weighted score = %.1f / " + weight, (endScore * (endWeight/100)) );
      
      totalGrade+= (endScore * (endWeight/100));
      
      return totalGrade;
      
      
   }
   public static final double finalGrades(Scanner console) {
      
      double endWeight = 0.0;
      double endScore = 0.0;
      double totalGrade = 0.0;
      
      System.out.println();
      
      System.out.println("Final: ");
      System.out.print("Weight (0-100)? ");
      
      
      int weight = console.nextInt();
      endWeight+=weight;
      
      
      System.out.print("Score earned? ");
      
      int score = console.nextInt();
      endScore+=score;
      
      
      System.out.print("Were scores shifted (1=yes 2=no)? ");
      
      if (console.nextInt()==1) {
         System.out.print("Shift amount? ");
         if (console.nextInt()+endScore > 100) {
            
            endScore = 100;
         }
         else {
            endScore+=console.nextInt();
         }
      }
      
      System.out.println("Total points: " + endScore + " / 100");
      
      System.out.printf("Weighted score = %.1f / " + weight, (endScore * (endWeight/100)) );
      
      totalGrade+= (endScore * (endWeight/100));
      
      return totalGrade;
   }
   
   
   
   public static final double homework(Scanner console) {
      
      int weight =0;
      double assignments =0.0;
      double hwkScore=0.0;
      double hwkMax=0.0;
      double sections= 0.0;
      double weightedScore=0.0;
      
      System.out.println();
      System.out.println();
      System.out.println("Homework:");
      System.out.print("Weight (0-100)? ");
      weight+=console.nextInt();
      
      System.out.print("Number of assignments? ");
      assignments+=console.nextInt();
      
      for (int i =1; i<=assignments; i++) {
         System.out.print("Assignment " + i + " score and max? ");
         hwkScore += console.nextInt();
         hwkMax+= console.nextInt();
      }
      
      System.out.print("How many sections did you attend? ");
      sections += console.nextInt();
      
      System.out.println("Section points = " + sections*5 + " / 30");
      System.out.println("Total points = " + (hwkScore + sections*5) + " / " + (hwkMax + 30) );
      
      weightedScore = ( (sections*5 + hwkScore)/(hwkMax+30)  * weight) ;
      
      
      System.out.printf("Weighted score = %.1f / " + weight + "\n" , weightedScore);
      
      return weightedScore;
   }
   
   public static void calculate (double grade1, double grade2, double grade3) {
      
      double grade = grade1+grade2+grade3;
      
      
      
      System.out.printf("Overall percentage = %.1f\n" , grade);
      
      if (grade>85.0) {
         System.out.println("Your grade will be at least: 3.0");
         System.out.println("Nice job!");
      }
      else if (grade >75.0) {
         System.out.println("Your grade will be at least: 2.0");
         System.out.println("Not terrible.");
      }
      else if (grade>60.0) {
         System.out.println("Your grade will be at least: 0.7");
         System.out.println("Might need to hit the books a bit.");
      }
      else {
         System.out.println("Your grade will be at least: 0.0");
         System.out.println("Go home.");
      }
      
   }
}
