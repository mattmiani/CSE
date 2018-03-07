//Matt Miani
//CSE 142
//TA: Aidan Hunt
//Hippo class for Critter simulation. Moves in a random direction for
//five turns, then picks a new direction.
//Constructed with an integer telling it how many times to eat food;
//will stop eating food after the requisite number of times.
//Fighting behavior depends on hunger level.

import java.awt.*;
import java.util.*;

public class Hippo extends Critter {
   
   public int moves = 0;
   
   public int hunger = 0;
   
   public int timesEaten = 0;
   
   public String symbol = "";
   
   public int limit = 0;
   
   public Attack fight = Attack.POUNCE;
   
   public Direction dir;
   
   public Color color = Color.GRAY;
   
   public int random;
   
   Random r = new Random();
   
   //constructor, takes integer for hunger level
   public Hippo (int hunger) {
      
      hunger = hunger;
      timesEaten = hunger;
      limit = hunger;
      
   }
   //eats for a certain number of turns depending on the constructor
   //integer value.
   //eating also controls fighting and color behavior
   public boolean eat() {
      timesEaten--;
      if (timesEaten>0){
         symbol = "" + timesEaten;
         fight = Attack.SCRATCH;
         color = Color.GRAY;
         return true;
      }
      else  {
         symbol = "" + 0;
         fight = Attack.POUNCE;
         color = color.WHITE;
         return false;
      }
   }
   
   public Color getColor() {
      return color;
   }
   
   
   public String toString() {
      return symbol;
   }
   
   public Attack fight(String opponent) {
      return fight;
   }
   //moves in a random direction for 5 moves
   public Direction getMove(){
      moves++;
      
      if (moves<=4){
         
         if (random ==0){
            dir=Direction.NORTH;
         }
         if (random ==1){
            dir=Direction.EAST;
         }
         if (random ==2){
            dir=Direction.WEST;
         }
         if (random ==3) {
            dir=Direction.SOUTH;
         }
      } else {
         moves=0;
         random = r.nextInt(4);
      }
      
      return dir;
      
   }
   
}


