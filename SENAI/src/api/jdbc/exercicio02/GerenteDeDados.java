package api.jdbc.exercicio02;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class GerenteDeDados {
	private String url = "jdbc:mysql://localhost:3306/projeto";
	private Connection con;
	private PreparedStatement consultaTodos;
	private PreparedStatement removeId;
	private PreparedStatement inserirReg;
	private PreparedStatement atualizaReg;
	private PreparedStatement localizaId;
	private PreparedStatement quantos;

	// Inicializa a conexão e cria as declarações SQL
	public GerenteDeDados() throws GerenteException {
		try {
			// Registra o Driver JDBC
			Class.forName("com.mysql.jdbc.Driver");
			String nomeTabela = "cadatroContrato";
			// Inicia a conexão com Banco de Dadoscadatro
			con = DriverManager.getConnection(url, "root", "root");
			// Cria as declarações SQL para operações do Banco de Dados
			consultaTodos = con.prepareStatement("Select * from " + nomeTabela);
			removeId = con.prepareStatement("delete from " + nomeTabela + " where idContrato=?");
			inserirReg = con.prepareStatement("insert into " + nomeTabela + " (data, numero, descricao) values (?, ?, ?)");
			atualizaReg = con.prepareStatement("update " + nomeTabela + " set data=?, numero=?, descricao=? where idContrato=?");
			localizaId = con.prepareStatement("Select * from " + nomeTabela + " where idContrato=?");
			quantos = con.prepareStatement("Select count(*) as contador from " + nomeTabela + " as c");
		} catch (ClassNotFoundException ex) {
			throw new GerenteException("Driver JDBC não encontrado");
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new GerenteException("Problemas na conexão com o Banco de Dados");
		}
	}

	public void salvar(CadastroContratos obj) throws GerenteException {
		try {
			if (obj.getidContrato() == null) { // É registro Novo?
				inserirReg.setDate(1, Date.valueOf(obj.getData()));
				inserirReg.setString(2, obj.getNumero());
				inserirReg.setString(3, obj.getDescricao());
				inserirReg.execute();
			} else { // Atualiza registro
				atualizaReg.setInt(4,obj.getidContrato());
				atualizaReg.setDate(1, Date.valueOf(obj.getData()));
				atualizaReg.setString(2, obj.getNumero());
				atualizaReg.setString(3, obj.getDescricao());
				atualizaReg.execute();
			}
		} catch (SQLException ex) {
			throw new GerenteException("Erro na Conxão com o Banco de Dados");
		}
	}

	private CadastroContratos carregaRegistro(ResultSet resultado) throws SQLException {
		CadastroContratos obj = new CadastroContratos();
		obj.setidContrato(resultado.getInt("idContrato"));
		obj.setNumero(resultado.getString("data"));
		obj.setData(resultado.getDate("numero").toLocalDate());
		obj.setDescricao(resultado.getString("descricao"));
		return obj;
	}

	public List<CadastroContratos> listaTodos() throws GerenteException {
		List<CadastroContratos> lista = null;
		try {
			lista = new ArrayList<CadastroContratos>();

			ResultSet resultado = consultaTodos.executeQuery();

			while (resultado.next()) {
				lista.add(carregaRegistro(resultado));
			}
			
		} catch (SQLException ex) {
			throw new GerenteException("Erro na Conxão com o Banco de Dados");
		}
		return lista;
	}
	
	public CadastroContratos localiza(Integer id) throws GerenteException {
		CadastroContratos obj = null;
		try {
			localizaId.setInt(1, id);
			ResultSet resultado = localizaId.executeQuery();

			if(resultado.next()) {
				obj = carregaRegistro(resultado);
			}
			
		} catch (SQLException ex) {
			throw new GerenteException("Erro na Conxão com o Banco de Dados");
		}
		return obj;
	}

	public int quantos() throws GerenteException {
		int quantidade = 0;
		try {
			ResultSet resultado = quantos.executeQuery();

			if(resultado.next()) {
				quantidade = resultado.getInt(1);
			}
			
		} catch (SQLException ex) {
			throw new GerenteException("Erro na Conxão com o Banco de Dados");
		}
		return quantidade;
	}

	public void remover(Integer id) throws GerenteException {
		try {
			removeId.setInt(1, id);
			removeId.execute();
		}catch(SQLException ex) {
			throw new GerenteException("Erro na Conxão com o Banco de Dados");
		}
	}

	public void fechar() {
		try {
			con.close();
		}catch(SQLException ex) {
		}
	}
}
