package br.exemplo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IncluitDados {

	public static void main(String[] args) throws SQLException {

		String url = "jdbc:mysql://localhost/codigos?user=root&password=fl";
		String sql = "insert into pessoa values (?,?,?,?)";

		String[] pessoas = { "Roberio", "Madalena", "Paloma" };

		try (Connection con = DriverManager.getConnection(url)) {
			try (PreparedStatement stm = con.prepareStatement(sql)) {
				for (int i = 0; i < pessoas.length; i++) {
					stm.setInt(1, i + 2);
					stm.setString(2, pessoas[i]);
					stm.setString(3, "F");
					stm.setString(4, pessoas[i].toLowerCase() + "@hotmail.com");
					stm.addBatch();//Conjutos de comandos
				}
				stm.executeBatch(); //Executa varios comandos de uma vez
			} catch (SQLException e) {
			}
			sql = "select nome, email from pessoa";
			try (PreparedStatement stm2 = con.prepareStatement(sql);
					ResultSet rs = stm2.executeQuery()) {
				while (rs.next()) {
					System.out.println(rs.getString(1) + ":" + rs.getString(2));
				}
			}
		}

	}
}
