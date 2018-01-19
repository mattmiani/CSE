// Matt Miani 
// CSE 142 
// TA: Aidan Hunt 
// 1/18/18
// This program uses the Graphics and DrawingPanel methods
// to create a series of specified subfigures, consisting of different arrangements of 
// concentric circles. 



import java.awt.*; 

public class Circles { 
   public static void main (String [] args) { 
      
      //initialize graphics setup 
      
      DrawingPanel panel = new DrawingPanel(500, 350); 
      Graphics g = panel.getGraphics(); 
      
      panel.setBackground(Color.CYAN); 
      
      drawCircles(g, 0, 0, 100, 10); //draw the first four subfigures 
      drawCircles(g, 130, 25, 100, 10); 
      drawCircles(g, 260, 0, 60, 6); 
      drawCircles(g, 360, 50, 80,  4); 
     
        
      
      
            
     drawGrid(g, 10, 170, 48, 4, 3); //draws the three grids with subfigures
     drawGrid(g, 180, 200, 24, 2, 5);
     drawGrid(g, 330, 170, 72, 9, 2); 
      
     
}
      public static void drawCircles(Graphics g, int a, int b, int c, int num) { 
      //arguments are x/y position, size of circle, and number of total circles in the subfigure 
        g.setColor(Color.YELLOW); //set color to yellow
        g.fillOval(a, b, c, c); //background circle 
        
        g.setColor(Color.BLACK);   //reset to black   
          
         for (int circles = 0; circles<= num-1; circles++) { 
            g.drawOval(a+ (c/num/2*circles) , (b+ c/num/2*circles), c-(c/num*circles), c-(c/num*circles) ); 
            }  //draws progressively smaller concentric circles
         }
         
      public static void drawGrid(Graphics g, int pos, int pos2, int size, int num, int grid) { 
       //takes x/y position, size of circles, # of inner circles, and # of rows/cols
       
        //draws grid for circles 
         g.setColor(Color.GREEN); 
         g.fillRect(pos, pos2, grid*size, grid*size); 
         g.setColor(Color.BLACK); 
         g.drawRect(pos, pos2, grid*size, grid*size);
        
        
         for (int rows =0; rows<=grid-1; rows++) {
         
               pos2 = pos2 + size; 
               
            for(int number = 0; number<= grid-1; number++) { 
            
             drawCircles(g, pos+(size*number), pos2-size, size, num); 
             
                 }
             }
             
             pos2=pos2;
              //draws lines across grid 
           g.drawLine(pos, pos2, pos+grid*size, pos2-grid*size); 
           g.drawLine(pos, pos2-grid*size, pos+grid*size, pos2); 
          
        } 
            

}    