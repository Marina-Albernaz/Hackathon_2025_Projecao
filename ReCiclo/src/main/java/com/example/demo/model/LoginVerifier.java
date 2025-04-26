package com.example.demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.demo.model.DAO.DBConnection;
import com.example.demo.model.DAO.UserDAOSelect;

public class LoginVerifier {
	Statement stm;

	public boolean verify(String email, String password) {
		UserDAOSelect select = new UserDAOSelect();
		DBConnection con = new DBConnection();
		con.connect();
		
		try {
			ResultSet rs = stm.executeQuery("SELECT COUNT(id) AS total FROM Login_User");
			int count = 0;
			if(rs.next()) {
				count = rs.getInt("total");
			}
			int i = 0;
			while(i <= count) {
				try {
					if(select.getPassword(i) != null && select.getEmail(i) != null) {
						if(select.getPassword(i).equals(password) && select.getEmail(i).equals(email)) {
							System.out.println("User Verified");
							return true;
						} 
					} 
				} catch(Exception e) {
					
				}
				i++;
			}
			System.out.println("User Not Verified");
			return false;
		} catch (SQLException e) {
			System.out.println("Error in SQL Query\n" + e.getMessage());
		} 
		return false;
		
	}

}
