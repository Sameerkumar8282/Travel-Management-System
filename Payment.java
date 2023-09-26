import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class Payment extends JFrame implements ActionListener{
	JButton back,pay;
  Payment(){
	  
	  setBounds(500,200,800,600);
	  setLayout(null);
	  
	  ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("Icon/paytm.jpeg"));
		Image i5 = i4.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);	
		ImageIcon i6 = new ImageIcon(i5);
		JLabel image2 = new JLabel(i6);
		image2.setBounds(0,0,800,600);
		add(image2);
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(420,0, 80, 40);
		back.addActionListener(this);
		image2.add(back);
		
		pay = new JButton("Pay");
		pay.setBackground(Color.BLACK);
		pay.setForeground(Color.WHITE);
		pay.setBounds(520,0, 80, 40);
		pay.addActionListener(this);
		image2.add(pay);
		
		
		
		
		
		setVisible(true);
	  
  }
	public static void main(String[] args) {
		new Payment();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== pay) {
			new paytm();
		}
		else {
			dispose();
		}
		
	}

}
