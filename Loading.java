import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

@SuppressWarnings("serial")
public class Loading extends JFrame implements Runnable {
	
	Thread t;
	JProgressBar bar;
	String username1;
	
	@Override
	public void run() {
		try {
			for(int i = 1; i <= 101;i++) {
				int max = bar.getMaximum();//100
				int value = bar.getValue();
				
				if(value < max) {
					bar.setValue(bar.getValue() + 1);
				}
				else {
					
					setVisible(false);
					new Dashboard(username1);
				}
				Thread.sleep(50);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	Loading(String username1){
		this.username1 = username1;
		t = new Thread(this);
		
		setBounds(500,200,650,400);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel text = new JLabel("Travel and Tourism Application");
		text.setBounds(50, 20, 600, 40);
		text.setForeground(Color.BLUE);
		text.setFont(new Font("Raleway",Font.BOLD,35));
		add(text);
		
		JLabel loading = new JLabel("Loading, please wait....");
		loading.setBounds(220, 130, 400, 20);
		loading.setForeground(Color.red);
		loading.setFont(new Font("Raleway",Font.BOLD,15));
		add(loading);
		
		JLabel username = new JLabel("Welcome " + username1);
		username.setBounds(20, 310, 400, 40);
		username.setForeground(Color.red);
		username.setFont(new Font("Raleway",Font.BOLD,15));
		add(username);
		
		bar = new JProgressBar();
		bar.setBounds(150, 100, 300, 25);
		bar.setForeground(Color.orange);
		bar.setStringPainted(true);
		add(bar);
		
		t.start();
		setVisible(true);
	}

	public static void main(String[] args) {
		new Loading("");

	}

	

}
