import javax.swing.*;
import java.awt.*;


@SuppressWarnings("serial")
public class Splash extends JFrame implements Runnable{
    
    Thread thread;
    
    Splash(){
        //setSize(1200,600);
        //setLocation(200,150);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/splash.jpg"));
       Image i2 = i1.getImage().getScaledInstance(1200, 600, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3); 
       add(image);
               
       setVisible(true);
       thread =new Thread(this);
       thread.start();
       
    }
    public void run(){
    try{
        Thread.sleep(7000);
        new Login();
    }
    catch(Exception e){
        
    }
    }
    
    public static void main(String[] args){
       Splash frame =  new Splash();
       for(int i =1 ;i<=150;i++){
           frame.setLocation(i,i);
           frame.setSize(i*8,i*4);
           try{
               Thread.sleep(2);
           }
           catch(Exception e){
               
           }
       }
    }
}
