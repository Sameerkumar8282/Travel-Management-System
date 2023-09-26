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

@SuppressWarnings("serial")
public class ViewPackage extends JFrame implements ActionListener {
JButton back;
    
	ViewPackage(String username){
		setBounds(455,200,900,450);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel text = new JLabel("VIEW PACKAGE DETAILS");
		text.setFont(new Font("Tahoma",Font.BOLD,20));
		text.setBounds(60,0,300,30);
		add(text);
		
		JLabel lblusername = new JLabel("Username");
		lblusername.setBounds(30, 50, 150, 25);
		add(lblusername);
		
		JLabel labelusername = new JLabel("");
		labelusername.setBounds(150, 50, 150, 25);
		add(labelusername);
		
		JLabel lblId = new JLabel("Package");
		lblId.setBounds(30, 90, 150, 25);
		add(lblId);
		
		JLabel labelpackage = new JLabel();
		labelpackage.setBounds(150, 90, 150, 25);
		add(labelpackage);
		

		JLabel lblnumber = new JLabel("Total Persons");
		lblnumber.setBounds(30, 130, 150, 25);
		add(lblnumber);
		
		JLabel labelpersons = new JLabel();
		labelpersons.setBounds(150, 130, 150, 25);
		add(labelpersons);
				
		JLabel lblname = new JLabel("ID");
		lblname.setBounds(30, 170, 150, 25);
		add(lblname);
		
		JLabel labelid = new JLabel();
		labelid.setBounds(150, 170, 150, 25);
		add(labelid);
		
		JLabel lblgender = new JLabel("Number");
		lblgender.setBounds(30, 210, 150, 25);
		add(lblgender);
		
		JLabel labelnumber = new JLabel();
		labelnumber.setBounds(150, 210, 150, 25);
		add(labelnumber);
				
		JLabel lblcountry = new JLabel("Phone");
		lblcountry.setBounds(30, 250, 150, 25);
		add(lblcountry);
		
		JLabel labelphone = new JLabel();
		labelphone.setBounds(150, 250, 150, 25);
		add(labelphone);
		
		
		
		JLabel lbladdress = new JLabel("Price");
		lbladdress.setBounds(30, 290, 150, 25);
		add(lbladdress);
		
		JLabel labelprice = new JLabel();
		labelprice.setBounds(150, 290, 150, 25);
		add(labelprice);
		
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(350, 350, 100, 25);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("Icon/bookedDetails.jpg"));
		Image i5 = i4.getImage().getScaledInstance(300, 350, Image.SCALE_DEFAULT);	
		ImageIcon i6 = new ImageIcon(i5);
		JLabel image2 = new JLabel(i6);
		image2.setBounds(430,10,500,400);
		add(image2);
		
		try {
			conn c = new conn();
			String query = "select * from bookpackage where username = '"+username+"'";			
		      ResultSet rs = c.s.executeQuery(query);
               while(rs.next()) {
				labelusername.setText(rs.getString(1));
				labelpackage.setText(rs.getString("package"));
				labelnumber.setText(rs.getString("number"));
				labelpersons.setText(rs.getString("persons"));
				labelid.setText(rs.getString("id"));
				labelphone.setText(rs.getString("phone"));
				labelprice.setText(rs.getString("price"));			
			}
		}catch (Exception e){
			e.printStackTrace();
		}		
		setVisible(true);	
	}
	
	public static void main(String[] args) {
		new ViewPackage("sam");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back) {
			dispose();
		}
		
	}

}
