package ProJetoCadastroColega.dao;

import java.util.ArrayList;
import java.util.List;

import ProJetoCadastroColega.model.Colega;

// Classe que utiliza o Pattern chamado Singleton
public class DbColega {
	// Refência ao único objeto na VM
	private static DbColega instancia;
	
	// Impede a construção de Objetos 
	private DbColega() {
	}
	
	// Permite obter a intância do DbContrato
	public static DbColega getInstance() {
		if(instancia == null)
			instancia = new DbColega();
		
		return instancia;
	}
	
	// Implementação da classe
	
	// Cadastro dos Objetos Colega
	private List<Colega> lista = new ArrayList<>();
	
	// Salva o objeto Colega na lista
	//Garante que não existe Colegas duplicados (nome+email)
	public void salve(Colega obj) throws ColegaException {
		boolean achou = false;
		for (Colega colega : lista) {
			if(  colega.getNome().equals(  obj.getNome() ) && 
			    colega.getEmail().equals( obj.getEmail() ) ) {
				achou = true;
				break;
			}
		}
		
		if(!achou) {
			lista.add(obj);
		} else {
			throw new ColegaException("Colega Duplicado");
		}
	}
	
	// Retorna a lista de Colegas cadastrados
	public List<Colega> lista() {
		return lista;
	}
}
