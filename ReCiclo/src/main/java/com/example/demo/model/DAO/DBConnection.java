package com.example.demo.model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	Connection con;

	public boolean connect() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ReCiclo_DB", "root", null);
			 System.out.println("Connection Succesful");
			return true;
		} catch(Exception e) {
			System.out.println("Connection Not Succesful");
			return false;
		}
		
	}
	
}
