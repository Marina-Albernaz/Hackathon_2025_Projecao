package com.example.demo.model.DAO;

import java.sql.SQLException;
import java.sql.Statement;

import com.example.demo.model.Residuo;

public class ResiduoDAOUpdate {
	DBConnection dbc = new DBConnection();
	Statement stm;
	
	public ResiduoDAOUpdate() {
		dbc.connect();
	}
	
	public void updateTitulo(int index_id, String titulo) {
		
		try {
			stm.executeUpdate(String.format("UPDATE Residuo_tb SET titulo = '%s' WHERE id = %d", titulo, index_id));
			System.out.println("Update Succesful");
		} catch (SQLException e) {
			System.out.println("Update not Succesful");
		}
		
	}
	
	public void updateDescricao(int index_id, String descricao) {
		
		try {
			stm.executeUpdate(String.format("UPDATE Residuo_tb SET descricao = '%s' WHERE id = %d", descricao, index_id));
			System.out.println("Update Succesful");
		} catch (SQLException e) {
			System.out.println("Update not Succesful");
		}
		
	}
	
	public void updateEndereco(int index_id, String endereco) {
		
		try {
			stm.executeUpdate(String.format("UPDATE Residuo_tb SET endereco = '%s' WHERE id = %d", endereco, index_id));
			System.out.println("Update Succesful");
		} catch (SQLException e) {
			System.out.println("Update not Succesful");
		}
		
	}
	
	public void updateCategoriaMaterial(int index_id, String categoriaMaterial) {
		
		try {
			stm.executeUpdate(String.format("UPDATE Residuo_tb SET categoriaMaterial = '%s' WHERE id = %d", categoriaMaterial, index_id));
			System.out.println("Update Succesful");
		} catch (SQLException e) {
			System.out.println("Update not Succesful");
		}
		
	}
	
public void updatePeso(int index_id, double peso) {
		
		try {
			stm.executeUpdate(String.format("UPDATE Residuo_tb SET categoriaMaterial = %f WHERE id = %d", peso, index_id));
			System.out.println("Update Succesful");
		} catch (SQLException e) {
			System.out.println("Update not Succesful");
		}
		
	}

public void updateImagens(int index_id, Residuo residuo) {
	
	try {
		stm.executeUpdate(String.format("UPDATE Residuo_tb SET imagens = '%s' WHERE id = %d", residuo.getImagens(), index_id));
		System.out.println("Update Succesful");
	} catch (SQLException e) {
		System.out.println("Update not Succesful");
	}
	
}
	
	
	
}
