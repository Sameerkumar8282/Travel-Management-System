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
public class viewBookedHotel extends JFrame implements ActionListener {
JButton back;
    
   viewBookedHotel(String username){
		setBounds(400,200,1000,600);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel text = new JLabel("VIEW BOOK DETAILS");
		text.setFont(new Font("Tahoma",Font.BOLD,20));
		text.setBounds(60,0,300,30);
		add(text);
		
		JLabel lblusername = new JLabel("Username");
		lblusername.setBounds(30, 50, 150, 25);
		add(lblusername);
		
		JLabel labelusername = new JLabel("");
		labelusername.setBounds(150, 50, 150, 25);
		add(labelusername);
		
		JLabel lblhote = new JLabel("Hotel Name");
		lblhote.setBounds(30, 90, 150, 25);
		add(lblhote);
		
		JLabel labelhotel = new JLabel("");
		labelhotel.setBounds(150, 90, 150, 25);
		add(labelhotel);
		
		JLabel lblperson = new JLabel("Total Persons");
		lblperson.setBounds(30, 130, 150, 25);
		add(lblperson);
		
		JLabel labelpersons = new JLabel();
		labelpersons.setBounds(150, 130, 150, 25);
		add(labelpersons);
		
		JLabel lbldays = new JLabel("Total Days");
		lbldays.setBounds(30, 170, 150, 25);
		add(lbldays);
		
		JLabel labeldays = new JLabel();
		labeldays.setBounds(150, 170, 150, 25);
		add(labeldays);
		

		JLabel lblac = new JLabel("AC/Non-AC");
		lblac.setBounds(30, 210, 150, 25);
		add(lblac);
		
		JLabel labelac = new JLabel();
		labelac.setBounds(150, 210, 150, 25);
		add(labelac);
		

		JLabel lblfood = new JLabel("Food Included ? ");
		lblfood.setBounds(30, 250, 150, 25);
		add(lblfood);
		
		JLabel labelfood = new JLabel();
		labelfood.setBounds(150, 250, 150, 25);
		add(labelfood);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(30, 290, 150, 25);
		add(lblId);
		
		JLabel labelid = new JLabel();
		labelid.setBounds(150, 290, 150, 25);
		add(labelid);
		
		
		JLabel lblnumber = new JLabel("Number");
		lblnumber.setBounds(30, 330, 150, 25);
		add(lblnumber);
		
		JLabel labelnumber = new JLabel();
		labelnumber.setBounds(150, 330, 150, 25);
		add(labelnumber);
		
		
		JLabel lblphone = new JLabel("Phone");
		lblphone.setBounds(30, 370, 150, 25);
		add(lblphone);
		
		JLabel labelphone = new JLabel();
		labelphone.setBounds(150, 370, 150, 25);
		add(labelphone);
		
		
		JLabel lblcost = new JLabel("Total Cost");
		lblcost.setBounds(30, 410, 150, 25);
		add(lblcost);
		
		JLabel labelCost = new JLabel();
		labelCost.setBounds(150, 410, 150, 25);
		add(labelCost);
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(150, 470, 100, 25);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("Icon/bookedDetails.jpg"));
		Image i5 = i4.getImage().getScaledInstance(400, 350, Image.SCALE_DEFAULT);	
		ImageIcon i6 = new ImageIcon(i5);
		JLabel image2 = new JLabel(i6);
		image2.setBounds(470,10,500,400);
		add(image2);
		
		try {
			conn c = new conn();
			String query = "select * from bookhotel where username = '"+username+"'";			
		      ResultSet rs = c.s.executeQuery(query);
               while(rs.next()) {
				labelusername.setText(rs.getString(1));
				labelhotel.setText(rs.getString("name"));
				labelnumber.setText(rs.getString("number"));
				labelpersons.setText(rs.getString("persons"));
				labelid.setText(rs.getString("id"));
				labelphone.setText(rs.getString("phone"));
				labelCost.setText(rs.getString("price"));
				labelac.setText(rs.getString("ac"));
				labelfood.setText(rs.getString("food"));
				labeldays.setText(rs.getString(4));
			}
		}catch (Exception e){
			e.printStackTrace();
		}		
		setVisible(true);	
	}
	
	public static void main(String[] args) {
		new viewBookedHotel("sam");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back) {
			dispose();
		}
		
	}

}
