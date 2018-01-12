// Matt Miani
// CSE 142
// TA: Aidan Hunt
// 1/11/18

// This program prints an ASCII version of the Seattle Space Needle,
// and makes use of a class constant to control the scale of the entire figure.
// The program consists of print/println statements and nested for() loops.





public class SpaceNeedle {
   public static void main(String[] args ) {
      
      drawTop(); //top of needle
      drawTopDome();
      drawBottomDome();
      drawTop();
      drawMid();
      drawTopDome();
      
   }
   
   public static int constant = 10; //class constant to determine scale
   
   public static void drawTop(){ //draws the top of the needle
      
      for (int lines =1; lines <= constant; lines++) {
         System.out.println();
         
         for (int space =1; space <= 3*constant; space++) {
            System.out.print(" ");
         }
         
         for (int bar=1; bar<=1; bar++){
            System.out.print("||");
            
         }
      }
   }
   
   
   public static void drawTopDome() { //draws the top half of the dome
      
      for ( int lines = 1; lines<=constant; lines++){
         
         System.out.println();
         
         for (int space=1; space<=(3*constant)-(3*lines); space++){
            System.out.print(" ");
            
         }
         
         for (int edge = 1; edge<=1; edge++) {
            System.out.print("__/");
         }
         for (int dots =1; dots <= 3*(lines-1); dots++) {
            System.out.print(":");
         }
         
         for (int midBar =1; midBar<=1; midBar++){
            System.out.print("||");
         }
         
         for (int rightDots =1; rightDots <= 3*(lines-1); rightDots++) {
            System.out.print(":");
         }
         
         for (int rightEdge =1; rightEdge<=1; rightEdge++) {
            System.out.print("\\__");
         }
      }
      System.out.println();
      
      for (int line=1; line<=1; line++) {
         System.out.print("|");
         
         for (int quote=1; quote<=6*constant; quote++){
            System.out.print("\"");
         }
         System.out.print("|");
         
      }
      
      
   }
   
   
   public static void drawBottomDome(){ //draws the bottom half of the dome
      
      for (int lines = 1; lines<= constant; lines++) {
         System.out.println();
         
         for (int space = 1; space<= 2*(lines-1); space++) {
            System.out.print(" ");
         }
         for (int leftEdge=1; leftEdge <= 1;leftEdge++) {
            System.out.print("\\_/");
         }
         for (int slashes =1; slashes <= (constant + constant/2)-lines; slashes++) {
            System.out.print("\\/");
         }
         for (int rightSlashes=1; rightSlashes<=(constant+constant/2)-lines; rightSlashes++) {
            System.out.print("\\/");
         }
         for (int rightEdge=1; rightEdge<=1; rightEdge++) {
            System.out.print("\\_/");
         }
         
      }
   }
   
   
   public static void drawMid(){ //draws the midsection of the tower
      for (int lines =1; lines<=constant*constant; lines++) {
         System.out.println();
         
         for (int space =1; space<=(3*constant-3); space++){
            System.out.print(" ");
         }
         for (int leftSide=1; leftSide<=1; leftSide++) {
            System.out.print("|%%||%%|");
         }
      }
   }
   
   
   
   
   
}


