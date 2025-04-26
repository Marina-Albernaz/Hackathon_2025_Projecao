package com.example.demo.model.DAO;

import java.sql.SQLException;
import java.sql.Statement;

import com.example.demo.model.UserEmpresa;
import com.example.demo.model.UserPessoa;

public class UserDAOInsert {
	
	DBConnection dbc = new DBConnection();
	Statement stm;
	
	public UserDAOInsert() {
		dbc.connect();
	}
	
	public void insertUser(UserPessoa user) {
		
		try {
			if(user.getUsername() != null && user.getPassword() != null && user.getEmail() != null && user.getCpf() != null){
				stm.executeUpdate(String.format("INSERT INTO Login_User(username, userpassword, usercadastro, useremail, usertype) VALUES ('%s' , '%s', '%s', '%s', 'Pessoa Física')",user.getUsername(), user.getPassword(), user.getCpf(), user.getEmail() ));
				System.out.println("Insert Succesful");
			} else {
				System.out.println("Null Parameters");
			}
		} catch (SQLException e) {
			System.out.println("Insert Not Succesful");
		}
		
	}
	
public void insertUser(UserEmpresa user) {
		
		try {
			if(user.getUsername() != null && user.getPassword() != null && user.getEmail() != null && user.getCnpj() != null){
				stm.executeUpdate(String.format("INSERT INTO Login_User(username, userpassword, usercadastro, useremail, usertype) VALUES ('%s' , '%s', '%s', '%s', 'Pessoa Física')",user.getUsername(), user.getPassword(), user.getCnpj(), user.getEmail() ));
				System.out.println("Insert Succesful");
			} else {
				System.out.println("Null Parameters");
			}
		} catch (SQLException e) {
			System.out.println("Insert Not Succesful");
		}
		
	}

}
