package com.RetriveData;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
	public static Connection con=null;
	
	
	public static Connection getConnection() {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ujjwal","root","12345");
		}catch(Exception e) {

			e.printStackTrace();
		}
		
		return con;
		
		
	}

}
