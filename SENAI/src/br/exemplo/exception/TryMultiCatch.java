package br.exemplo.exception;

import java.util.InputMismatchException; //É importada para tratamento do erro de entrada de caracteres
import java.util.Scanner; //Para entrada do teclado

public class TryMultiCatch {
	
	public static void dividir(Scanner s) throws InputMismatchException, ArithmeticException{
		
		System.out.print("Numero:  ");
		int valor1 = entradaTeclado.nextInt();

		System.out.print("Divisor: ");
		int valor2 = entradaTeclado.nextInt();

		System.out.println("Resultado: " + valor1 / valor2);
		
	}
	
	private static Scanner entradaTeclado;

	public static void main(String[] args) {

		entradaTeclado = new Scanner(System.in);
		boolean continua = true;

		//Só saira desse DO quanto for igual a FALSE, ou seja, se todos os dados estiver corretos
		do {

			try {

				dividir(entradaTeclado);
				continua = false;

			//MultiCATCH agora trata 2 ou mais erros na mesma linha
			} catch (InputMismatchException | ArithmeticException erro1Unico) {
				
				//System.err.println apresenta uma mensagem vermelha de erro!
				System.err.println("Números devem ser inteiros! "+erro1Unico.getMessage());
				
				//erro1Unico.printStackTrace(); //printStackTrace() imprime a pilha de erros
				entradaTeclado.nextLine();//descarta a entrada errada e libera novamente para o usuario
			}
			finally{
				//Executa indepedente de aver erro ou não, com ou sem o CATCH
				//Serve para limpar variavel, fechar conexoes, fechar String de dados
				System.out.println("Finally Executado");
			}

		} while (continua);

		/**
		 * Os algoritmo acima pode apresenta 2 tipos de erros
		 * ArithmeticException (por causa da divisão errada)
		 * InputMismatchException (por causa dos caracteres em campos INT)
		 */

	}
}
