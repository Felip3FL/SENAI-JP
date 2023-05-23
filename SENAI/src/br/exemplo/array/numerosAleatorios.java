package br.exemplo.array;

import java.util.Random; //Carregar valores aleatorio

public class numerosAleatorios {

	public static void main (String[] args){
		
		String[] faces = {"A","2","3","4","5","6","7","8","9","10"};
		String[] nipes = {"Espadas","Paus","Copas","Ouros"};
		
		Random sorteaNumero = new Random(); //Carregar a classe RANDOM
	
		int indiceFace = sorteaNumero.nextInt(faces.length); //Vai sortear numero, de 0 até o tamanho do array
		String face = faces[indiceFace]; //face receber o valor do array faces[nuemroSorteado] (Não o numero sorteado, mas o valor!)
		
		
		String nipe = nipes[sorteaNumero.nextInt(nipes.length)]; //Resumido
		
		
		//Mensagem
		
		String carta = "Carta "+ face + " de " + nipe;
		System.out.println(carta);
		
	}
	
}
