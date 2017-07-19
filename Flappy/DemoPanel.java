import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
public class DemoPanel extends JPanel
{
   private static final int FRAME1 = 600;
   private static final int FRAME2 = 600;
   private int count = 0;
   private static final Color BACKGROUND = new Color(204, 204, 204);
   private BufferedImage myImage;
   private Graphics myBuffer;
   private Ball ball;
   private Barrier b1, b2, b3;
   private Timer t, g;
   private boolean hasLost = false;
     //constructor   
   public DemoPanel()
   {
      myImage =  new BufferedImage(FRAME1, FRAME2, BufferedImage.TYPE_INT_RGB);
      myBuffer = myImage.getGraphics();
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0, 0, FRAME1,FRAME2);
      ImageIcon j = new ImageIcon("background.png");
      myBuffer.setFont(new Font("Lucida Bright", Font.PLAIN, 8));
      myBuffer.drawString("Count: " + count, 10, 20);
      myBuffer.drawImage(j.getImage(), 0, 0, FRAME1, FRAME2, null);
      b1 = new Barrier(250);
      b2 = new Barrier(395);
      b3 = new Barrier(550);
      ball = new Ball(26, FRAME2/2, 40, Color.BLACK);
      //ball.setay(-0.19);
     // ball.setay(-1);
      
      t = new Timer(1, new Listener());
      t.start();
      g = new Timer(4, new BarrierListener());
      g.start();
      addKeyListener(new SpaceBar());
      setFocusable(true);
   }
   public void paintComponent(Graphics g)
   {
      g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
   }
   private class Listener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
        
         ImageIcon j = new ImageIcon("background.png");
         myBuffer.drawImage(j.getImage(), 0, 0, FRAME1+10, FRAME2+10, null);
         
         myBuffer.setFont(new Font("Lucida Bright", Font.BOLD, 18));
         
         if(!hasLost){
            if(b1.collide(ball)|| b2.collide(ball) || b3.collide(ball)){
               //t.stop();
               hasLost = true;
               ball.setdx(0);
               ball.setdy(0);
               ball.setay(5.5);}
            b1.barrier1.draw(myBuffer);
            b1.barrier2.draw(myBuffer);
            b2.barrier1.draw(myBuffer);
            b2.barrier2.draw(myBuffer);
            b3.barrier1.draw(myBuffer);
            b3.barrier2.draw(myBuffer);
            myBuffer.drawString("Count: " + count, 10, 30);
            ball.move(FRAME1,FRAME2);
            ball.draw(myBuffer,FRAME2); 
         //
         
            myBuffer.setFont(new Font("Serif",Font.PLAIN,20));
            myBuffer.setColor(Color.BLACK);
                  // 
                  
         }
         else
         {
            b1.barrier1.draw(myBuffer);
            b1.barrier2.draw(myBuffer);
            b2.barrier1.draw(myBuffer);
            b2.barrier2.draw(myBuffer);
            b3.barrier1.draw(myBuffer);
            b3.barrier2.draw(myBuffer);
            ball.draw(myBuffer,FRAME2);
            ball.move(FRAME1, FRAME2);
            if(ball.getY() + ball.getRadius() >= FRAME2){
               t.stop();
               g.stop();
               System.out.println("Stopped");
               myBuffer.setColor(Color.BLUE);
               myBuffer.setFont(new Font("Lucida Bright", Font.BOLD, 32));
               myBuffer.drawString("Game over with " + count + " points", 100, 250);
            }
            
         }
         repaint();
      }
   }
   private class BarrierListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         int past1 = Math.abs(b1.barrier1.getX() + b1.barrier1.getXWidth() - (int)(ball.getX() - ball.getRadius()));
         int sabs1 = b1.barrier1.getX() + b1.barrier1.getXWidth() - (int)(ball.getX() - ball.getRadius());
         int past2 = Math.abs(b2.barrier1.getX() + b2.barrier1.getXWidth() - (int)(ball.getX() - ball.getRadius()));
         int sabs2 = b2.barrier1.getX() + b2.barrier1.getXWidth() - (int)(ball.getX() - ball.getRadius());
         int past3 = Math.abs(b3.barrier1.getX() + b3.barrier1.getXWidth() - (int)(ball.getX() - ball.getRadius()));
         int sabs3 = b3.barrier1.getX() + b3.barrier1.getXWidth() - (int)(ball.getX() - ball.getRadius());
         if(((past1 == 0 || past1 == 1) && past1 == sabs1) || ((past2 == 0 || past2 == 1) && past2 == sabs2) || ((past3 == 0 || past3 == 1) && past3 == sabs3)){
            System.out.println(past1 + " " + sabs1);
            System.out.println(past2 + " " + sabs2);
            System.out.println(past3 + " " + sabs3);
            System.out.println();
            count++;
         }
         b1.barrier1.setX(b1.barrier1.getX()-1);
         b1.barrier2.setX(b1.barrier2.getX()-1);
         b2.barrier1.setX(b2.barrier1.getX()-1);
         b2.barrier2.setX(b2.barrier2.getX()-1);
         b3.barrier1.setX(b3.barrier1.getX()-1);
         b3.barrier2.setX(b3.barrier2.getX()-1);
         if(b1.barrier1.getX() <= -15)
         {
            b1 = b2;
            b2 = b3;
            b3 = new Barrier(590);
         }
      }
   }
   private class SpaceBar extends KeyAdapter
   {
      public void keyPressed(KeyEvent e)
      {
         if(e.getKeyCode() == KeyEvent.VK_SPACE)
         {
            ball.setdy(-3.5);
            
         }
      }
   }
   class Barrier
   {
      public Bumper barrier1, barrier2;
      public Barrier(int x)
      {
         int ywid = (int)(Math.random()*120 + 100);
         int y2 = ywid + 275;
      
         barrier1 = new Bumper(x, 0, ywid, Color.GREEN);                      
         barrier2 = new Bumper(x, y2, FRAME2 - y2, Color.GREEN);
      }
      public boolean collide(Ball ball){
         if(ball.getY() + ball.getRadius() <= barrier2.getY() && ball.getY() - ball.getRadius() >= barrier1.getY() + barrier1.getYWidth()){
            
            return false;
         
         }
         else{
         
            boolean g = barrier1.getX() - ball.getRadius() <= ball.getX();
            return g && barrier1.getX() + barrier1.getXWidth() >= ball.getX() - ball.getRadius();}
        
      }
   }  
}
