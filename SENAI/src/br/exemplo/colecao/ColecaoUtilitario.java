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
		list.add("Guaran�");
		list.add("Uva");
		list.add("Manga");
		list.add("Coco");
		list.add("A�ai");
		list.add("Banana");
		System.out.println(list);
		
		Collections.sort(list);//Colocar elementos em orden
		System.out.println("Em orden: "+list);
		
		Collections.reverse(list);//Ordem inversa
		System.out.println("Em orden inversa: "+list);
		
		Collections.shuffle(list);//Ordem aleatoria
		System.out.println("Aleatorio: "+list);
		
		Collections.addAll(list, "Cupua�u", "Laranja", "Laranja");//Colocar elementos em orden
		System.out.println("Novos dados: "+list);
		
		System.out.println("Quantas Laranja tem na List: "+Collections.frequency(list, "Laranja"));
		
		
		//Outra cole��o
		List<String> list2 = Arrays.asList("Acerola", "Graviola");
		
		boolean temOElemento = Collections.disjoint(list, list2);
		System.out.println("Tem Acerola ou Graviola na list? "+temOElemento);
		
		Collections.sort(list);
		int indice = Collections.binarySearch(list, "Banana");
		System.out.println("Qual a posi��o o Guarana: "+indice);
		
		Collections.fill(list, "A�ai");
		System.out.println("Subtituir por A�ai: "+list);
		
		////////// COLECAO QUE NAO MODIFICA //////////
		
		Collection<String> constante = Collections.unmodifiableCollection(list);
		System.out.println("Elemento Fixo: "+constante);
	}

}
