package br.exemplo.array;

import java.util.Arrays; //Importa funções de array

public class ArrayMultidimensionais {

	public static void main(String[] args){
		
		//Array de 3 posições 
		String[] umaDimensao = {"Felipe", "Roberio", "Madalena"};
		
		//Arrays.toString() imprimir todos valores de uma variavel
		System.out.println("Array simples valores: "+Arrays.toString(umaDimensao));
		
		
		
		//ARRAY MULTIDIMENSIONAIS
		
		String[][] duasDimensao =
		{ 
				{"Felipe","SP","20"}, //Linha 1 do array multidimensional
				{"Roberio","MG","40"} //Linha 2 do array multidimensional
		};
		
		//imprimindo linha 1 do array multidimensional
		System.out.println(duasDimensao[0][0]+", "+duasDimensao[0][1]+", "+duasDimensao[0][2]);
		
		//imprimindo linha 2 do array multidimensional
		System.out.println(duasDimensao[1][0]+", "+duasDimensao[1][1]+", "+duasDimensao[1][2]);
		
		
	}
	
}
