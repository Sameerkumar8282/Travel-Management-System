import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

@SuppressWarnings("serial")
public class BookPackage extends JFrame implements ActionListener {
	
	Choice Cpackage;
	JTextField tfpersons;
	String Username;
	JLabel labelusername,labelId,labelnumber,labelphone,labelprice;
	JButton checkPrice,bookPackage,Back;
	
	BookPackage(String Username){
		
		this.Username = Username;
		
		setBounds(350,200,1100,500);
		setLayout(null);
		
		JLabel text = new JLabel("BOOK PACKAGE");
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
		
		JLabel lblpackage = new JLabel("Select Package");
		lblpackage.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblpackage.setBounds(40, 110, 120, 20);
		add(lblpackage);
		
		Cpackage = new Choice();
		Cpackage.add("Gold Package");
		Cpackage.add("Silver Package");
		Cpackage.add("Bronze Package");
		Cpackage.setBounds(250,110,200,20);
		add(Cpackage);
		
		JLabel lblpersons = new JLabel("Total Person");
		lblpersons.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblpersons.setBounds(40, 150, 150, 20);
		add(lblpersons);
		
		tfpersons = new JTextField("1");
		tfpersons.setBounds(250,150,200,25);
		add(tfpersons);
		
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(40, 190, 150, 20);
		lblId.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(lblId);
		
		labelId = new JLabel();
		labelId.setBounds(250, 190, 150, 25);
		add(labelId);
		

		JLabel lblnumber = new JLabel("Number");
		lblnumber.setBounds(40, 230, 150, 25);
		lblnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(lblnumber);
		
		labelnumber = new JLabel();
		labelnumber.setBounds(250, 230, 150, 25);
		add(labelnumber);
		
		JLabel lblphone = new JLabel("Phone");
		lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblphone.setBounds(40, 270, 150, 25);
		add(lblphone);
		
	    labelphone = new JLabel();
		labelphone.setBounds(250, 270, 150, 25);
		add(labelphone);
		
		JLabel lblprice = new JLabel("Total Price");
		lblprice.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblprice.setBounds(40, 310, 150, 25);
		add(lblprice);
		
		labelprice = new JLabel();
		labelprice.setBounds(250, 310, 150, 25);
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
		checkPrice.setBounds(60,370,120,25);
		checkPrice.setBackground(Color.BLACK);
		checkPrice.setForeground(Color.WHITE);
		checkPrice.addActionListener(this);
		add(checkPrice);
		
		bookPackage = new JButton("Book Package");
		bookPackage.setBounds(200,370,120,25);
		bookPackage.setBackground(Color.BLACK);
		bookPackage.setForeground(Color.WHITE);
		bookPackage.addActionListener(this);
		add(bookPackage);
		

		Back = new JButton("Back");
		Back.setBounds(340,370,120,25);
		Back.setBackground(Color.BLACK);
		Back.setForeground(Color.WHITE);
		Back.addActionListener(this);
		add(Back);
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bookpackage.jpg"));
		Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel i12 = new JLabel(i3);
		i12.setBounds(550, 50, 500, 300);
		add(i12);
		 
		setVisible(true);
	}

	public static void main(String[] args) {
		new BookPackage("Sam");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	if(e.getSource() == checkPrice) {
		String pack = Cpackage.getSelectedItem();
		int cost = 0;
		if(pack.equals("Gold Package")) {
			cost+= 12000;
		}
		else if(pack.equals("Silver Package")) {
			cost+= 25000;
		}
		else {
			cost+= 32000;
		}
		
		int persons = Integer.parseInt(tfpersons.getText());
		cost *= persons;
		
		labelprice.setText("Rs "+cost);
		
	}
	else if(e.getSource() == bookPackage) {
		try {
			conn x = new conn();
			String q = "insert into bookpackage values('"+labelusername.getText()+"','"+Cpackage.getSelectedItem()+"','"+tfpersons.getText()+"','"+labelId.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"')";
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
