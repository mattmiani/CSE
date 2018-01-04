//Matt Miani
// 1/3/18
//
//CSE 142 A
//Assignment: HWK 1 (Song)
// This program prints a cumulative song consisting of seven verses, with the first six building on each other
// and the seventh departing from the formula to end it.
// It concerns a rather interesting old woman.



public class Song {
   
   public static void main (String [] args) {
      
      writeSong();
      
   }
   
   //design:
   //for each verse (iteration), the following changes:
   //last word of the first line
   //the second line (rhyming line)
   //add a "swallowed _ to catch the _" line
   //last two lines never change
   
   
   
   public static void writeSong() //"master" method for clean organization
   {
      firstVerse();
      secondVerse();
      thirdVerse();
      fourthVerse();
      fifthVerse();
      sixthVerse();
      seventhVerse();
   }
   
   
   public static void firstVerse() //prints the first verse of the song
   {
      System.out.println("There was an old woman who swallowed a fly.");
      lastLines();
   }
   
   public static void secondVerse() //prints the second verse of the song
   {
      System.out.println("There was an old woman who swallowed a spider,");
      System.out.println("That wriggled and iggled and jiggled inside her.");
      catchFly();
      lastLines();
   }
   
   public static void thirdVerse() //prints the third verse of the song
   {
      System.out.println("There was an old woman who swallowed a bird,");
      System.out.println("How absurd to swallow a bird.");
      catchSpider();
      catchFly();
      lastLines();
   }
   
   public static void fourthVerse() //prints the fourth verse of the song
   {
      System.out.println("There was an old woman who swallowed a cat,");
      System.out.println("Imagine that to swallow a cat.");
      catchBird();
      catchSpider();
      catchFly();
      lastLines();
   }
   
   public static void fifthVerse() //prints the fifth verse of the song
   {
      System.out.println("There was an old woman who swallowed a dog,");
      System.out.println("What a hog to swallow a dog.");
      catchCat();
      catchBird();
      catchSpider();
      catchFly();
      lastLines();
   }
   
   public static void sixthVerse() //prints the sixth verse of the song
   {
      System.out.println("There was an old woman who swallowed a snake,");
      System.out.println("What a meal to undertake.");
      catchDog();
      catchCat();
      catchBird();
      catchSpider();
      catchFly();
      lastLines();
   }
   
   
   public static void seventhVerse() //prints the last verse of the song
   {
      System.out.println("There was an old woman who swallowed a horse,");
      System.out.println("She died of course.");
   }
   
   public static void lastLines()
   //prints the last two lines of the verse
   //these are constant, so use this method instead of writing out more println statements
   {
      System.out.println("I don't know why she swallowed that fly,");
      System.out.println("Perhaps she'll die.");
      System.out.println(""); //blank line to separate verses
   }
   
   public static void catchDog() //prints the "to catch the dog" line
   {
      System.out.println("She swallowed the snake to catch the dog,");
      
   }
   
   public static void catchCat() //prints the "to catch the cat" line
   {
      System.out.println("She swallowed the dog to catch the cat,");
      
   }
   
   public static void catchBird() //prints the "to catch the bird" line
   {
      System.out.println("She swallowed the cat to catch the bird,");
      
   }
   
   public static void catchSpider() //prints the "to catch the spider" line
   {
      System.out.println("She swallowed the bird to catch the spider,");
      
   }
   
   public static void catchFly() //prints the "to catch the fly" line
   {
      System.out.println("She swallowed the spider to catch the fly,");
      
   }
   
}
