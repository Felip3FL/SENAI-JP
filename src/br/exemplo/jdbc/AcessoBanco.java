package br.exemplo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Felipe Lima
 * 
 *         Aula 110 - JDBC Select, Driver, Connection, Statement e Resultset
 */
public class AcessoBanco {
	public static void main(String[] args)throws Exception {

		//Conectando com o banco
		String url = "jdbc:mysql://localhost/codigos?user=root&password=fl";
		String sql = "select * from pessoa";
		try (Connection con = DriverManager.getConnection(url);
				PreparedStatement stm = con.prepareStatement(sql);
				ResultSet rs = stm.executeQuery()) {
			while(rs.next()){
				System.out.println(rs.getString("codigo")+" : "+rs.getString("nome"));
			}
		}

	}
}
