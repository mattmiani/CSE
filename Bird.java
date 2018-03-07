import java.util.*; 
import java.awt.*; 



public class Bird extends Critter { 
   public int moves=0; 
   public String symbol = ""; 
   
   
   public Bird () { 
   
  }
   
         public Color getColor() { 
          return Color.BLUE; 
            } 
            
        public Attack fight(String opponent) { 
            if (opponent=="%"){ 
               return Attack.ROAR; 
               } 
               else { 
               return Attack.POUNCE;
               } 
             } 
           
           
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