package br.exemplo.colecao;

import java.util.LinkedList;
import java.util.Queue;

public class ColecaoQueue {

	public static void main(String[] args) {

		//Todos elementos adicionado vão para as ultimas posições
		Queue<String> fila = new LinkedList<>();
		
		fila.add("Carinha1");
		fila.add("Carinha2");
		fila.add("Carinha3");
		fila.offer("Carinha4");//Adiciona elemento ao final da fila 
		fila.add("Carinha5");
		fila.add("Carinha6");
		System.out.println("Fila: "+fila);
		
		System.out.println("Proximo Carinha: "+fila.peek());
		
		//POLL elemina elemento do inicio da fila
		System.out.println("Tirando o "+fila.poll());
		System.out.println("Fila: "+fila);
		
		////////// OUTROS METODOS DISPONIVEIS EM LINKEDLIST ////////// 
		
		LinkedList<String> f = (LinkedList<String>) fila;
		f.addFirst("Carinha7"); //Colocar no inicio da fila
		f.addLast("Carinha8"); //Colocar no fim da fila

		System.out.println("Fila: "+fila);
		
		System.out.println("Primeiro da Fila: "+f.peekFirst());
		System.out.println("Último da Fila: "+f.peekLast());
		
		System.out.println("Tirando o primeiro da fila, o "+f.pollFirst());
		System.out.println("Tirando o ultimo da fila, o "+f.pollFirst());
		
		System.out.println("Fila: "+fila);
		
	}

}
