package br.exemplo.colecao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ColecaoUtilitario {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<String> list = new ArrayList<>(); 
		list.add("Guaraná");
		list.add("Uva");
		list.add("Manga");
		list.add("Coco");
		list.add("Açai");
		list.add("Banana");
		System.out.println(list);
		
		Collections.sort(list);//Colocar elementos em orden
		System.out.println("Em orden: "+list);
		
		Collections.reverse(list);//Ordem inversa
		System.out.println("Em orden inversa: "+list);
		
		Collections.shuffle(list);//Ordem aleatoria
		System.out.println("Aleatorio: "+list);
		
		Collections.addAll(list, "Cupuaçu", "Laranja", "Laranja");//Colocar elementos em orden
		System.out.println("Novos dados: "+list);
		
		System.out.println("Quantas Laranja tem na List: "+Collections.frequency(list, "Laranja"));
		
		
		//Outra coleção
		List<String> list2 = Arrays.asList("Acerola", "Graviola");
		
		boolean temOElemento = Collections.disjoint(list, list2);
		System.out.println("Tem Acerola ou Graviola na list? "+temOElemento);
		
		Collections.sort(list);
		int indice = Collections.binarySearch(list, "Banana");
		System.out.println("Qual a posição o Guarana: "+indice);
		
		Collections.fill(list, "Açai");
		System.out.println("Subtituir por Açai: "+list);
		
		////////// COLECAO QUE NAO MODIFICA //////////
		
		Collection<String> constante = Collections.unmodifiableCollection(list);
		System.out.println("Elemento Fixo: "+constante);
	}

}
