package com.example.demo.model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAOSelect {
	DBConnection dbc = new DBConnection();
	Statement stm;
	
	public UserDAOSelect() {
		dbc.connect();
	}
	
public String getUsername(int index_id) {
		
		try {
			
			ResultSet rs =  stm.executeQuery(String.format("SELECT * FROM Login_User LIMIT %d, 1", index_id));
			String resultUsername;
			
			
			if(rs.next()) {
				resultUsername = rs.getString(2);
				return resultUsername;
			} 
			
			
		} catch (SQLException e) {
			System.out.println("Error\n" + e.getMessage());
			
		}
		
		return null;
	}

public String getPassword(int index_id) {
	
	try {
		
		ResultSet rs =  stm.executeQuery(String.format("SELECT * FROM Login_User LIMIT %d, 1", index_id));
		String resultPassword;
		
		
		if(rs.next()) {
			resultPassword = rs.getString(3);
			return resultPassword;
		} 
		
		
	} catch (SQLException e) {
		System.out.println("Error\n" + e.getMessage());
		
	}
	
	return null;
}

public String getCadastro(int index_id) {
	
	try {
		
		ResultSet rs =  stm.executeQuery(String.format("SELECT * FROM Login_User LIMIT %d, 1", index_id));
		String resultCadastro;
		
		
		if(rs.next()) {
			resultCadastro = rs.getString(4);
			return resultCadastro;
		} 
		
		
	} catch (SQLException e) {
		System.out.println("Error\n" + e.getMessage());
		
	}
	
	return null;
}

public String getEmail(int index_id) {
	
	try {
		
		ResultSet rs =  stm.executeQuery(String.format("SELECT * FROM Login_User LIMIT %d, 1", index_id));
		String resultEmail;
		
		
		if(rs.next()) {
			resultEmail = rs.getString(5);
			return resultEmail;
		} 
		
		
	} catch (SQLException e) {
		System.out.println("Error\n" + e.getMessage());
		
	}
	
	return null;
}

public String getUserType(int index_id) {
	
	try {
		
		ResultSet rs =  stm.executeQuery(String.format("SELECT * FROM Login_User LIMIT %d, 1", index_id));
		String resultUserType;
		
		
		if(rs.next()) {
			resultUserType = rs.getString(6);
			return resultUserType;
		} 
		
		
	} catch (SQLException e) {
		System.out.println("Error\n" + e.getMessage());
		
	}
	
	return null;
}

public int getId(String cadastro, String password) {
	
try {
		
		ResultSet rs =  stm.executeQuery(String.format("SELECT * FROM Login_User WHERE usercadastro = '%s' ", cadastro));
		int resultUserID;
		
		
		
		
		if(rs.next()) {
			resultUserID = rs.getInt(1);
			String currentPSSW = this.getPassword(resultUserID);
			if(currentPSSW == password) {
				return resultUserID;
			}
		} 
		
		
	} catch (SQLException e) {
		System.out.println("Error\n" + e.getMessage());
		
	}
	
	return -1;
	
}

}
