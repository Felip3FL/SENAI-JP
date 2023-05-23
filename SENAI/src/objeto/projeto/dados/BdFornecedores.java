package objeto.projeto.dados;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import objeto.projeto.modelo.Fornecedor;

public class BdFornecedores {
	private static BdFornecedores instancia;
	private List<Fornecedor> cad;
	
	private BdFornecedores() {
		this.cad = new ArrayList<>();
	}
	
	public static BdFornecedores getInstance() {
		if(instancia == null)
			instancia = new BdFornecedores();
		
		return instancia;
	}
	
	public void adiciona(Fornecedor obj) {
		cad.add(obj);
	}
	
	public void remove(Fornecedor obj) {
		cad.removeIf(forn -> forn.getId() == obj.getId());
		
//		for (int i = 0; i < cad.size(); i++) {
//			Fornecedor forn = cad.get(i);
//			if(forn.getId() == obj.getId()) {
//				cad.remove(obj);
//				break;
//			}
//		}
	}
	
	public List<Fornecedor> lista() {
		return cad.stream()
				.collect(Collectors.toList());
	}
}
