//Matt Miani 
//CSE 142
//TA: Aidan Hunt 
//

import java.util.*; 
import java.awt.*; 


public class Husky extends Critter { 


public int moves = 0; 
public boolean south; 
public boolean hunt = true; 
public int movement = 0; 
public Direction dir = Direction.NORTH;
public Attack fight; 
String symbol = "";  
public int random; 
public int pretend; 

      Random r = new Random(); 
      
      public Husky(){ 
      
      chooseHunter(); 
      choosePretend(); 
      
      movement = r.nextInt(4); 
       
      } 
      public void chooseHunter(){ 
      int hunting = r.nextInt(1); 
      
      if (hunting==1){ 
         hunt = true; 
         south = true; 
         } 
         else { 
         south = false; 
         hunt = false; 
         } 
      }
      public void choosePretend() { 
      
      pretend = r.nextInt(7); 
      
      switch(pretend) { 
         case 0: symbol = "%"; 
            break; 
         case 2: symbol = "^"; 
            break;
         case 3: symbol = "<"; 
            break;
         case 4: symbol = ">"; 
            break;
         case 5: symbol = "^"; 
            break;
         case 6: symbol = "5"; 
            break;
         case 7: symbol = "H"; 
            break;
        } 
        
       } 
      
      public Color getColor () { 
      
          return Color.YELLOW; 
      } 
      
      public String toString() { 
         return symbol; 
        } 
        
     public boolean eat() { 
     if (hunt){ 
      return false;
      } else { 
         return true; 
         } 
        } 
             public Attack fight(String opponent) { 
         
         switch(symbol) { 
    
         case "%": fight = Attack.POUNCE; 
            break; 
            //pretending to be a bird 
            //ants will expect R, otherwise S 
               //switch for this 
            //ants 
         case "V": fight = BIRD_TRICK(opponent); 
            break; 
         case "<": fight = BIRD_TRICK(opponent); 
            break; 
         case ">": fight = BIRD_TRICK(opponent); 
            break; 
         case "^": fight = BIRD_TRICK(opponent); 
            break; 
         case "0": fight = Attack.ROAR; 
            break;
         case "S": fight = Attack.SCRATCH; 
            break; 
         default : fight = Attack.SCRATCH; 
         } 
         return fight; 
        }
public Attack BIRD_TRICK (String s) {
   switch (s) {
      case "%": fight = Attack.ROAR;
      break;
      case "V": fight = Attack.SCRATCH;
      break;
      case "<": fight = Attack.SCRATCH;
      break;
      case ">": fight = Attack.SCRATCH;
      break;
      case "^": fight = Attack.SCRATCH;
      break;
      case "0": fight = Attack.POUNCE;
      break;
      case "S": fight = Attack.POUNCE;
      break;
      default : fight = Attack.ROAR;
   }
   return fight;
}

      
      public Direction getMove(){  
      
      switch (movement) { 
            case 0: dir = antMove(); 
                break; 
            case 1: dir = birdMove(); 
                break; 
            case 2: dir = hippoMove(); 
                break; 
            case 3: dir = vultureMove(); 
               break; 
                  } 
               return dir; 
               
              } 
      
      
      
         public Direction antMove(){ 
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
                
           public Direction birdMove() { 
           
           int count = r.nextInt(4);
           
            if (moves>12+count) { 
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
           
           public Direction hippoMove() { 
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
           
           public Direction vultureMove() { 
           
           if (moves>13) { 
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

         } 
        
         

   