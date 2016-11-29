package api.jdbc.resposta.ex01x;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import api.jdbc.lib.DB;
import api.jdbc.lib.GerenteException;

public class AmigoDao2 {
	private Connection con;
	private PreparedStatement consultaTodos;
	private PreparedStatement removeId;
	private PreparedStatement inserirReg;
	private PreparedStatement atualizaReg;

	public AmigoDao2() throws GerenteException {
		try {
			con = DB.newInstance().getConnection("api.jdbc.resposta.amigos.amigos");

			// Cria as declarações SQL para operações do Banco de Dados
			consultaTodos = con.prepareStatement("Select * from amigos");
			removeId = con.prepareStatement("delete from amigos where idAmigos=?");
			inserirReg = con.prepareStatement("insert into amigos (nome, dataNascimento, numTelefone) values (?, ? , ?)");
			atualizaReg = con.prepareStatement("update amigos set nome=?, dataNascimento=?, numTelefone=? where idAmigos=?");
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new GerenteException(
					"Problemas na conexão com o Banco de Dados");
		}
	}

	public void salvar(Amigo obj) throws GerenteException {
		try {
			if (obj.getId() == null) { // É registro Novo?
				inserirReg.setString(1, obj.getNome());
				inserirReg.setDate(2, java.sql.Date.valueOf(obj.getDataNascimento()));
				inserirReg.setString(3, obj.getNumTelefone());
				inserirReg.execute();
			} else { // Atualiza registro
				atualizaReg.setString(1, obj.getNome());
				atualizaReg.setDate(2,java.sql.Date.valueOf(obj.getDataNascimento()));
				atualizaReg.setString(3, obj.getNumTelefone());
				atualizaReg.setInt(4, obj.getId());
				atualizaReg.execute();
			}
		} catch (SQLException ex) {
			throw new GerenteException("Erro na Conexão com o Banco de Dados");
		}
	}

	public List<Amigo> listaTodos() throws GerenteException {
		List<Amigo> lista = null;
		try {
			lista = new ArrayList<Amigo>();

			ResultSet resultado = consultaTodos.executeQuery();

			while (resultado.next()) {
				Amigo obj = new Amigo();
				obj.setId(resultado.getInt("idAmigos"));
				obj.setNome(resultado.getString("nome"));
				obj.setDataNascimento(resultado.getDate("dataNascimento").toLocalDate());
				obj.setNumTelefone(resultado.getString("numTelefone"));
				lista.add(obj);
			}

		} catch (SQLException ex) {
			throw new GerenteException("Erro na Conxão com o Banco de Dados");
		}
		return lista;
	}

	public void remover(Integer id) throws GerenteException {
		try {
			removeId.setInt(1, id);
			removeId.execute();
		} catch (SQLException ex) {
			throw new GerenteException("Erro na Conxão com o Banco de Dados");
		}
	}

	public void fechar() {
		try {
			DB.newInstance().close("api.jdbc.resposta.amigos.amigos");
		} catch (GerenteException ex) {
		}
	}
}
