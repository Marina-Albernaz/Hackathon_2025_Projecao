package com.example.demo.model.DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.demo.model.Residuo;
import com.example.demo.model.User;

public class ResiduoDAOSelect {
	
	DBConnection dbc = new DBConnection();
	Statement stm;
	
	public ResiduoDAOSelect() {
		dbc.connect();
	}
	
public String getTitulo(int index_id) {
		
		try {
			
			ResultSet rs =  stm.executeQuery(String.format("SELECT * FROM Residuo_tb LIMIT %d, 1", index_id));
			String resultTitulo;
			
			
			if(rs.next()) {
				resultTitulo = rs.getString(2);
				return resultTitulo;
			} 
			
			
		} catch (SQLException e) {
			System.out.println("Error\n" + e.getMessage());
			
		}
		
		return null;
	}

public String getDescricao(int index_id) {
	
	try {
		
		ResultSet rs =  stm.executeQuery(String.format("SELECT * FROM Residuo_tb LIMIT %d, 1", index_id));
		String resultDescricao;
		
		
		if(rs.next()) {
			resultDescricao = rs.getString(3);
			return resultDescricao;
		} 
		
		
	} catch (SQLException e) {
		System.out.println("Error\n" + e.getMessage());
		
	}
	
	return null;
}

public double getPeso(int index_id) {
	
	try {
		
		ResultSet rs =  stm.executeQuery(String.format("SELECT * FROM Residuo_tb LIMIT %d, 1", index_id));
		double resultPeso;
		
		
		if(rs.next()) {
			resultPeso = rs.getDouble(4);
			return resultPeso;
		} 
		
		
	} catch (SQLException e) {
		System.out.println("Error\n" + e.getMessage());
		
	}
	
	return -1;
}


public String getEndereco(int index_id) {
	
	try {
		
		ResultSet rs =  stm.executeQuery(String.format("SELECT * FROM Residuo_tb LIMIT %d, 1", index_id));
		String resultEndereco;
		
		
		if(rs.next()) {
			resultEndereco = rs.getString(5);
			return resultEndereco;
		} 
		
		
	} catch (SQLException e) {
		System.out.println("Error\n" + e.getMessage());
		
	}
	
	return null;
}

public String getDatetime(int index_id) {
	
	try {
		
		ResultSet rs =  stm.executeQuery(String.format("SELECT * FROM Residuo_tb LIMIT %d, 1", index_id));
		String resultDatetime;
		
		
		if(rs.next()) {
			resultDatetime = rs.getString(6);
			return resultDatetime;
		} 
		
		
	} catch (SQLException e) {
		System.out.println("Error\n" + e.getMessage());
		
	}
	
	return null;
}

public String getImagens(int index_id) {
	
	try {
		
		ResultSet rs =  stm.executeQuery(String.format("SELECT * FROM Residuo_tb LIMIT %d, 1", index_id));
		String resultImagens;
		
		
		if(rs.next()) {
			resultImagens = rs.getString(7);
			return resultImagens;
		} 
		
		
	} catch (SQLException e) {
		System.out.println("Error\n" + e.getMessage());
		
	}
	
	return null;
}

public String getCategoriaMaterial(int index_id) {
	
	try {
		
		ResultSet rs =  stm.executeQuery(String.format("SELECT * FROM Residuo_tb LIMIT %d, 1", index_id));
		String resultCategoriaMaterial;
		
		
		if(rs.next()) {
			resultCategoriaMaterial = rs.getString(8);
			return resultCategoriaMaterial;
		} 
		
		
	} catch (SQLException e) {
		System.out.println("Error\n" + e.getMessage());
		
	}
	
	return null;
}

public String getEmail(int index_id) {
	
	try {
		
		ResultSet rs =  stm.executeQuery(String.format("SELECT * FROM Residuo_tb LIMIT %d, 1", index_id));
		String resultEmail;
		
		
		if(rs.next()) {
			resultEmail = rs.getString(9);
			return resultEmail;
		} 
		
		
	} catch (SQLException e) {
		System.out.println("Error\n" + e.getMessage());
		
	}
	
	return null;
}

public int countRowsPerEmail(String email) {
try {
		
		ResultSet rs =  stm.executeQuery(String.format("SELECT COUNT(id) AS total FROM Residuo_tb WHERE email = '%s'", email));
		int resultCount;
		
		
		if(rs.next()) {
			resultCount = rs.getInt("total");
			return resultCount;
		} 
		
		
	} catch (SQLException e) {
		System.out.println("Error\n" + e.getMessage());
		
	}
	return -1;
}

public List<Residuo> getFullList(User user){
	
	Connection con = null;
	try {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ReCiclo_DB", "root", null);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	String userEmail = user.getEmail();
	List<Residuo> residuos = new ArrayList<>();

	String sql = "SELECT * FROM residuos WHERE email = ?";

	try (PreparedStatement stmt = con.prepareStatement(sql)) {
	    stmt.setString(1, userEmail);
	    ResultSet rs = stmt.executeQuery();

	    while (rs.next()) {
	        Residuo residuo = new Residuo(
	            rs.getInt("id"),
	            rs.getString("titulo"),
	            rs.getString("descricao"),
	            // Aqui você vai ter que fazer algo com "categoria" se ela for objeto e não simples id
	            // Vou assumir que categoria é um inteiro agora
	            rs.getString("categoriaMaterial"),
	            rs.getString("email"),
	            // Aqui "imagens" é um problema, porque array no SQL não é padrão - vamos falar disso abaixo
	            parseImagens(rs.getString("imagens")),
	            rs.getString("endereco"),
	            rs.getDouble("peso"),
	            rs.getString("datahora")
	        );
	        residuos.add(residuo);
	    }
	    
	    return residuos;
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	
	return null;
}

private static List<String> parseImagens(String imagensStr) {
    if (imagensStr == null || imagensStr.isEmpty()) return new ArrayList<>();
    return Arrays.asList(imagensStr.split(","));
}


}
