package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserEmpresa;
import com.example.demo.model.UserPessoa;
import com.example.demo.model.DAO.DBConnection;
import com.example.demo.model.DAO.UserDAOInsert;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class UserControllerInsert {

	private String username;
	private String cadastro;
	private String password;
	private String email;
	private String tipoCadastro;
	
	@PostMapping("/userInsert")
	public void setVariables(@RequestBody String username,@RequestBody  String cadastro,@RequestBody String password,@RequestBody String email,@RequestBody String tipoCadastro){
		this.username = username;
		this.cadastro = cadastro;
		this.password = password;
		this.email = email;
		this.tipoCadastro = tipoCadastro;
		processData();
		}
	
	public void processData() {
		
		if(tipoCadastro.equals("Pessoa Física")) {
			DBConnection con = new DBConnection();
			con.connect();
			
			UserPessoa newUser = new UserPessoa();
			newUser.setCpf(cadastro);
			newUser.setEmail(email);
			newUser.setPassword(password);
			newUser.setUsername(username);
			
			
			UserDAOInsert ins = new UserDAOInsert();
			ins.insertUser(newUser);
			
		} else if(tipoCadastro.equals("Pessoa Jurídica")) {
			DBConnection con = new DBConnection();
			con.connect();
			
			UserEmpresa newUser = new UserEmpresa();
			newUser.setCnpj(cadastro);
			newUser.setEmail(email);
			newUser.setPassword(password);
			newUser.setUsername(username);
			
			
			UserDAOInsert ins = new UserDAOInsert();
			ins.insertUser(newUser);
		}
		
	}
	
	
}
