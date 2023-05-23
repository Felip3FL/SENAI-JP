package api.jdbc.exercicio02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class CursoDao {
	public static CursoDao manager = new CursoDao();
	private String nomeBanco = "cadatroContrato";

	private CursoDao() {
	}

	private Connection getConnection() throws GerenteException {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			return DriverManager.getConnection("jdbc:mysql://localhost/CursoJava", "root", "root");
		} catch (ClassNotFoundException ex) {
			throw new GerenteException("Houve problema em localizar o Driver JDBC");
		} catch (SQLException ex) {
			throw new GerenteException("Houve problema ao conectar ao Banco de Dados CursoJava");
		}
	}

	// Insere um novo registro ou Atualiza um registro existente
	public void salvar(CadastroContratos obj) throws GerenteException {
		String acao = "";
		Connection con = getConnection();
		try {
			if (obj.getidContrato() == null) {
				acao = "inserção";
				PreparedStatement insereFone = con.prepareStatement("insert into " + nomeBanco + " (numero, data, descricao) values (?, ?, ?)");
				insereFone.setString(1, obj.getNumero());
				insereFone.setDate(2, Date.valueOf(obj.getData()));
				insereFone.setString(3, obj.getDescricao());
				insereFone.execute();
			} else {
				acao = "atualização";
				PreparedStatement atualizaFone = con.prepareStatement("update " + nomeBanco + " set numero=?, data=?, descricao=? where idContrato=?");
				atualizaFone.setString(1, obj.getNumero());
				atualizaFone.setDate(2, Date.valueOf(obj.getData()));
				atualizaFone.setString(3, obj.getDescricao());
				atualizaFone.setInt(4, obj.getidContrato());
				atualizaFone.execute();
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
	private CadastroContratos criaObjeto(ResultSet resultado) throws SQLException {
		CadastroContratos obj = new CadastroContratos();
		obj.setidContrato(resultado.getInt("idContrato"));
		obj.setNumero(resultado.getString("numero"));
		obj.setData(resultado.getDate("data").toLocalDate());
		obj.setDescricao(resultado.getString("descricao"));
		return obj;
	}

	// Retorna a lista de todos os Telefones existentes no banco de dados
	public List<CadastroContratos> listaTodos() throws GerenteException {
		Connection con = getConnection();
		try {			
			List<CadastroContratos> lista = new ArrayList<>();
			Statement listaFone = con.createStatement();
			
			ResultSet resposta = listaFone.executeQuery("select * from " + nomeBanco + "");
			while(resposta.next()) {
				CadastroContratos obj = criaObjeto(resposta);
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

	public CadastroContratos localiza(Integer id) throws GerenteException {
		Connection con = getConnection();
		try {			
			CadastroContratos obj = null;
			PreparedStatement localizaFone = con.prepareStatement("select * from " + nomeBanco + " where idcurso = ?");
			localizaFone.setInt(1, id);

			ResultSet resposta = localizaFone.executeQuery();
			if(resposta.next()) {
				obj = criaObjeto(resposta);
			}
			
			return obj;
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

	public void apaga(Integer id) throws GerenteException {
		Connection con = getConnection();
		try {			
			PreparedStatement apagaFone = con.prepareStatement("delete from " + nomeBanco + " where idcurso = ?");
			apagaFone.setInt(1, id);

			apagaFone.executeUpdate();
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
