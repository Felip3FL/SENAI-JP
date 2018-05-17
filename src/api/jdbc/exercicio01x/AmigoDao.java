package api.jdbc.exercicio01x;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import api.jdbc.lib.GerenteException;

public class AmigoDao {
	public static AmigoDao manager = new AmigoDao();
	
	private AmigoDao() {		
	}
	
	private Connection getConnection() throws GerenteException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			return DriverManager.getConnection("jdbc:mysql://localhost/CursoJava", "root", "senai");
		} catch (ClassNotFoundException ex) {
			throw new GerenteException("Houve problema em localizar o Driver JDBC");		
		} catch (SQLException ex) {
			throw new GerenteException("Houve problema ao conectar ao Banco de Dados CursoJava");		
		}
	}
	
	// Insere um novo registro ou Atualiza um registro existente
	public void salvar(Amigo obj) throws GerenteException {
		String acao = "";
		Connection con = getConnection();
		try {
			if(obj.getId() == null) { // Insere um novo registro
				acao = "inserção";
				PreparedStatement inserirReg = con.prepareStatement("insert into amigos (nome, dataNascimento, numTelefone) values (?, ? , ?)");
				inserirReg.setString(1, obj.getNome());
				inserirReg.setDate(2, java.sql.Date.valueOf(obj.getDataNascimento()));
				inserirReg.setString(3, obj.getNumTelefone());
				inserirReg.execute();
			} else { // Atualiza um registro existente
				acao = "atualização";
				PreparedStatement atualizaReg = con.prepareStatement("update amigos set nome=?, dataNascimento=?, numTelefone=? where idAmigos=?");
				atualizaReg.setString(1, obj.getNome());
				atualizaReg.setDate(2,java.sql.Date.valueOf(obj.getDataNascimento()));
				atualizaReg.setString(3, obj.getNumTelefone());
				atualizaReg.setInt(4, obj.getId());
				atualizaReg.execute();
			}
		} catch (SQLException ex) {
			throw new GerenteException("Houve problema na " + acao + " do registro");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				throw new GerenteException("Houve problema no fechamento da conexão");
			}
		}
		
	}

	// Cria um objeto Telefone extraindo os dados do Resultado da consulta SQL
	private Amigo criaObjeto(ResultSet resultado) throws SQLException {
		Amigo obj = new Amigo();
		obj.setId(resultado.getInt("idAmigos"));
		obj.setNome(resultado.getString("nome"));
		obj.setDataNascimento(resultado.getDate("dataNascimento").toLocalDate());
		obj.setNumTelefone(resultado.getString("numTelefone"));
		return obj;
	}
	
	// Retorna a lista de todos os Telefones existentes no banco de dados
	public List<Amigo> listaTodos() throws GerenteException {
		Connection con = getConnection();
		try {			
			List<Amigo> lista = new ArrayList<>();
			Statement listaFone = con.createStatement();
			
			ResultSet resposta = listaFone.executeQuery("select * from amigos");
			while(resposta.next()) {
				Amigo obj = criaObjeto(resposta);
				lista.add(obj);
			}
			
			return lista;
		} catch(SQLException ex) {
			throw new GerenteException("Erro na consulta dos registros");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				throw new GerenteException("Houve problema no fechamento da conexão");
			}
		}
	}
}
