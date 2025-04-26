package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.DAO.DBConnection;
import com.example.demo.model.DAO.UserDAODelete;
import com.example.demo.model.DAO.UserDAOSelect;

public class UserControllerDelete {
	
	private String currentCadastro;
	private String currentPassword;

	@PostMapping("/userDelete")
	public void setVariables(@RequestBody String currentCadastro, @RequestBody String currentPassword){
		this.currentCadastro = currentCadastro;
		this.currentPassword = currentPassword;
		processData();
		}
	
	public String processData() {
	
		DBConnection con = new DBConnection();
		con.connect();
		
		UserDAOSelect select = new UserDAOSelect();
		UserDAODelete delete = new UserDAODelete();
		int userID;
		
		userID = select.getId(this.currentCadastro,this.currentPassword);
		
		if(userID == -1) {
			return "Senha ou CPF/CNPJ Incorretos!!!";
		}
		delete.deleteUser(userID);
		return "Update Concluído com Sucesso!!!";
}
	
}
