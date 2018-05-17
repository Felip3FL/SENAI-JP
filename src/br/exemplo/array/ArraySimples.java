package br.exemplo.array;

import java.util.Arrays; //Importa fun��es array como Arrays.toString()

public class ArraySimples {

	public static void main(String[] args){
	
	////////// STRING SIMPLES
		
	//Pode inicializar a variavel atraves de {}
	//Essa array tem 4 posi��es, pois s� atribuir os 4 valores que definiu o tamanho da array
	String[] paises = {"Brasil","R�ssia","�ndia","China"};	
	
	//Cada valor recebe uma posi��o, a parti de 0
	//Indece = posi��o do valores no array 
	
	System.out.println("Primeiro pais da array: "+paises[0]);
	System.out.println("Quantas posi��es tem essa array: "+paises.length);
	
	
	
	////////// ARRAY COM NEW
	
	//Essa array come�a com 3 array, o new inicializa a variavel
	//Vai de 0 a 2 (3 posi��es)
	int[] impares = new int[3];
	impares[0] = 1; 	impares[1] = 3; 	impares[2] = 5;
	
	
	
	///////// IMPRIMIR TODOS VALORES ARRAY 
	
	//Arrays.toString() imprimi todos os valores do array paises
	System.out.println("Valores array paises: "+Arrays.toString(paises));
	
	
	
	///////// BUSCA CAMPOS NA ARRAY
	
	int posicao; //posicao vai receber numero da possicao onde se encontra o valor RUSSIA
	posicao = Arrays.binarySearch(paises, "R�ssia");
	
	System.out.println("Russia esta na posi��o "+posicao);
	//Lembrando: indexa��o come�a na posicao 0, portanto R�ssia esta na 1 
	
	
	
	/////////// ORDENA ARRAY
	
	//Array.sort imprimi valores da array em ordem numerica ou alfabetica
	Arrays.sort(paises, 0, paises.length);
	System.out.println(Arrays.toString(paises));
	

	
	}
	
}
