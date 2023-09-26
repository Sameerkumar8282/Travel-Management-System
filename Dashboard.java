import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Dashboard extends JFrame implements ActionListener {
	String username;
	
	JButton deletePersonalDetails, About,Payments,NotePad,Calculator, viewBookedHotel, bookHotels,addPersonalDetails,viewDetails,updatePersonalDetails,checkPackage,bookPackage,viewPackage,viewHotels,viewDestinations;
	
	Dashboard(String username){
		this.username = username;
		//setBounds(0,0,1600,890);
		setExtendedState(JFrame.MAXIMIZED_BOTH);//maximum size of the window size
		setLayout(null);
		
		JPanel p1 = new JPanel();
		p1.setLayout(null);
		//p1.setBackground(Color.black);
		p1.setBackground(new Color(0,0,102));
		p1.setBounds(0, 0, 1600	, 65);
		add(p1);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/dashboard.png"));
		Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel icon = new JLabel(i3);
		icon.setBounds(5,0,70,70);
		p1.add(icon);
			
		JLabel heading  = new JLabel("DashBoard");
		heading.setBounds(80, 10, 300,40);
		heading.setForeground(Color.WHITE);
		heading.setFont(new Font("Thaoma",Font.BOLD,30));
		p1.add(heading);
		
		JPanel p2 = new JPanel();
		p2.setLayout(null);
		//p1.setBackground(Color.black);
		p2.setBackground(new Color(0,0,102));
		p2.setBounds(0, 65	,300,900);
		add(p2);
		
		addPersonalDetails = new JButton ("Add Personal Details");
		addPersonalDetails.setBounds(0, 0, 300, 50);
		addPersonalDetails.setBackground(new Color (0,0,102));
		addPersonalDetails.setForeground(Color.WHITE);
		addPersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
		//addPersonalDetails.setMargin(new Insets(0,0,0,60));
		addPersonalDetails.addActionListener(this);
		p2.add(addPersonalDetails);
		
		updatePersonalDetails = new JButton ("Update Personal Details");
		updatePersonalDetails.setBounds(0, 50, 300, 50);
		updatePersonalDetails.setBackground(new Color (0,0,102));
		updatePersonalDetails.setForeground(Color.WHITE);
		updatePersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
		//updatePersonalDetails.setMargin(new Insets(0,0,0,60));
		updatePersonalDetails.addActionListener(this);
		p2.add(updatePersonalDetails);
		
		viewDetails = new JButton ("View Details");
		viewDetails.setBounds(0, 100, 300, 50);
		viewDetails.setBackground(new Color (0,0,102));
		viewDetails.setForeground(Color.WHITE);
		viewDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
		//viewDetails.setMargin(new Insets(0,0,0,60));
		viewDetails.addActionListener(this);
		p2.add(viewDetails);
		
		deletePersonalDetails = new JButton ("Delete Personal Details");
		deletePersonalDetails.setBounds(0, 150, 300, 50);
		deletePersonalDetails.setBackground(new Color (0,0,102));
		deletePersonalDetails.setForeground(Color.WHITE);
		deletePersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
		//viewDetails.setMargin(new Insets(0,0,0,60));
		deletePersonalDetails.addActionListener(this);
		p2.add(deletePersonalDetails);
		
		checkPackage = new JButton ("Check Package ");
		checkPackage .setBounds(0, 200, 300, 50);
		checkPackage .setBackground(new Color (0,0,102));
		checkPackage .setForeground(Color.WHITE);
		checkPackage .setFont(new Font("Tahoma",Font.PLAIN,20));
		//viewDetails.setMargin(new Insets(0,0,0,60));
		checkPackage.addActionListener(this);
		p2.add(checkPackage);
		
		
		bookPackage = new JButton ("Book Package");
		bookPackage .setBounds(0, 250, 300, 50);
		bookPackage .setBackground(new Color (0,0,102));
		bookPackage .setForeground(Color.WHITE);
		bookPackage.setFont(new Font("Tahoma",Font.PLAIN,20));
		//viewDetails.setMargin(new Insets(0,0,0,60));
		bookPackage.addActionListener(this);
		p2.add(bookPackage);
		
		viewPackage = new JButton ("View Package");
		viewPackage .setBounds(0, 300, 300, 50);
		viewPackage .setBackground(new Color (0,0,102));
		viewPackage .setForeground(Color.WHITE);
		viewPackage.setFont(new Font("Tahoma",Font.PLAIN,20));
		//viewDetails.setMargin(new Insets(0,0,0,60));
		viewPackage.addActionListener(this);
		p2.add(viewPackage);
		
		viewHotels = new JButton ("View Hotels");
		viewHotels .setBounds(0, 350, 300, 50);
		viewHotels .setBackground(new Color (0,0,102));
		viewHotels.setForeground(Color.WHITE);
		viewHotels.setFont(new Font("Tahoma",Font.PLAIN,20));
		//viewDetails.setMargin(new Insets(0,0,0,60));
		viewHotels.addActionListener(this);
		p2.add(viewHotels);
		
		bookHotels = new JButton ("Book Hotels");
		bookHotels.setBounds(0, 400, 300, 50);
		bookHotels .setBackground(new Color (0,0,102));
		bookHotels.setForeground(Color.WHITE);
		bookHotels.setFont(new Font("Tahoma",Font.PLAIN,20));
		//viewDetails.setMargin(new Insets(0,0,0,60));
		bookHotels.addActionListener(this);
		p2.add(bookHotels);
		
		viewBookedHotel  = new JButton ("View Booked Hotel");
		viewBookedHotel.setBounds(0, 450, 300, 50);
		viewBookedHotel.setBackground(new Color (0,0,102));
		viewBookedHotel.setForeground(Color.WHITE);
		viewBookedHotel.setFont(new Font("Tahoma",Font.PLAIN,20));
		//viewDetails.setMargin(new Insets(0,0,0,60));
		viewBookedHotel.addActionListener(this);
		p2.add(viewBookedHotel);
		
		viewDestinations  = new JButton ("Destinations");
		viewDestinations .setBounds(0, 500, 300, 50);
		viewDestinations .setBackground(new Color (0,0,102));
		viewDestinations .setForeground(Color.WHITE);
		viewDestinations .setFont(new Font("Tahoma",Font.PLAIN,20));
		//viewDetails.setMargin(new Insets(0,0,0,60));
		viewDestinations.addActionListener(this);
		p2.add(viewDestinations);
		
		Payments  = new JButton ("Payments");
		Payments .setBounds(0, 550, 300, 50);
		Payments .setBackground(new Color (0,0,102));
		Payments.setForeground(Color.WHITE);
		Payments .setFont(new Font("Tahoma",Font.PLAIN,20));
		//viewDetails.setMargin(new Insets(0,0,0,60));
		Payments.addActionListener(this);
		p2.add(Payments);
		
		Calculator  = new JButton ("Calculator ");
		Calculator  .setBounds(0, 600, 300, 50);
		Calculator  .setBackground(new Color (0,0,102));
		Calculator .setForeground(Color.WHITE);
		Calculator .setFont(new Font("Tahoma",Font.PLAIN,20));
		//viewDetails.setMargin(new Insets(0,0,0,60));
		Calculator.addActionListener(this);
		p2.add(Calculator);
		
		NotePad = new JButton ("NotePad ");
		NotePad  .setBounds(0, 650, 300, 50);
		NotePad  .setBackground(new Color (0,0,102));
		NotePad .setForeground(Color.WHITE);
		NotePad  .setFont(new Font("Tahoma",Font.PLAIN,20));
		//viewDetails.setMargin(new Insets(0,0,0,60));
		NotePad.addActionListener(this);
		p2.add(NotePad);
		
	    About = new JButton ("About");
		About .setBounds(0, 700, 300, 50);
		About .setBackground(new Color (0,0,102));
		About.setForeground(Color.WHITE);
		About.setFont(new Font("Tahoma",Font.PLAIN,20));
		//viewDetails.setMargin(new Insets(0,0,0,60));
		About.addActionListener(this);
		p2.add(About);
		
		//frame me image add karne ke liye.
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("Icon/home.jpg"));
		Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		JLabel image = new JLabel(i6);
		image.setBounds(0, 0, 1650, 1000);
		add(image);
		
		JLabel text = new JLabel("Travel and Tourism Mangment System");
		text.setBounds(400,70,1200,70);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Raleway",Font.PLAIN,55));
		image.add(text);
			
		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
	new Dashboard("");	
 }

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addPersonalDetails) {
			new AddCustomer(username);
		}else if(e.getSource()== viewDetails) {
			new ViewCustomer(username);
		}
		else if(e.getSource() == updatePersonalDetails) {
			new UpdateCustomer(username);
		}
		else if(e.getSource() == checkPackage) {
			new checkPackage();
		}
		else if(e.getSource() == bookPackage) {
			new BookPackage(username);
		}
		else if(e.getSource() == viewPackage) {
			new ViewPackage(username);
		}
		else if(e.getSource() == viewHotels) {
			new Checkhotels();
		}
		else if(e.getSource() == viewDestinations) {
			new Destination();
		}
		else if(e.getSource() == bookHotels) {
			new BookHotel(username);
		}
		else if(e.getSource() == viewBookedHotel) {
			new viewBookedHotel(username);
		}
		else if(e.getSource() == Payments) {
			new Payment();
		}
		else if(e.getSource() == Calculator) {
			try {
				Runtime.getRuntime().exec("calc.exe");
			}catch(Exception a) {
				a.printStackTrace();
			}
		}
		else if(e.getSource() == NotePad) {
			try {
				Runtime.getRuntime().exec("notepad.exe");
			}catch(Exception a) {
				a.printStackTrace();
			}
		}
		else if(e.getSource() == About) {
			new About();
		}
		else if(e.getSource() == deletePersonalDetails) {
			new DeleteDetails(username);
		}
		
	}
}