//Matt Miani
//CSE 142
//TA: Aidan Hunt
//Vulture class for Critter simulation. Eating behavior
//depends on whether the vulture has recently fought or not


import java.awt.*;
import java.util.*;

public class Vulture extends Critter {
   public int moves = 0;
   public String symbol = "";
   
   public int eating = 1; //keeps track of whether the vulture will eat
   
   //constructor
   
   public Vulture (){
      
   }
   //eating depends on whether the vulture has fought recently
   public boolean eat() {
      
      if (eating==0){
         return false;
      }
      else {
         eating=0;
         return true;
         
      }
      
   }
   
   //fighting behavior
   //roars at ants, pounces on others
   public Attack fight(String opponent) {
      eating++;
      if (opponent == "%") {
         return Attack.ROAR;
      }
      else{
         return Attack.POUNCE;
      }
   }
   
   //movement behavior
   //moves in clockwise pattern, 3 spaces each time
   //changes toString behavior
   public Direction getMove() {
      
      if (moves>11) {
         moves = 0;
      }
      moves++;
      //Direction move = Direction.NORTH;
      
      if(moves<=3){
         symbol = "^";
         return Direction.NORTH;
      }
      if(moves<=6){
         symbol = "<";
         return Direction.WEST;
      }
      if(moves<=9){
         symbol = "V";
         return Direction.SOUTH;
      }
      else{
         symbol = ">";
         return Direction.EAST;
         
      }
   }
   
   //String depends on movement
   public String toString() {
      return symbol;
   }
   
}