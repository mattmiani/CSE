//Matt Miani
//CSE 142
//TA: Aidan Hunt
//Ant class for Critter simulation. Constructed with boolean parameter
//to determine movement behavior.

import java.util.*;
import java.awt.*;

public class Ant extends Critter {
   
   int moves =0; //move counter
   public boolean south; //used for movement
   
   //constructor
   public Ant (boolean walkSouth){
      
      if (walkSouth) {
         south = true;
      }
      else {
         south=false;
      }
   }
   //Color always returns red
   public Color getColor() {
      return Color.RED;
   }
   //Always eats
   public boolean eat() {
      return true;
   }
   //Always scratches in a fight
   public Attack fight(String opponent) {
      return Attack.SCRATCH;
   }
   
   //alternates between north/south and east, depending
   //on the value of 'south'
   public Direction getMove() {
      moves++;
      if (moves==2){
         moves=0;
      }
      if (moves%2==0) {
         
         if (south==true) {
            return Direction.NORTH;
         }
         else{
            return Direction.SOUTH;
         }
      }
      else{
         return Direction.EAST;
      }
   }
   //always returns %
   public String toString() {
      return "%";
   }
}