package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.LoginVerifier;

public class UserControllerLogin {
	
	private String currentEmail;
	private String currentPassword;

	@PostMapping("/userLogin")
	public void setVariables(@RequestBody String currentEmail, String currentPassword){
		this.currentEmail = currentEmail;
		this.currentPassword = currentPassword;
		}

	public void processData() {
		LoginVerifier log = new LoginVerifier();
		boolean sucess = log.verify(currentEmail, currentPassword);
		
		if(sucess) {
			//TODO Redirecionar a Pagina
		} else {
			//TODO Informar o Erro no Login
		}
	}
	
}
