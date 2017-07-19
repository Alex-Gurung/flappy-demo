import java.awt.Color;
import java.awt.Graphics;





public class Bumper
{
   private int myX;
   private int myY;
   private int myXWidth;
   private int myYWidth;
   private Color myColor;
   
 
   
   public Bumper(int x, int y, int yWidth, Color c) {
      myX = x;
      myY = y;
      myXWidth = 25;
      myYWidth = yWidth;
      myColor = c;
   }
   

   public int getX()
   {
      return myX;
   }
   
   public int getY() {
      return myY;
   }
   
   public int getXWidth() {
      return myXWidth;
   }
   
   public int getYWidth() {
      return myYWidth;
   }
   
   public Color getColor() {
      return myColor;
   }
   

   public void setX(int x)
   {
      myX = x;
   }
   
   public void setY(int y) {
      myY = y;
   }
   
   public void setXWidth(int xWidth) {
      myXWidth = xWidth;
   }
   
   public void setYWidth(int yWidth) {
      myYWidth = yWidth;
   }
   
   public void setColor(Color c) {
      myColor = c;
   }
   



   
   public void draw(Graphics myBuffer)
   {
      myBuffer.setColor(getColor());
      myBuffer.fillRect(getX(), getY(), getXWidth(), getYWidth());
      myBuffer.setColor(Color.BLACK);
      myBuffer.drawRect(getX(), getY(), getXWidth(), getYWidth());
   }
   

   // public boolean inBumper(Polkadot dot)
   // {
      // //System.out.println(getX() + " " + getY());
      // //System.out.println(getXWidth() + " " + getYWidth());
      // //System.out.println(dot.getX() + " " + dot.getY());
      // //System.out.println();
      // if(getX() - dot.getRadius() <= dot.getX() && getX() + getXWidth() + dot.getRadius() >= dot.getX()){
         // if(dot.getY() + dot.getRadius() >= getY() && dot.getY() - dot.getRadius() <= getY() + getYWidth()){
         //    
         //   //System.out.println(getX() + " " + getY());
      // //System.out.println(getXWidth() + " " + getYWidth());
      // //System.out.println(dot.getX() + " " + dot.getY());
      // //System.out.println();
// 
            // return true;
         // }
      // }
   //   //double d = distance(getX(), getY(), dot.getX(), dot.getY())
   //    // for (int x = getX(); x <= getX() + getXWidth(); x++)
   //       // for (int y = getY(); y <= getY() + getYWidth(); y++)
   //          // if (distance(x, y, dot.getX(), dot.getY()) <= dot.getRadius())
   //             // return true;
      // return false;
   // }
   

   private double distance(double x1, double y1, double x2, double y2)
   {
      return Math.sqrt(Math.pow(x1 - x2, 2.0D) + Math.pow(y1 - y2, 2.0D));
   }
}