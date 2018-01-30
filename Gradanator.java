// Matt Miani
// CSE 142
// TA: Aidan Hunt
// 1/30/18

// This program uses a Scanner to take in user input (a student's exam scores)
// and calculates the student's overall grade in the course. Use of Math objects
// was an important tool.

import java.util.*;

public class Gradanator {
   
   public static final double MAX_D = 100.0;
   public static final int MAX = 100;
   
   public static void main (String [] args) {
      
      Scanner console = new Scanner(System.in);
      
      
      
      double midtermGrade = midGrades(console);
      double finalGrade = finalGrades(console);
      double hwkGrade = homework(console);
      
      calculate(midtermGrade, finalGrade, hwkGrade);
   }
   
   public static final double midGrades(Scanner console) {
      
      int endWeight = 0;
      int endScore = 0;
      
      System.out.println("This program reads exam//homework scores");
      System.out.println("and reports your overall course grade");
      System.out.println();
      
      System.out.println("Midterm: ");
      System.out.print("Weight (0-100)? ");
      
      
      int weight = console.nextInt();
      endWeight+=weight;
      
      
      System.out.print("Score earned? ");
      
      int score = console.nextInt();
      endScore=Math.min(MAX, score);
      
      
      System.out.print("Were scores shifted (1=yes, 2=no)? ");
      
      if (console.nextInt()==1) {
         System.out.print("Shift amount? ");
         endScore=Math.min(MAX, endScore+console.nextInt() );
      }
      
      System.out.println("Total points: " + endScore + " / 100");
      
      double calcWeight = (endScore*(endWeight/MAX_D));
      
      System.out.printf("Weighted score = %.1f / " + weight +"\n", calcWeight);
      
      return calcWeight;
   }
   
   public static final double finalGrades(Scanner console) {
      
      int endWeight = 0;
      int endScore = 0;
      
      System.out.println();
      
      System.out.println("Final: ");
      System.out.print("Weight (0-100)? ");
      
      
      int weight = console.nextInt();
      endWeight+=weight;
      
      System.out.print("Score earned? ");
      
      int score = console.nextInt();
      endScore=Math.min(MAX, score);
      
      
      System.out.print("Were scores shifted (1=yes, 2=no)? ");
      
      if (console.nextInt()==1) {
         System.out.print("Shift amount? ");
         endScore=Math.min(MAX, endScore+console.nextInt() );
         
      }
      
      System.out.println("Total points: " + endScore + " / 100");
      
      double calcWeight = (endScore*(endWeight/MAX_D));
      
      System.out.printf("Weighted score = %.1f / " + weight + "\n", calcWeight);
      
      return calcWeight;
   }
   
   
   
   public static final double homework(Scanner console) {
      int weight =0;
      int assignments =0;
      int hwkScore=0;
      int hwkMax=0;
      int sections= 0;
      double weightedScore=0.0;
      
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
      
      sections = Math.min(30, console.nextInt()*5);
      
      int totalPoints = Math.min(hwkMax+30, sections+hwkScore);
      
      System.out.println("Section points = " + sections + " / 30");
      System.out.println("Total points = " + totalPoints + " / " + (hwkMax + 30) );
      
      weightedScore = ( totalPoints/(hwkMax+30.0)  * weight) ;
      
      
      System.out.printf("Weighted score = %.1f / " + weight + "\n" , weightedScore);
      
      return weightedScore;
   }
   
   public static void calculate (double grade1, double grade2, double grade3) {
      
      double grade = grade1+grade2+grade3;
      
      System.out.println();
      System.out.printf("Overall percentage = %.1f \n" , grade);
      
      if (grade>=85.0) {
         System.out.println("Your grade will be at least: 3.0");
         System.out.println("Nice job!");
      }
      else if (grade >=75.0) {
         System.out.println("Your grade will be at least: 2.0");
         System.out.println("Not terrible.");
      }
      else if (grade>=60.0) {
         System.out.println("Your grade will be at least: 0.7");
         System.out.println("Might need to hit the books a bit.");
      }
      else {
         System.out.println("Your grade will be at least: 0.0");
         System.out.println("Go home.");
      }
      
   }
}
