import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class Login extends JFrame implements ActionListener{
	 JButton forgetBtn,signupBtn,logBtn;
	 JTextField userTf;
	 JPasswordField pwdF;
	Login(){
		
		    setSize(750,400);
	        setLocation(350,200);
	        setLayout(null);
	        
	        getContentPane().setBackground(Color.WHITE);
	        
	        JPanel p1  = new JPanel();
	        p1.setBackground(new Color(131,193,233));
	        p1.setLayout(null);
	        p1.setBounds(0,0, 400, 365); 
	        add(p1);
	        
	        ImageIcon i1 =  new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
	        Image i2 =i1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
	        ImageIcon i3 = new ImageIcon(i2);
	        JLabel image =  new JLabel(i3);
	        image.setBounds(100, 120, 200, 200);
	        
	        p1.add(image);
	        
	        JPanel p2  = new JPanel();
	        p2.setLayout(null);
	        p2.setBounds(350,0,400,365);
	        add(p2);
	        
	        JLabel head = new JLabel("Login");
	        head.setBounds(120,-40, 180,180);
	        head.setFont(new Font("San_Serif",Font.PLAIN,60));
	        p1.add(head);
	        
	        JLabel userNameLb = new JLabel("Username");
	        userNameLb.setBounds(70, 30, 100, 25);
	        userNameLb.setFont(new Font("San_Serif",Font.PLAIN,20));
	        p2.add(userNameLb);
	        
	        userTf = new JTextField();
	        userTf.setBounds(70,70,280,25);
	        p2.add(userTf);
	        
	        
	        JLabel pass = new JLabel("Password");
	        pass.setBounds(70, 120, 100, 25);
	        pass.setFont(new Font("San_Serif",Font.PLAIN,20));
	        p2.add(pass);
	        
	        pwdF = new JPasswordField();
	        pwdF.setBounds(70,160,280,25);
	        p2.add(pwdF);
	        
	        logBtn = new JButton("LOGIN");
	        logBtn.setBounds(70, 210, 130, 25);
	        logBtn.setBackground(new Color(133,193,233));
	        logBtn.setForeground (Color.WHITE);//font color change  
	        logBtn.setBorder(new LineBorder(new Color(133,193,233)));
	        logBtn.addActionListener(this);
	        p2.add(logBtn);
	        
	        signupBtn = new JButton("Signup");
	        signupBtn.setBounds(220, 210, 130, 25);
	        signupBtn.setBackground(new Color(133,193,233));
	        signupBtn.setForeground (Color.WHITE);//font color change  
	        signupBtn.setBorder(new LineBorder(new Color(133,193,233)));
	        signupBtn.addActionListener(this);
	        p2.add(signupBtn);
	        
	        forgetBtn = new JButton("Forget Password");
	        forgetBtn.setBounds(90, 260, 130, 25);
	        forgetBtn.setBackground(new Color(133,193,233));
	        forgetBtn.setForeground (Color.WHITE);//font color change  
	        forgetBtn.setBorder(new LineBorder(new Color(133,193,233)));
	        forgetBtn.addActionListener(this);
	        p2.add(forgetBtn);
	        
	        JLabel noti = new JLabel("Trouble in Login...");
	        noti.setBounds(230, 260, 130, 25);
	       // noti.setFont(new Font("San_Serif",Font.PLAIN,13));
	        noti.setForeground(Color.red);
	        p2.add(noti);
	        
	        
	        
	        setVisible(true);
	}

	public static void main(String[] args) {
		new Login();//new autonomous class 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == forgetBtn) {
			new ForgetPassword();
			dispose();
		}
		
		if(e.getSource() == signupBtn) {
			new signup();
			dispose();
		}
		
		if(e.getSource() == logBtn) {
			try {
				String username = userTf.getText();
				String pass = String.valueOf(pwdF.getPassword());
				
				String query = "select * from account where username = '"+username+"' AND password = '"+pass+"'";
				conn c = new conn();
				ResultSet rs = c.s.executeQuery(query);
				if(rs.next()) {
					setVisible(false);
					new Loading(username);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null,"Incorrect username and password");
				}
				
				
			}catch(Exception ae) {
				ae.printStackTrace();
			}
			
		}
	}

}
