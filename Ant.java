import java.util.*; 
import java.awt.*; 

public class Ant extends Critter { 

int moves =0; 
public boolean south;
   
      public Ant (boolean walkSouth){ 
            
          if (walkSouth) { 
            south = true; 
            } 
          else { 
          south=false; 
          } 
          }
      public Color getColor() { 
         return Color.RED; 
         } 
   
      public boolean eat() { 
          return true; 
        } 
      
      public Attack fight(String opponent) { 
         return Attack.SCRATCH;
         } 
         
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
                
        public String toString() { 
         return "%"; 
         } 
}