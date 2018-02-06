//Matt Miani
//CSE 142
//TA: Aidan Hunt
// 2/4/18

//This program prompts the user to guess a randomly generated number.
//It records the number of total guesses, the guesses per game,
//and the game with the lowest number of guesses.
//While() loops and conditional statements were important parts of this program.

import java.util.*;

public class GuessingGame {
   
   public static int gamesPlayed = 0;
   public static int whichGame = 0;
   
   
   public static int totalGuesses = 0;
   
   public static int firstGuesses = 0;
   public static int currentGuesses = 0;
   
   public static int best = 0;
   
   public static void main (String [] args) {
      
      Scanner console = new Scanner(System.in);
      
      guess(console);
      
      
   }
   
   
   public static void guess (Scanner console) {
      
      gamesPlayed++;
      Random r = new Random();
      
      
      int target = r.nextInt(100) + 1;
      
      int guesses = 0;
      
      int guess = 0;
      
      //print out target for testing
      //	System.out.println(target);
      System.out.println("I'm thinking of a number between 1 and 100...");
      System.out.print("Your guess? ");
      
      
      while (guess!=target) {
         guess= 0; //initialize guess at the beginning of the loop
         
         
         
         guesses++; //add one to guess counter (for that game)
         totalGuesses++; //add one to TOTAL number of guesses
         
         guess+=console.nextInt();
         
         if (guess>target) {
            System.out.println("It's lower.");
         }
         else if (guess<target) {
            System.out.println("It's higher.");
         }
         System.out.print("Your guess? ");
         
      }
      whichGame++; //add one to number of games played
      
      if (gamesPlayed == 1) {
         firstGuesses+=guesses;
         best = 1;
         //the best game will be the first one
      }
      else {
         best = bestGame(firstGuesses, guesses, whichGame);
         //the first comparison will be between the first number of guesses and the second
         //and whichGame will be the game currently being played
      }
      
      //asks player if they want to play again
      System.out.println();
      System.out.println("You got it right in " + guesses + " guesses!");
      playAgain(console);
      
   }
   
   
   public static void playAgain(Scanner console) {
      
      System.out.print("Do you want to play again? ");
      
      String answer = console.next();
      
      if (answer.startsWith("y")|| answer.startsWith("Y") ) {
         
         guess(console);
      }
      else {
         stats();
      }
      
   }
   
   public static void stats() {
      System.out.println("Overall results:");
      System.out.println("Total games   = " + gamesPlayed);
      System.out.println("Total guesses = " + totalGuesses);
      System.out.println("Guesses/game  = " + totalGuesses/gamesPlayed);
      System.out.println("Best game     = " + best);
      
   }
   
   
   
   //guesses1 = previous lowest number of guesses
   //guesses2 = number of guesses from the current game
   
   //the first time around, the lowest will just be the current guesses since only one game has been played
   //start checking on the second time through
   
   //if gamesPlayed>2, check the lowest against the current (start running the method)
   //for the first time, lowest=current
   
   
   //method is checking if the number of guesses associated with currentGame
   //is less than 'lastWin' (the previous lowest number of guesses)
   
   
   //if playing game 6 and the previous winner was game number 2
   // lastWin = 2 and currentGame = 6
   
   
   public static final int bestGame (int guesses1, int guesses2, int currentGame) {
      
      
      int lastWin = 0;
      int winningGame = 1; //winning game will be 1 the first time this runs
      
      
      int bestGuesses = Math.min(guesses1, guesses2); //find lowest number of guesses
      
      if (bestGuesses == guesses1) {
         
         lastWin = guesses1; //winner doesn't change
      }
      
      else {
         lastWin =guesses2;
         
         winningGame = currentGame; //change winning game
         
      }
      return winningGame;
      
   }
}






