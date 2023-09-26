import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

@SuppressWarnings("serial")
public class AddCustomer extends JFrame implements ActionListener {
	
	JLabel lbphone,lbemail,lbcountry,lbaddress,lbusername,labusername,idlib,lblnumber,lbname,labname,lbgender;
    @SuppressWarnings("rawtypes")
	JComboBox comboid;
    JTextField tfnumber,tfcountry,tfaddress,tfphone,tfemail;
    JRadioButton rmale,rfemale;
    JButton add,back;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	AddCustomer(String username){
		
		setBounds(450,200,850,550);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
	    lbusername = new JLabel("Username:-");
		lbusername.setBounds(30, 50, 150, 25);
		add(lbusername);
		
		labusername = new JLabel();
	    labusername.setBounds(220, 50, 150, 25);
		add(labusername);
		
		idlib = new JLabel("ID:-");
		idlib.setBounds(30, 90, 150, 25);
		add(idlib);
		
		comboid = new JComboBox(new String[] {"Passport","Adhar Card","Pan Card","Ration Card"});
		comboid.setBounds(220, 90, 150, 25);
		comboid.setBackground(Color.WHITE);
		add(comboid);
		
		
		
		 lblnumber = new JLabel("Number:-");
		lblnumber.setBounds(30, 130, 150, 25);
		add(lblnumber);
			
	tfnumber = new JTextField();
			tfnumber.setBounds(220, 130, 150, 25);
			add(tfnumber);
			
			 lbname = new JLabel("Name:-");
				lbname.setBounds(30, 170, 150, 25);
				add(lbname);
				
				labname = new JLabel();
			    labname.setBounds(220, 170, 150, 25);
				add(labname);
				
				 lbgender = new JLabel("Gender:-");
					lbgender.setBounds(30, 210, 150, 25);
					add(lbgender);
					
					rmale = new JRadioButton("Male");
					rmale.setBounds(220, 210, 70, 25);
					rmale.setBackground(Color.WHITE);
					add(rmale);
					
					rfemale = new JRadioButton("Female");
					rfemale.setBounds(300, 210, 70, 25);
					rfemale.setBackground(Color.WHITE);
					add(rfemale);
					
					ButtonGroup bg  = new ButtonGroup();
					bg.add(rmale);
					bg.add(rfemale);
					
					 lbcountry = new JLabel("Country:-");
					 lbcountry.setBounds(30,250, 150, 25);
					add(lbcountry);
							
					tfcountry = new JTextField();
					tfcountry.setBounds(220,250, 150, 25);
					add(tfcountry);
							
					 lbaddress = new JLabel("Address:-");
					lbaddress.setBounds(30, 290, 150, 25);
					add(lbaddress);
									
					tfaddress = new JTextField();
					tfaddress.setBounds(220, 290, 150, 25);
									add(tfaddress);

						 lbphone = new JLabel("Phone:-");
						lbphone.setBounds(30, 330, 150, 25);
							add(lbphone);
											
						tfphone = new JTextField();
					    tfphone.setBounds(220, 330, 150, 25);
				     	add(tfphone);
											

					  lbemail = new JLabel("Email:-");
				      lbemail.setBounds(30, 370, 150, 25);
					  add(lbemail);
													
			          tfemail = new JTextField();
				       tfemail.setBounds(220, 370, 150, 25);
				    	add(tfemail);
				    	
		  ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/newcustomer.jpg"));		    	
		  Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);	
		  ImageIcon i3 = new ImageIcon(i2);
		  JLabel image  =  new JLabel(i3);
		  image.setBounds(400,40,450,420);
		  add(image);
					
			add = new JButton("Add");
			add.setBackground(Color.BLACK);
			add.setForeground(Color.WHITE);
			add.setBounds(70, 430, 100, 25);
			add.addActionListener(this);
			add(add);
			
			back = new JButton("Back");
			back.setBackground(Color.BLACK);
			back.setForeground(Color.WHITE);
			back.setBounds(220, 430, 100, 25);
			back.addActionListener(this);
			add(back);
			
			try {
				conn c = new conn();
				ResultSet rs = c.s.executeQuery("select * from account where username = '"+username+"'");
				while(rs.next()) {
					labusername.setText(rs.getString("username"));
					labname.setText(rs.getString("name"));
				}
			}catch(Exception e) {
				e.printStackTrace();
				
			}
		
		setVisible(true); 
	}
	
	

	public static void main(String[] args) {
		new AddCustomer("Sam");

	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == add) {
			String username = labusername.getText();
			String id = (String) comboid.getSelectedItem();
			String number = tfnumber.getText();
			String name = labname.getText();
			String gender = null;
			if(rmale.isSelected()) {
				gender = "Male";	
			}
			else {
				gender = "Female";
			}
			String country = tfcountry.getText();
			String address = tfaddress.getText();
			String phone = tfphone.getText();
			String email = tfemail.getText();
			
			try {
				conn c = new conn();
				String query = "insert into customer values('"+username+"','"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+address+"','"+phone+"','"+email+"')";
			    c.s.executeUpdate(query);
			    
			    JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
			    setVisible(false);
			}catch(Exception ae) {
				ae.printStackTrace();
			}
			
		}else {
			setVisible(false);
		}
		
	}

}
