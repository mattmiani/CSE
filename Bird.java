//Matt Miani
//CSE 142
//TA: Aidan Hunt
//Bird class for critter simulation.

import java.util.*;
import java.awt.*;



public class Bird extends Critter {
   public int moves=0; //move counter
   public String symbol = "";  //string representation
   
   
   public Bird () {
      
   }
   //always returns blue
   public Color getColor() {
      return Color.BLUE;
   }
   //roars at ants, pounces at others
   public Attack fight(String opponent) {
      if (opponent=="%"){
         return Attack.ROAR;
      }
      else {
         return Attack.POUNCE;
      }
   }
   
   //moves in a counterclockwise box for 3 moves each
   //String depends on movement direction
   public Direction getMove() {
      
      
      if (moves>11) {
         moves = 0;
      }
      moves++;
      
      if(moves<=3){
         symbol = "^";
         return Direction.NORTH;
      }
      if(moves<=6){
         symbol = ">";
         return Direction.EAST;
      }
      if(moves<=9){
         symbol = "V";
         return Direction.SOUTH;
      }
      else{
         symbol = "<";
         return Direction.WEST;
         
      }
      
   }
   
   public String toString() {
      return symbol;
   }
   
}