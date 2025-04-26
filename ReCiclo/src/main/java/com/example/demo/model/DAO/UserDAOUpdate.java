package com.example.demo.model.DAO;

import java.sql.SQLException;
import java.sql.Statement;

public class UserDAOUpdate {
	DBConnection dbc = new DBConnection();
	Statement stm;
	
	public UserDAOUpdate() {
		dbc.connect();
	}
	
		public void updateUsername(int index_id, String username) {
			
			try {
				stm.executeUpdate(String.format("UPDATE Login_User SET username = '%s' WHERE id = %d", username, index_id));
				System.out.println("Update Succesful");
			} catch (SQLException e) {
				System.out.println("Update not Succesful");
			}
			
		}
		
		public void updatePassword(int index_id, String password) {
			
			try {
				stm.executeUpdate(String.format("UPDATE Login_User SET userpassword = '%s' WHERE id = %d", password, index_id));
				System.out.println("Update Succesful");
			} catch (SQLException e) {
				System.out.println("Update not Succesful");
			}
			
		}
	
		public void updateCadastro(int index_id, String cadastro) {
			
			try {
				stm.executeUpdate(String.format("UPDATE Login_User SET usercadastro = '%s' WHERE id = %d", cadastro, index_id));
				System.out.println("Update Succesful");
			} catch (SQLException e) {
				System.out.println("Update not Succesful");
			}
			
		}
		
		public void updateEmail(int index_id, String email) {
			
			try {
				stm.executeUpdate(String.format("UPDATE Login_User SET useremail = '%s' WHERE id = %d", email, index_id));
				System.out.println("Update Succesful");
			} catch (SQLException e) {
				System.out.println("Update not Succesful");
			}
			
		}
	

}
