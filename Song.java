public class Song { 

public static void main (String [] args) { 

writeSong(); 

} 

//design 
//for each verse (iteration), the following changes:
// last word of the first line 
//the second line (rhyming line) 
//add a "swallowed _ to catch the _" line 
//last two lines never change 
public static void writeSong() 
{ 
firstVerse(); 
secondVerse(); 
thirdVerse(); 
fourthVerse();
fifthVerse();  
sixthVerse(); 
seventhVerse(); 
} 


public static void firstVerse() 
{ 
System.out.println("There was an old woman who swallowed a fly."); 
lastLines(); 
} 
public static void secondVerse() { 
System.out.println("There was an old woman who swallowed a spider,"); 
System.out.println("That wriggled and iggled and jiggled inside her."); 
System.out.println("She swallowed the spider to catch the fly,"); 
lastLines(); 
}

public static void thirdVerse() 
{ 
System.out.println("There was an old woman who swallowed a bird,"); 
System.out.println("How absurd to swallow a bird."); 
System.out.println("She swallowed the bird to catch the spider,");
System.out.println("She swallowed the spider to catch the fly,"); 
lastLines(); 
}

public static void fourthVerse() 
{ 
System.out.println("There was an old woman who swallowed a cat,");
System.out.println("Imagine that to swallow a cat.");
System.out.println("She swallowed the cat to catch the bird,");
System.out.println("She swallowed the bird to catch the spider,");
System.out.println("She swallowed the spider to catch the fly,"); 
lastLines(); 
} 

public static void fifthVerse() 
{ 
System.out.println("There was an old woman who swallowed a dog,");
System.out.println("What a hog to swallow a dog.");
System.out.println("She swallowed the dog to catch the cat,");
System.out.println("She swallowed the cat to catch the bird,");
System.out.println("She swallowed the bird to catch the spider,");
System.out.println("She swallowed the spider to catch the fly,"); 
lastLines(); 
} 

public static void sixthVerse() 
{
System.out.println("There was an old woman who swallowed a snake,");
System.out.println("What a meal to undertake.");
System.out.println("She swallowed the snake to catch the dog,");
System.out.println("She swallowed the dog to catch the cat,");
System.out.println("She swallowed the cat to catch the bird,");
System.out.println("She swallowed the bird to catch the spider,");
System.out.println("She swallowed the spider to catch the fly,"); 
lastLines(); 
} 


public static void seventhVerse() 
{ 
System.out.println("There was an old woman who swallowed a horse,");
System.out.println("She died of course.");
} 

public static void lastLines()
//prints the last two lines of the verse  
{
System.out.println("I don't know why she swallowed that fly,"); 
System.out.println("Perhaps she'll die."); 
System.out.println(); 
} 

//System.out.println("");



} 
