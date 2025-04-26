package com.example.demo.model.DAO;

import java.sql.SQLException;
import java.sql.Statement;

public class UserDAODelete {
	DBConnection dbc = new DBConnection();
	
	public UserDAODelete() {
		dbc.connect();
	}
	
	Statement stm;
	
	public void deleteUser(int index_id) {
		
		try {
			stm.executeUpdate(String.format("DELETE FROM Login_User WHERE id = %d", index_id));
			System.out.println("Delete Succesful");
		} catch (SQLException e) {
			System.out.println("Delete not Succesful");
		}
		
	}

}
