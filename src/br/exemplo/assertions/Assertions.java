package br.exemplo.assertions;

import java.util.Scanner;

public class Assertions {

	private static Scanner entradaTeclado;

	public static void main(String[] args) {

		entradaTeclado = new Scanner(System.in);
		
		System.out.println("Entre um numero de 0 a 10");
		int numero = entradaTeclado.nextInt();

		 
		assert (numero >= 0 && numero <= 10) : "Numero invalido!";
		System.out.println("Voce entro "+numero);
		
		//java -ea br.exemplo.assertion
		//Eclipse - RUN > RUN CONFIGURATIONS > ARGUMENTS > VM ARGUMENTS > -EA
		
	}

}
