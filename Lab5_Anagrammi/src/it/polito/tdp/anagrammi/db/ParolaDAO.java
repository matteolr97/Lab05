package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class ParolaDAO {

public boolean esisteParola(String nome) {
		
	Connection conn = ConnectDB.getConnection();		try {
		
		String sql = "SELECT nome FROM parola WHERE nome = ? ";

		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1,  nome);
		ResultSet rs = st.executeQuery();
		
		boolean result;
		if(rs.next())
				result = true;
		else 
			result =  false;
		
		conn.close();
		return result;
		
		
		
	} catch(SQLException e ) {
		e.printStackTrace();
	}
		return false;
	}
	
}
