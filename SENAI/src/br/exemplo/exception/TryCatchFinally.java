package br.exemplo.exception;

import java.util.InputMismatchException; //É importada para tratamento do erro de entrada de caracteres
import java.util.Scanner; //Para entrada do teclado

public class TryCatchFinally {

	private static Scanner entradaTeclado;

	public static void main(String[] args) {

		entradaTeclado = new Scanner(System.in);
		boolean continua = true;

		//Só saira desse DO quanto for igual a FALSE, ou seja, se todos os dados estiver corretos
		do {

			try {

				System.out.print("Numero:  ");
				int valor1 = entradaTeclado.nextInt();

				System.out.print("Divisor: ");
				int valor2 = entradaTeclado.nextInt();

				System.out.println("Resultado: " + valor1 / valor2);
				continua = false;

			//CATCH trapa cada erro previsto pelo programador
			//InputMismatchException é um erro de entrada de dados erradas
			} catch (InputMismatchException erro1) {
				//System.err.println apresenta uma mensagem vermelha de erro!
				System.err.println("Números devem ser inteiros! (InputMismats)");
				entradaTeclado.nextLine();//descarta a entrada errada e libera novamente para o usuario
			}
			
			//ArithmeticException é um erro de calculo
			 catch (ArithmeticException erro2) {
				//System.err.println apresenta uma mensagem vermelha de erro!
				System.err.println("Dividor diferente de 0 (ArithmeticException)");
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
