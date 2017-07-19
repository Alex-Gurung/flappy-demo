import javax.swing.JFrame;
public class DriverBird
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Flappy Bird");
      frame.setSize(600, 600);
      frame.setLocation(600, 600);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new DemoPanel());
      frame.setVisible(true);
   }
}   