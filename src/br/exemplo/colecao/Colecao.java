package br.exemplo.colecao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Colecao {
	
	public static void main(String[] args) {

		/**
		 * @author Felipe Lima
		 */
		
		//Instaciando uma colecao, as coleções vão armazena objeto String
		Collection<String> c = new ArrayList<String>();	
		
		//Adiciomando elementos em minha colecao
		c.add("A");
		c.add("E");
		c.add("I");
		
		System.out.println("Valores: "+c.toString());
		System.out.println("Esta vazio: "+c.isEmpty());
		System.out.println("Possui o elemento A? "+c.contains("A"));
		
		//Remover elemento de minha colecao
		c.remove("A");		
		System.out.println("Valores sem o A: "+c.toString());
		
		
		
		///////// TRABALHANDO COM GRUPOS DE ELEMENTOS /////////
		
		//Adicionando varios elemento a minha colecao 
		Collection<String> c2 = Arrays.asList("O","U");
		
		//addAll recebe todos os elemento de uma colecao
		c.addAll(c2); //c.addAl(c2) = C vai receber todos os elemento de C2
		System.out.println("Todos os valores de C2 adicionado: "+c.toString());
		System.out.println("Todos os elemento de C2 estão no C? "+c.containsAll(c2)); //Verifica se existem todos esses elementos
		
		c.removeAll(c2);
		System.out.println("Removido todos valores de C2: "+c.toString());
		
		
		
		/////// PERCORRER OS ELEMENTOS /////////
		
		System.out.print("Percorrendo valores da coleção: ");
		for (String valores : c) {
			System.out.print(valores+" ");
		}
		
		
		
		/////// CONVERTE COLEÇÃO PARA ARRAY /////////
		
		//Criando uma array do tamanho da minha coleção (c.size())
		String[] arrayString = c.toArray(new String[c.size()]); //Retorna uma array de string
		
		System.out.print("\nArray: ");
		System.out.println(Arrays.toString(arrayString));
		
		
		/////// LIMPANDO COLECAO /////////
		
		c.clear();
		System.out.println("Removido todos valores de c: "+c.toString());
		System.out.println("C esta vazio? "+c.isEmpty());
		
	}

}
