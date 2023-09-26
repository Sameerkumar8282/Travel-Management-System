
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class signup extends JFrame implements ActionListener {
	JButton creBtn,backBtn;
	JTextField userTf,nameTf,passTf,ansTf;
	Choice security;
	
	signup(){
		    setSize(750,400);
	        setLocation(350,200);
	        setLayout(null);
	        
	        JPanel p1 = new JPanel();
	        p1.setBackground(new Color(131,193,233));
	        p1.setLayout(null);
	        p1.setBounds(0,0, 450, 365);
	        add(p1);
	        
	        JLabel userL = new JLabel("Username");
	        userL.setBounds(30, 15, 100, 25);
	        userL.setFont(new Font("Tahoma",Font.BOLD,14));
	        p1.add(userL);
	        
	        
	        userTf = new JTextField();
	        userTf.setBounds(130,15,250,25);
	        p1.add(userTf);
	        
	        JLabel nameL = new JLabel("Name");
	        nameL.setBounds(30, 55, 100, 25);
	        nameL.setFont(new Font("Tahoma",Font.BOLD,14));
	        p1.add(nameL);
	        
	        
	        nameTf = new JTextField();
	        nameTf.setBounds(130,55,250,25);
	        p1.add(nameTf);
	        
	        JLabel passL = new JLabel("Password");
	        passL.setBounds(30, 95, 100, 25);
	        passL.setFont(new Font("Tahoma",Font.BOLD,14));
	        p1.add(passL);
	        
	        
	        passTf = new JTextField();
	        passTf.setBounds(130,95,250,25);
	        p1.add(passTf);
	        
	        JLabel choiceL = new JLabel("Security Question");
	        choiceL.setBounds(30, 135, 100, 25);
	        choiceL.setFont(new Font("Tahoma",Font.BOLD,14));
	        p1.add(choiceL);
	        
	         security = new Choice();
	        security.add("Fav Character from boys");
	        security.add("Birth place");
	        security.add("First School Name");
	        security.add("Father Middle Name");
	        security.setBounds(130, 135, 250, 25);
	        p1.add(security);
	        
	        JLabel ansL = new JLabel("Answer");
	        ansL.setBounds(30, 175, 100, 25);
	        ansL.setFont(new Font("Tahoma",Font.BOLD,14));
	        p1.add(ansL);
	        	        
	        ansTf = new JTextField();
	        ansTf.setBounds(130,175,250,25);
	        p1.add(ansTf);
	        
	        creBtn = new JButton("CREATE");
	        creBtn.setBounds(70, 230, 130, 25);
	        creBtn.setBackground(Color.WHITE);
	        creBtn.setForeground (new Color(133,193,233));//font color change  
	        creBtn.setFont(new Font("Tahoma",Font.BOLD,14));
	        creBtn.addActionListener(this);
	        //creBtn.setBorder(new LineBorder(new Color(133,193,233)));
	        p1.add(creBtn);
	        
	        backBtn = new JButton("BACK");
	        backBtn.setBounds(240, 230, 130, 25);
	        backBtn.setBackground(Color.WHITE);
	        backBtn.setForeground (new Color(133,193,233));//font color change  
	        backBtn.setFont(new Font("Tahoma",Font.BOLD,14));
	        //creBtn.setBorder(new LineBorder(new Color(133,193,233)));
	        backBtn.addActionListener(this);
	        p1.add(backBtn);
	        
	        JPanel p2 = new JPanel();
	        p2.setLayout(null);
	        p2.setBounds(350,0,400,365);
	        add(p2);
	        
	        ImageIcon i1 =  new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
	        Image i2 =i1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
	        ImageIcon i3 = new ImageIcon(i2);
	        JLabel image =  new JLabel(i3);
	        image.setBounds(150, 100, 200, 200);
	        
	        p2.add(image);
	        
	        JLabel head = new JLabel("Signup");
	        head.setBounds(150,-40, 190,180);
	        head.setFont(new Font("San_Serif",Font.PLAIN,55));
	        p2.add(head);      
	             
	        setVisible(true);
	        
	        
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == creBtn) {
			String username = userTf.getText();
			String name = nameTf.getText();
			String password = passTf.getText();
			String question = security.getSelectedItem();
			String answer = ansTf.getText();
			
			String query = "insert into account values('"+username+"','"+name+"','"+password+"','"+question+"','"+answer+"')";
			try {
				conn c = new conn();
				
					c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null,"Account Created Successfully");
			}
			catch(Exception ae) {
				ae.printStackTrace();
			}
			
		}else if(e.getSource() == backBtn) {
			setVisible(false);
			new Login();
			dispose();
		}
	}

	public static void main(String[] args) {
		new signup();

	}
}



	