//Author: Matt Miani
//CSE 143, Spring 2018
//Homework 1: Letter Inventory

// Class which takes a string as a parameter and constructs a LetterInventory object
// containing an array with the counts of each letter in that string.

public class LetterInventory {
   
   private int size = 26; //size of list
   private int[] letters = new int[size]; //list of letter counts
   private int sum; //total sum of all letter counts
   private static final int START = 97; //beginning of ASCII values for lowercase alphabet
   private static final int END = 122; //end of ASCII values for lowercase alphabet
   
   
   //post: constructs LetterInventory object
   //letters[] will contain counts of every letter at their respective index 0-25
   //for example, if a parameter of "aaaa" is passed, letters[0]=4
   //the total sum of letter counts is incremented for every letter in the string
   public LetterInventory (String data) {
      
      String lowerCaseData=data.toLowerCase();
      
      for (int i=0; i<lowerCaseData.length(); i++){
         char thisChar = lowerCaseData.charAt(i);
         
         for (char testChar = 'a'; testChar<= 'z'; testChar++) {
            if (thisChar==(testChar)) {
               letters[thisChar-START]++;
               sum++;
            }
         }
      }
   }
   //returns the total letter counts of this LetterInventory object
   public int size() {
      return sum;
   }
   //pre: value>0 (throws IllegalArgumentException if not)
   //letter is an alphabetic character (case insensitive); throws above exception if not
   //post: count of "letter" is set to value; eg, set('a', 10) would set letters[0]=10
   public void set(char letter, int value) {
      if (value<0) {
         throw new IllegalArgumentException();
      }
      int target = indexOf(letter);
      sum += (value- get(letter));
      letters[target] = value;
   }
   //pre: letter is an alphabetic character(case insensitve); throws IllegalArgumentException if not
   //post: returns count of letters at the specified index
   //example: if letters[0]=12, then get('a') would return a value of 12
   public int get (char letter) {
      
      int test = (int)(Character.toLowerCase(letter));
      
      validIndex(test);
      return letters[test-START];
      
   }
   
   //pre: letter is an alphabetic character(case insensitve); throws IllegalArgumentException if not
   //post: returns index of given character
   //example: indexOf('a') would return 0
   //for use with set()
   private int indexOf(char letter) {
      
      letter = Character.toLowerCase(letter);
      int test = (int)(letter);
      validIndex(test);
      return test-START;
      
   }
   private void validIndex(int test) {
      if (test<START || test>END) {
         throw new IllegalArgumentException();
      }
      
      
   }
   //post: evaluates whether or not the entire inventory is empty (all counts are 0)
   public boolean isEmpty() {
      return (sum==0);
   }
   
   //returns sorted string representation of all letters in the parameter string
   public String toString() {
      
      String result = "";
      if (sum<0){
         return "[]";
      }
      result+=("[");
      
      for (int i = 0; i<size; i++){
         
         for (int j=0; j<letters[i]; j++) {
            
            result+=(char)(i+'a');
         }
      }
      result+=("]");
      
      return result;
      
   }
   
   //pre: a real LetterInventory object is passed as a parameter (will not compile otherwise)
   //post: creates a new LetterInventory object newLetters where newLetters.letters[i]
   //is the sum of other.letters[i] and letters[i] of the object that add() is called on
   //example: if other.letters[0] and letters1.letters[0] are both 10,
   //then letters1.add(other) will create newLetters where newLetters[0]=20
   public LetterInventory add(LetterInventory other) {
      LetterInventory newLetters = new LetterInventory("");
      
      for (int i = 0; i<size; i++) {
         newLetters.letters[i] = this.letters[i] + other.letters[i];
      }
      newLetters.sum = this.size() + other.size();
      return newLetters;
   }
   
   //pre: a real LetterInventory object is passed as a parameter (will not compile otherwise)
   //post: similar to add()
   //creates a new LetterInventory object newLetters where newLetters.letters[i]
   //is the difference of other.letters[i] and letters[i] of the object that subtract() is called on
   public LetterInventory subtract(LetterInventory other) {
      LetterInventory newLetters = new LetterInventory("");
      
      for (int i = 0; i<size; i++) {
         newLetters.letters[i] = this.letters[i] - other.letters[i];
         if(newLetters.letters[i]<0) {
            return null;
         }
      }
      newLetters.sum = this.size() - other.size();
      if(newLetters.sum<0) {
         return null;
      } else {
         return newLetters;
      }
   }
}
