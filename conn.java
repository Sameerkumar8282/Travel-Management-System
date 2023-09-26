

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {
	Connection con;
    Statement s;

	conn(){
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelmangement","root","Sameer@8285");
			 s =con.createStatement();
				 System.out.println("Connection establised");
	    	}
		 catch(Exception e) {
			 System.out.println("Not establised");
		 }
	}

}
