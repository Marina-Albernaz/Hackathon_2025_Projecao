package com.example.demo.model.DAO;

import java.sql.SQLException;
import java.sql.Statement;

public class ResiduoDAODelete {
	DBConnection dbc = new DBConnection();
Statement stm;

public ResiduoDAODelete() {
	dbc.connect();
}
	
	public void deleteResiduo(int index_id) {
		
		try {
			stm.executeUpdate(String.format("DELETE FROM Residuo_tb WHERE id = %d", index_id));
			System.out.println("Delete Succesful");
		} catch (SQLException e) {
			System.out.println("Delete not Succesful");
		}
		
	}

}
