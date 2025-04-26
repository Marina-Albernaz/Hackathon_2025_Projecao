package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.DAO.DBConnection;
import com.example.demo.model.DAO.UserDAOSelect;
import com.example.demo.model.DAO.UserDAOUpdate;



@RestController
@RequestMapping("/api")
public class UserControllerUpdate {
	
	private String newUsername;
	private String newCadastro;
	private String newPassword;
	private String newEmail;
	private String currentCadastro;
	private String currentPassword;
	private String tipoUpdate;


	
	@PostMapping("/userUpdate")
	public void setVariables(@RequestBody String currentCadastro, @RequestBody String currentPassword,@RequestBody String username,@RequestBody  String cadastro,@RequestBody String password,@RequestBody String email,@RequestBody String tipoUpdate){
		this.newUsername = username;
		this.newCadastro = cadastro;
		this.newPassword = password;
		this.newEmail = email;
		this.tipoUpdate = tipoUpdate;
		this.currentCadastro = currentCadastro;
		this.currentPassword = currentPassword;
		processData();
		}
	
	public String processData() {
		
		DBConnection con = new DBConnection();
		con.connect();
		
		UserDAOSelect select = new UserDAOSelect();
		UserDAOUpdate update = new UserDAOUpdate();
		int userID;
		
		switch(this.tipoUpdate) {
		
		case "Nome de Usuário":
			userID = select.getId(this.currentCadastro,this.currentPassword);
			
			if(userID == -1) {
				return "Senha ou CPF/CNPJ Incorretos!!!";
			} else {
				update.updateUsername(userID, newUsername);
				return "Update Concluído com Sucesso!!!";
			}
			
		case "Senha do Usuário":
			userID = select.getId(this.currentCadastro,this.currentPassword);
			
			if(userID == -1) {
				return "Senha ou CPF/CNPJ Incorretos!!!";
			} else {
				update.updatePassword(userID, newPassword);
				return "Update Concluído com Sucesso!!!";
			}
			
		case "CPF/CNPJ do Usuário":
			userID = select.getId(this.currentCadastro,this.currentPassword);
			
			if(userID == -1) {
				return "Senha ou CPF/CNPJ Incorretos!!!";
			} else {
				update.updateCadastro(userID, newCadastro);
				return "Update Concluído com Sucesso!!!";
			}
			
		case "Email do Usuário":
			userID = select.getId(this.currentCadastro,this.currentPassword);
			
			if(userID == -1) {
				return "Senha ou CPF/CNPJ Incorretos!!!";
			} else {
				update.updateEmail(userID, newEmail);
				return "Update Concluído com Sucesso!!!";
			}
			
		default:
			return "Um Erro Ocorreu!!!";
		}
		
	}

}
