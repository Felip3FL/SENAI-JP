package br.exemplo.array;

import java.util.ArrayList; //Importa classe do ArrayList

public class ArrayLista {

	public static void main (String[] args){
		
		///////// Collection Framework ArrayList
		
		///////// ADICIONAR
		
		//Adicionando dados
		ArrayList<String> cores = new ArrayList<>();
	
		cores.add("Branco"); //Adicionando valor na array
		//Equivale a fazer isso: cores[0] = "Branco"
		
		System.out.println("Valores: "+cores.toString()+"   Tamanho Array: "+cores.size());
		
		
		//Adicionando mais dados
		cores.add("Azul");
		
		System.out.println("Valores: "+cores.toString()+"   Tamanho Array: "+cores.size());
		
		
		//Definindo o indice do array
		cores.add(0, "Verde");
		
		//cores.size() é o tamanho do vetor cores
		System.out.println("Valores: "+cores.toString()+"   Tamanho Array: "+cores.size());
		System.out.println("Elemento no indice 2: "+cores.get(2));
	
				
		
		///////// REMOVER
		
		//Remover a cor azul do array
		cores.remove("Azul");
		
		
		
		///////// PESQUISA
		
		//indexOf("Branco") pesquisa no array e traz o indice do array do valor
		System.out.println("Indice do verde: "+cores.indexOf("Branco"));
		
		
		
		///////// RECUPERAR
		
		//Pesquisa na array se possui o elemento
		boolean amarelo = cores.contains("Amarel");
		
		System.out.println("Tem a cor amarelo? "+ amarelo );
		System.out.println("Valores: "+cores.toString()+"   Tamanho Array: "+cores.size());
		
	}
	
}
