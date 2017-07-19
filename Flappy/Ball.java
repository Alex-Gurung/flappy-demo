import java.awt.*;
public class Ball extends Polkadot
{
   private double dx;
   private double dy;
   private double ax, ay;
      
   private final double LOSS = 1;
   public Ball()
   {
      super(200, 200, 50, Color.BLACK);
      dx = .6;
      //dy = Math.random() * 4 - 2;
      dy = 0;
      ax = 0;
      ay = .1;//-2;
        
   }
   public Ball(double x, double y, double dia, Color c)
   {
      super(x, y, dia, c);
      dx = .6;
      //dy = Math.random() * 12 - 6;
      dy = 0;
      ax = 0;
      ay = .1;//-2;
         
   }
   public void setdx(double x)        
   {
      dx = x;
   }
   public void setdy(double y)
   {
      dy = y;
   }
   public double getdx()             
   {
      return dx;
   }
   public double getdy()
   {
      return dy;
   }
      
   public void setax(double x)        
   {
      ax = x;
   }
   public void setay(double y)
   {
      ay = y;
   }
   public double getax()             
   {
      return ax;
   }
   public double getay()
   {
      return ay;
   }
          //instance methods
   public void move(double rightEdge, double bottomEdge)
   {
         
         
      setX(getX()+ dx + 0.5*ax); 
      setY(getY()+ dy + 0.5*ay);       
      setdx(getdx() + ax);
      setdy(getdy() + ay);            // x = x + dx
         
         //setX(getX() + getdx()*t + (0.5)*getax()*t*t);
         //setY(getY() + getdy()*t + (0.5)*getay()*t*t);
         //
        // check for left & right edge bounces
      if(getX() >= rightEdge - getRadius())     //hits the right edge
      {
         setX(rightEdge - getRadius());
         dx = 0;
      }
      else if(0 >= getX() - getRadius())
      {
         setX(getRadius()); 
         dx=0;
      }
       if(getY() >= bottomEdge - getRadius())
      {
         setY(bottomEdge - getRadius());
         dy = 0;
      }
      else if (0 >= getY() - getRadius())
      {
         setY(getRadius());
         dy = 0;
      }
        
   }
}