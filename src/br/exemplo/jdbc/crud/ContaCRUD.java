package br.exemplo.jdbc.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContaCRUD {

	//Aula - 112 - JDBC CRUD, Create, Read, Update e Delete CRUD - Create, Read, Update e Delete
	//Aula - 114 - Teste Unitário com JUnit

	//Criar, Ler, Alterar e Excluir Dados.

	//create table conta( 
	//numero int(2) not null, 
	//cliente varchar(15), 
	//saldo int(10), 
	//constraint conta_numero_pk primary key (numero) );

	public void transgerir(Connection con, Conta origem, Conta destino, double valor) throws SQLException{
		if(origem.saldo >= valor){
		

			try{
				//AutoCommit - Conexao nao auto commit todas as operações
				con.setAutoCommit(false);
			
			//SAQUE
			origem.saldo -= valor;
			alterar(con, origem);
			
			//int x = 1 / 0; //Erro de teste
			
			//DEPOSITO
			destino.saldo += valor;
			alterar(con, destino);
			
			//Se tudo der certo, manda seguir com as operações no banco de dados
			con.commit();
			
			}catch(Exception erro){
				//Desfazer a trazação do banco de dados
				con.rollback();
			}
			
			
		}
	}
	
	public void criar(Connection con, Conta conta) throws SQLException {
		String sql = "insert into conta values (?,?,?)";
		try (PreparedStatement stm = con.prepareStatement(sql)) {
			stm.setInt(1, conta.numero);
			stm.setString(2, conta.cliente);
			stm.setDouble(3, conta.saldo);
			
			stm.executeUpdate();
		}
	}

	public List<Conta> ler(Connection con) throws SQLException {
		List<Conta> lista = new ArrayList<>();
		String sql = "select numero,cliente,saldo from conta";
		try (PreparedStatement stm = con.prepareStatement(sql); ResultSet rs = stm.executeQuery()) {
			while (rs.next()) {
				lista.add(new Conta(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
			}
		}
		return lista;
	}

	public void alterar(Connection con, Conta conta) throws SQLException {
		String sql = "update conta set cliente=?, saldo=? where numero=?";
		try (PreparedStatement stm = con.prepareStatement(sql)) {
			stm.setInt(3, conta.numero);
			stm.setString(1, conta.cliente);
			stm.setDouble(2, conta.saldo);
			
			stm.executeUpdate();
		}
	}
	
	public void excluir(Connection con, Conta conta) throws SQLException {
		String sql = "delete conta where numero=?";
		try (PreparedStatement stm = con.prepareStatement(sql)) {
			stm.setInt(1, conta.numero);
			stm.executeUpdate();
		}
	}
	
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost/codigos?user=root&password=fl";
		try (Connection con = DriverManager.getConnection(url)) {
			ContaCRUD crud = new ContaCRUD();
			
//			//CRIAR NOVAS CONTAS
//			Conta conta1 = new Conta(1,"Felipe",1000.10);
//			Conta conta2 = new Conta(2,"Roberio",2000.25);
//			Conta conta3 = new Conta(3,"Paloma",2300.00);
//			//crud.criar(con, conta1);
//			//crud.criar(con, conta2);
//			//crud.criar(con, conta3);
//			
//			//ALTERAR DADOS
//			conta1.saldo = 9000.99;
//			crud.alterar(con, conta1);
//			conta1.saldo = 8000.99;
//			crud.alterar(con, conta3);
//			
//			//EXCLUIR
//			crud.excluir(con, conta2);
			
			
			
			List<Conta> contas = crud.ler(con);
			for (Conta conta : contas) {
				System.out.println(conta);
			}
			
			Conta origem = contas.get(0);//Pegar a primeira conta da lista
			Conta destino = contas.get(1);
			crud.transgerir(con, origem, destino, 500);
			
			contas = crud.ler(con);
			for (Conta conta : contas) {
				System.out.println(conta);
			}

			
		} catch (SQLException e) {
		}

	}

}
