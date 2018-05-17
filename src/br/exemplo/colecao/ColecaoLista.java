package br.exemplo.colecao;

import java.util.ArrayList;
import java.util.List;

public class ColecaoLista {

	/**
	 * @author Felipe Lima
	 * 
	 *         Collection > List � uma cole��o ordenada e pode trabalha com dados duplicados
	 *         As classes que implementa essa List s�o:
	 *         - Vector
	 *         - ArrayList
	 *         - LinkedList
	 */

	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();
		list.add("Futebol");
		list.add("Basquete");
		list.add("Volei");
		list.add("Nata��o");
		list.add("Boxe");
		list.add("Futebol");
		 
		System.out.println("Minha cole��o: "+list);
		
		//Imprimindo Lista
		for(int i=0; i < list.size(); i++){
			String letra = list.get(i);
			list.set(i, letra.toUpperCase());//Deixa list com caixa alta
		}
		
		System.out.println("Cole��o com caixa alta: "+list);
		System.out.println("Boxe esta em qual posicao: "+list.indexOf("BOXE"));
		System.out.println("Lista elementos de 2 a 5: "+list.subList(2, 5));
		list.subList(2, 4).clear();//Retirar a sub-lista a lista principal
		System.out.println("Removido sub-lista 2 a 4: "+list);
		
	}

}
