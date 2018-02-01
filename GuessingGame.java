import java.util.*;

public class GuessingGame {
	
	public static int gamesPlayed = 0;
	
	public static int totalGuesses = 0;
	
	public static int firstGuesses = 0;
	public static int currentGuesses = 0;
	
	public static int best = 0;
	
	public static int lastGame = 0;
	public static int whichGame = 0;
	
	public static void main (String [] args) {
		
		Scanner console = new Scanner(System.in);
		
		//prompt to play
		guess(console);
		//method to play again
		playAgain(console);
		//best guess
		//stats
		
	}
	
	
	public static void guess (Scanner console) {
		
		gamesPlayed++;
		Random r = new Random();
		
		
		int target = r.nextInt(100) + 1;
		
		int guesses = 0;
		
		int guess = 0;
		
		System.out.println(target);
		System.out.println("I'm thinking of a number between 1 and 100...");
		System.out.print("Your guess? ");
		
		
		while (guess!=target) {
			guess= 0;
			
			
			
			guesses++;
			totalGuesses++;
			
			guess+=console.nextInt();
			
			if (guess>target) {
				System.out.println("It's lower.");
			}
			else if (guess<target) {
				System.out.println("It's higher.");
			}
			System.out.print("Your guess? ");
			
		}
		whichGame++;
		
		if (gamesPlayed == 1) {
			firstGuesses+=guesses;
			best = 1;
			//the best game is the first one
		}
		else {
			best = bestGame(firstGuesses, guesses, whichGame);
			//run the comparison with the first number of guesses as lastWin, the current number of guesses as currentGuesses, and game number as currentGame
		}
		
		
		System.out.println();
		System.out.println("You got it right in " + guesses + " guesses!");
		playAgain(console);
		
	}
	
	
	public static void playAgain(Scanner console) {
		
		System.out.print("Do you want to play again? ");
		
		String answer = console.next();
		
		if (answer.charAt(0) == 'y') {
			
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
	
	public static final int bestGame (int guesses1, int guesses2, int currentGame) {
		
		//guesses1 = previous lowest number of guesses
		//guesses2 = number of guesses from the current game
		
		//the first time around, the lowest will just be the current guesses since only one game has been played
		//start checking on the second time through
		
		//if gamesPlayed>2, check the lowest against the current (start running the method)
		//for the first time, lowest=current
		
		
		//need to define parameters
		//method is checking if game2 or game2 has a lower number of guesses
		
		//if playing game 6 and the previous winner was game number 2
		// lastWin = 2 and currentGame = 6
		
		int lastWin = 0;
		int winningGame = 1;
		
		int bestGuesses = Math.min(guesses1, guesses2);
		
		if (bestGuesses == guesses1) {
			
			lastWin = guesses1;
		}
		
		else {
			lastWin =guesses2;
			
			winningGame = currentGame;
			
		}
		return winningGame;
		
	}
}






