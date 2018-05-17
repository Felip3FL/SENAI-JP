package br.exemplo.colecao;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ColecaoMap {

	/**
	 * @author Felipe Lima
	 * 
	 *         MAP (N�o faz parte de � Collection) � usado para armazena chave,
	 *         aonde o primeiro campo n�o pode ser modificado, e outro campos
	 *         pode alterar seu valor
	 * 
	 */
	public static void main(String[] args) {

		//TipoChave, tipoValor
		Map<String, String> pais = new HashMap<>();
		pais.put("BR","Brasil");
		pais.put("RU","R�ssia");
		pais.put("IN","�ndia");
		pais.put("CN","China");
		System.out.println("Paises: "+pais);

		//Busca a chave BR
		System.out.println("Existe a chave BR? "+pais.containsKey("BR"));
		System.out.println("Existe a chave AG? "+pais.containsKey("AG"));
		System.out.println("Existe o valor R�ssia? "+pais.containsValue("R�ssia"));
		System.out.println("Conteudo da chave CN? "+pais.get("CN"));
		pais.remove("IN");//Remover conteudo 
		System.out.println("Paises: "+pais);
		
		
		//N�o aceita registro duplicado
		Set<String> keys = pais.keySet();
		for (String valores : keys){
			System.out.println(valores + ":" + pais.get(valores));
		}
		
		
	}

}
