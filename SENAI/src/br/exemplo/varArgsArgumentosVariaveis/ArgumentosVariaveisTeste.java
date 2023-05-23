package br.exemplo.varArgsArgumentosVariaveis;

public class ArgumentosVariaveisTeste {

	public static void main(String[] args) {
		
		//Criando o objeto teste, da classe ArgumentosVariaveis
		ArgumentosVariaveis teste = new ArgumentosVariaveis();
		
		
		///////// METODO 1 //////////
		
		//o metodo soma recebe uma serie de valores
		double total = teste.soma(1,1,1,1,1);
		
		System.out.println("Total = " + total);
		
		
		
		///////// METODO 2 //////////
		
		//o metodo subbtracao recebe uma serie de valores
		double[] arrayNumeros = {2,1}; 
		total = teste.subtracao(arrayNumeros);
		
		System.out.println("\nTotal = " + total);
	
		
		
		///////// METODO 3 //////////
		
		//o metodo soma recebe uma serie de valores
		total = teste.soma2("\nMetodo Soma 2", 1,1,1,1,1);
		
		System.out.println("Total = " + total);
		
	}

}
