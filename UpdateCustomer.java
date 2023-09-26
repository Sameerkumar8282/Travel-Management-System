import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

@SuppressWarnings("serial")
public class UpdateCustomer extends JFrame implements ActionListener {
	
	JLabel lbphone,lbemail,lbcountry,lbaddress,lbusername,labusername,idlib,lblnumber,lbname,labname,lbgender;
    @SuppressWarnings("rawtypes")
	JComboBox comboid;
    JTextField tfnumber,tfcountry,tfaddress,tfphone,tfemail,tfgender,tfid;
    JRadioButton rmale,rfemale;
    JButton add,back;
	
	
	UpdateCustomer(String username){
		
		setBounds(500,200,850,550);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		JLabel text = new JLabel("Update Customer Details");
		text.setBounds(50,0,300,25);
		text.setFont(new Font("Thoma",Font.PLAIN,20));
		add(text);
		
	    lbusername = new JLabel("Username:-");
		lbusername.setBounds(30, 50, 150, 25);
		add(lbusername);
		
		labusername = new JLabel();
	    labusername.setBounds(220, 50, 150, 25);
		add(labusername);
		
		idlib = new JLabel("ID:-");
		idlib.setBounds(30, 90, 150, 25);
		add(idlib);
		
		
		
		tfid = new JTextField();
		tfid.setBounds(220, 90, 150, 25);
		add(tfid);
		
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
					
					
					tfgender = new JTextField();
					tfgender.setBounds(220, 210, 150, 25);
					add(tfgender);
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
				    	
		  ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/update.png"));		    	
		  Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);	
		  ImageIcon i3 = new ImageIcon(i2);
		  JLabel image  =  new JLabel(i3);
		  image.setBounds(500,50,300,420);
		  add(image);
					
			add = new JButton("Update");
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
				ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
				while(rs.next()) {
					labusername.setText(rs.getString("username"));
					labname.setText(rs.getString("name"));
					tfid.setText(rs.getString("id"));
					tfnumber.setText(rs.getString("number"));
					tfgender.setText(rs.getString("gender"));
					tfcountry.setText(rs.getString("country"));
					tfaddress.setText(rs.getString("address"));
					tfphone.setText(rs.getString("phone"));
					tfemail.setText(rs.getString("email"));
				}
			}catch(Exception e) {
				e.printStackTrace();
				
			}
		
		setVisible(true); 
	}
	
	

	public static void main(String[] args) {
		new UpdateCustomer("Sam");

	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == add) {
			String username = labusername.getText();
			String id = tfid.getText();
			String number = tfnumber.getText();
			String name = labname.getText();
			String gender = tfgender.getText();
			String country = tfcountry.getText();
			String address = tfaddress.getText();
			String phone = tfphone.getText();
			String email = tfemail.getText();
			
			try {
				conn c = new conn();
				String query = "update customer set username = '"+username+"',id = '"+id+"',number = '"+number+"',name = '"+name+"',gender = '"+gender+"',country = '"+country+"',address = '"+address+"',phone = '"+phone+"',email = '"+email+"'";
			    c.s.executeUpdate(query);
			    
			    JOptionPane.showMessageDialog(null, "Customer Details Updated Successfully");
			    setVisible(false);
			}catch(Exception ae) {
				ae.printStackTrace();
			}
			
		}else {
			setVisible(false);
		}
		
	}

}
