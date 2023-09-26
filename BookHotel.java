import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

@SuppressWarnings("serial")
public class BookHotel extends JFrame implements ActionListener {
	
	Choice Chotel,cac,cfood;
	JTextField tfpersons,tfdays;
	String Username;
	JLabel labelusername,labelId,labelnumber,labelphone,labelprice;
	JButton checkPrice,bookPackage,Back;
	
	BookHotel(String Username){
		
		this.Username = Username;
		
		setBounds(350,200,1100,600);
		setLayout(null);
		
		JLabel text = new JLabel("BOOK HOTEL");
		text.setBounds(100, 10, 200, 30);
		text.setFont(new Font("Tahoma",Font.BOLD,20));		
		add(text);
		
		JLabel lblusername = new JLabel("Username");
		lblusername.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblusername.setBounds(40, 70, 100, 20);
		add(lblusername);
		
	    labelusername = new JLabel();
		labelusername.setFont(new Font("Tahoma",Font.PLAIN,16));
		labelusername.setBounds(250, 70, 100, 20);
		add(labelusername);
		
		JLabel lblpackage = new JLabel("Select Hotel");
		lblpackage.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblpackage.setBounds(40, 110, 120, 20);
		add(lblpackage);
		
		Chotel = new Choice();
		Chotel.setBounds(250,110,200,20);
		add(Chotel);
		
		try {
			conn c = new conn();
			ResultSet rs = c.s.executeQuery("select * from hotel");
			while(rs.next()) {
				Chotel.add(rs.getString("name"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		JLabel lblpersons = new JLabel("Total Person");
		lblpersons.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblpersons.setBounds(40, 150, 150, 20);
		add(lblpersons);
		
		tfpersons = new JTextField("1");
		tfpersons.setBounds(250,150,200,25);
		add(tfpersons);
		
		JLabel lbldays = new JLabel("No. of Days");
		lbldays.setFont(new Font("Tahoma",Font.PLAIN,16));
		lbldays.setBounds(40, 190, 150, 20);
		add(lbldays);
		
		tfdays = new JTextField("1");
		tfdays.setBounds(250,190,200,25);
		add(tfdays);
		
		JLabel lblac = new JLabel("AC / Non-AC");
		lblac.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblac.setBounds(40, 230, 150, 20);
		add(lblac);
		
		cac = new Choice();
		cac.add("AC");
		cac.add("NON-AC");
		cac.setBounds(250,230,200,20);
		add(cac);
		
		JLabel lblfood = new JLabel("Food Included");
		lblfood.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblfood.setBounds(40, 270, 150, 20);
		add(lblfood);
		
		cfood = new Choice();
		cfood.add("YES");
		cfood.add("NO");
		cfood.setBounds(250,270,200,20);
		add(cfood);
		
		
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(40, 310, 150, 20);
		lblId.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(lblId);
		
		labelId = new JLabel();
		labelId.setBounds(250, 310, 150, 25);
		add(labelId);
		

		JLabel lblnumber = new JLabel("Number");
		lblnumber.setBounds(40, 350, 150, 25);
		lblnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(lblnumber);
		
		labelnumber = new JLabel();
		labelnumber.setBounds(250, 350, 150, 25);
		add(labelnumber);
		
		JLabel lblphone = new JLabel("Phone");
		lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblphone.setBounds(40, 390, 150, 25);
		add(lblphone);
		
	    labelphone = new JLabel();
		labelphone.setBounds(250, 390, 150, 25);
		add(labelphone);
		
		JLabel lblprice = new JLabel("Total Price");
		lblprice.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblprice.setBounds(40, 430, 150, 25);
		add(lblprice);
		
		labelprice = new JLabel();
		labelprice.setBounds(250, 430, 150, 25);
		add(labelprice);
		
		try {
			conn c = new conn();
			String query = "select * from customer where username = '"+Username+"'";			
		      ResultSet rs = c.s.executeQuery(query);
               while(rs.next()) {
				labelusername.setText(rs.getString(1));
				labelId.setText(rs.getString("id"));
				labelnumber.setText(rs.getString("number"));
				labelphone.setText(rs.getString("phone"));			
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		
		
		checkPrice = new JButton("Check Price");
		checkPrice.setBounds(60,490,120,25);
		checkPrice.setBackground(Color.BLACK);
		checkPrice.setForeground(Color.WHITE);
		checkPrice.addActionListener(this);
		add(checkPrice);
		
		bookPackage = new JButton("Book Hotel");
		bookPackage.setBounds(200,490,120,25);
		bookPackage.setBackground(Color.BLACK);
		bookPackage.setForeground(Color.WHITE);
		bookPackage.addActionListener(this);
		add(bookPackage);
		

		Back = new JButton("Back");
		Back.setBounds(340,490,120,25);
		Back.setBackground(Color.BLACK);
		Back.setForeground(Color.WHITE);
		Back.addActionListener(this);
		add(Back);
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/book.jpg"));
		Image i2 = i1.getImage().getScaledInstance(600, 450, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel i12 = new JLabel(i3);
		i12.setBounds(520, 50, 500, 300);
		add(i12);
		 
		setVisible(true);
	}

	public static void main(String[] args) {
		new BookHotel("Sam");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	if(e.getSource() == checkPrice) {
		try {
		conn c = new conn();
		ResultSet rs = c.s.executeQuery("Select * from hotel where name ='"+Chotel.getSelectedItem()+"'");
		while(rs.next()) {
			int cost = Integer.parseInt(rs.getString("costperperson"));
			int food = Integer.parseInt(rs.getString("foodincluded"));
			int ac = Integer.parseInt(rs.getString("acroom"));
			
			int persons = Integer.parseInt(tfpersons.getText());
			int days = Integer.parseInt(tfdays.getText());
			
			String acselected = cac.getSelectedItem();
			String foodselected = cfood.getSelectedItem();
			
			if(persons * days > 0) {
				int total =0;
				total += acselected.equals("AC")? ac : 0;
				total += foodselected.equals("YES")? food:0;
				total += cost;
				total = total * persons * days;
				labelprice.setText("Rs" + total);
			}
			else {
				JOptionPane.showMessageDialog(null, "Enter the valid Number");
			}	
		    }
		}
		catch(Exception ee) {
			ee.printStackTrace();
		}
	}
	else if(e.getSource() == bookPackage) {
		try {
			conn x = new conn();
			String q = "insert into bookhotel values('"+labelusername.getText()+"','"+Chotel.getSelectedItem()+"','"+tfpersons.getText()+"','"+tfdays.getText()+"','"+cac.getSelectedItem()+"','"+cfood.getSelectedItem()+"','"+labelId.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"')";
			x.s.executeUpdate(q);
			
			JOptionPane.showMessageDialog(null,"Package Booked Successfully");
			
		}catch(Exception ae) {
			ae.printStackTrace();
		}
	}
	else {
		dispose();
	}
	}

}
