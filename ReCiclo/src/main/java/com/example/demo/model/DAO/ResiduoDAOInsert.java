package com.example.demo.model.DAO;

import java.sql.SQLException;
import java.sql.Statement;

import com.example.demo.model.Residuo;

public class ResiduoDAOInsert {
	DBConnection dbc = new DBConnection();
	Statement stm;
	
	public ResiduoDAOInsert() {
		dbc.connect();
	}
	
public void insertResiduo(Residuo residuo) {
		
		try {
			if(residuo.getCategoriaMaterial() != null && residuo.getDatetime() != null && residuo.getDescricao() != null && residuo.getImagens() != null && residuo.getLocalDeRecolhimento() != null && residuo.getPeso() != -1 && residuo.getTitulo() != null && residuo.getEmail() != null){
				stm.executeUpdate(String.format("INSERT INTO Residuo_tb(titulo, descricao, peso, endereco, datahora, imagens, categoriaMaterial, email) VALUES ('%s', '%s', %f, '%s', '%s', '%s', '%s', '%s')", residuo.getTitulo(), residuo.getDescricao(), residuo.getPeso(), residuo.getLocalDeRecolhimento(), residuo.getDatetime(), residuo.getImagens(), residuo.getCategoriaMaterial(), residuo.getEmail()));
				System.out.println("Insert Succesful");
			} else {
				System.out.println("Null Parameters");
			}
		} catch (SQLException e) {
			System.out.println("Insert Not Succesful");
		}
		
	}

}