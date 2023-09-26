import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

@SuppressWarnings("serial")
public class ForgetPassword extends JFrame implements ActionListener{
	
	JTextField Tfusername,Tfname,Tfquestion,Tfanswer,Tfpassword;
	JButton search,retrive,back;
	
	ForgetPassword(){
		setBounds(350,200,850,380);
		getContentPane().setBackground(Color.white);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/forgotpassword.jpg"));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 =  new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(580, 70	, 200, 200);
		add(image);
		
		JPanel p1 =  new JPanel();
		p1.setLayout(null);
		p1.setBounds(30, 30, 500, 280);
		//p1.setVisible(true);
		add(p1);
		
		JLabel lbusername = new JLabel("Username");
		lbusername.setBounds(40,20,100,25);
		lbusername.setFont(new Font("Tahoma",Font.BOLD,14));
		p1.add(lbusername);	
		
		Tfusername= new JTextField();
		Tfusername.setBounds(200, 20, 150, 25);
		Tfusername.setBorder(BorderFactory.createEmptyBorder());
		p1.add(Tfusername);
		
		JLabel lbname = new JLabel("Name");
		lbname.setBounds(40,60,100,25);
		lbname.setFont(new Font("Tahoma",Font.BOLD,14));
		p1.add(lbname);	
		
		Tfname= new JTextField();
		Tfname.setBounds(200, 60, 150, 25);
		Tfname.setBorder(BorderFactory.createEmptyBorder());
		p1.add(Tfname);
		
		JLabel lbquestion = new JLabel("Security Question");
		lbquestion.setBounds(40,100,150,25);
		lbquestion.setFont(new Font("Tahoma",Font.BOLD,14));
		p1.add(lbquestion);
		
		Tfquestion= new JTextField();
		Tfquestion.setBounds(200, 100, 150, 25);
		Tfquestion.setBorder(BorderFactory.createEmptyBorder());
		p1.add(Tfquestion);
		
		JLabel lbanswer = new JLabel("Answer");
		lbanswer.setBounds(40,140,150,25);
		lbanswer.setFont(new Font("Tahoma",Font.BOLD,14));
		p1.add(lbanswer);
		
		Tfanswer= new JTextField();
		Tfanswer.setBounds(200, 140, 150, 25);
		Tfanswer.setBorder(BorderFactory.createEmptyBorder());
		p1.add(Tfanswer);
		

		JLabel lbpassword = new JLabel("Password");
		lbpassword.setBounds(40,180,150,25);
		lbpassword.setFont(new Font("Tahoma",Font.BOLD,14));
		p1.add(lbpassword);
		
		Tfpassword= new JTextField();
		Tfpassword.setBounds(200, 180, 150, 25);
		Tfpassword.setBorder(BorderFactory.createEmptyBorder());
		p1.add(Tfpassword);
		
		search = new JButton("Search");
		search.setBackground(Color.GRAY);
		search.setForeground(Color.WHITE);
		search.setBounds(380, 20, 100, 25);
		search.addActionListener(this);
		p1.add(search);
		
		retrive = new JButton("Retrive");
		retrive.setBackground(Color.GRAY);
		retrive.setForeground(Color.WHITE);
		retrive.setBounds(380, 140, 100, 25);
		retrive.addActionListener(this);
		p1.add(retrive);
		
		back = new JButton("Back");
	    back.setBackground(Color.GRAY);
		back.setForeground(Color.WHITE);
		back.setBounds(150, 230, 100, 25);
		back.addActionListener(this);
		p1.add(back);
		
		setLayout(null);
		setVisible(true);
	}

	public static void main(String[] args) {
    new ForgetPassword();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == retrive) {
			try {
				String query = "select * from account where answer = '"+Tfanswer.getText()+"' AND username = '"+Tfusername.getText()+"'";
				conn c = new conn();
				ResultSet rs = c.s.executeQuery(query);
				while(rs.next()) {
					Tfpassword.setText(rs.getString("password"));
				}
			}catch(Exception ae) {
				ae.printStackTrace(); 
			}
		}
		if(e.getSource() == back) {
			new Login();
			dispose();
		}
		if(e.getSource() == search) {
			try {
				String query = "select * from account where username = '"+Tfusername.getText()+"'";
				conn c = new conn();
				ResultSet rs = c.s.executeQuery(query);
				//String nn = Tfusername.getText();
				
				while(rs.next()) {
					
					Tfname.setText(rs.getString("name"));
					Tfquestion.setText(rs.getString("security"));
				}
			}catch(Exception ae) {
				
				ae.printStackTrace(); 
			}
		}
	}

}
