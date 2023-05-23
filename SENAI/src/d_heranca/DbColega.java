package d_heranca;

import java.util.ArrayList;
import java.util.List;

// Classe que ultiliza o Pattern chamado Singleton
public class DbColega {
	//Refência ao único objeto na VM
	private static DbColega instancia;
	
	// Impede a construção de Objetos
	private DbColega(){
		
	}
	
	// Permite obter a intância do DbContrato
	public static DbColega getInstance(){
		if(instancia == null)
			instancia = new DbColega();
		
		return instancia;
		
	}
	
	// Implementação da classe
	
	// Cadastro dos Objetos Colega
	private List<Colega> lista = new ArrayList<>();
	
	// Salva o objeto Colega na lista
	//TODO: Garantir que não existem Colegas duplicados (nome+email)
	public void salve(Colega obj){
		lista.add(obj);
	}
	
	// Retorna a lista de Colegas cadastrados
	public List<Colega> lista(){
		return lista;
	}
	
	
	
}
