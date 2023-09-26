import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

@SuppressWarnings("serial")
public class DeleteDetails extends JFrame implements ActionListener {
	JButton back,delete;
	String username;
    
	DeleteDetails(String username){
		this.username = username;
		setBounds(450,180,870,625);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblusername = new JLabel("Username");
		lblusername.setBounds(30, 50, 150, 25);
		add(lblusername);
		
		JLabel labelusername = new JLabel("");
		labelusername.setBounds(220, 50, 150, 25);
		add(labelusername);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(30, 110, 150, 25);
		add(lblId);
		
		JLabel labelId = new JLabel();
		labelId.setBounds(220, 110, 150, 25);
		add(labelId);
		

		JLabel lblnumber = new JLabel("Number");
		lblnumber.setBounds(30, 170, 150, 25);
		add(lblnumber);
		
		JLabel labelnumber = new JLabel();
		labelnumber.setBounds(220, 170, 150, 25);
		add(labelnumber);
				
		JLabel lblname = new JLabel("Name");
		lblname.setBounds(30, 230, 150, 25);
		add(lblname);
		
		JLabel labelname = new JLabel();
		labelname.setBounds(220, 230, 150, 25);
		add(labelname);
		
		JLabel lblgender = new JLabel("Gender");
		lblgender.setBounds(30, 290, 150, 25);
		add(lblgender);
		
		JLabel labelgender = new JLabel();
		labelgender.setBounds(220, 290, 150, 25);
		add(labelgender);
				
		
		JLabel lblcountry = new JLabel("Country");
		lblcountry.setBounds(500, 50, 150, 25);
		add(lblcountry);
		
		JLabel labelcountry = new JLabel();
		labelcountry.setBounds(650, 50, 150, 25);
		add(labelcountry);
		
		JLabel lbladdress = new JLabel("Address");
		lbladdress.setBounds(500, 110, 150, 25);
		add(lbladdress);
		
		JLabel labeladdress = new JLabel();
		labeladdress.setBounds(650, 110, 150, 25);
		add(labeladdress);
		
		JLabel lblphone = new JLabel("Phone");
		lblphone.setBounds(500, 170, 150, 25);
		add(lblphone);
		
		JLabel labelphone = new JLabel();
		labelphone.setBounds(650, 170, 150, 25);
		add(labelphone);
		

		JLabel lblemail = new JLabel("Email");
		lblemail.setBounds(500, 230, 150, 25);
		add(lblemail);
		
		JLabel labelemail = new JLabel();
		labelemail.setBounds(600, 230, 200, 25);
		add(labelemail);
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(350, 350, 100, 25);
		back.addActionListener(this);
		add(back);
		
		delete = new JButton("Delete");
		delete.setBackground(Color.BLACK);
		delete.setForeground(Color.WHITE);
		delete.setBounds(250, 350, 100, 25);
		delete.addActionListener(this);
		add(delete);
		
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("Icon/viewall.jpg"));
		Image i5 = i4.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);	
		ImageIcon i6 = new ImageIcon(i5);
		JLabel image2 = new JLabel(i6);
		image2.setBounds(135,400,600,200);
		add(image2);
		
		try {
			conn c = new conn();
			String query = "select * from customer where username = '"+username+"'";			
		      ResultSet rs = c.s.executeQuery(query);
               while(rs.next()) {
				labelusername.setText(rs.getString(1));
				labelId.setText(rs.getString("id"));
				labelnumber.setText(rs.getString("number"));
				labelname.setText(rs.getString("name"));
				labelgender.setText(rs.getString("gender"));
				labelcountry.setText(rs.getString("country"));
				labeladdress.setText(rs.getString("address"));
				labelphone.setText(rs.getString("phone"));
				labelemail.setText(rs.getString("email"));
			}
		}catch (Exception e){
			e.printStackTrace();
		}		
		setVisible(true);	
	}
	
	public static void main(String[] args) {
		new DeleteDetails("sam");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==delete) {
			try {
				conn c = new conn();
				c.s.executeUpdate("delete from account where username ='"+username+"'");
				c.s.executeUpdate("delete from bookhotel where username ='"+username+"'");
				c.s.executeUpdate("delete from bookpackage where username ='"+username+"'");
				c.s.executeUpdate("delete from customer where username ='"+username+"'");	
				
				JOptionPane.showMessageDialog(null,"Data deleted Successfully!");
				System.exit(0);
			}catch(Exception ae) {
				ae.printStackTrace();
			}
		}
		else {
			dispose();
		}
		
	}

}
