package br.exemplo.varArgsArgumentosVariaveis;

public class ArgumentosVariaveis {

	///////// METODO 1 //////////
	
	//Para receber numeros indefinidos de argumentos 
	//numerosArray recebe as series de numeros, é praticamente uma array
	double soma(double ... numerosArray){
		double total = 0;
		
		//Ultilizando o FOREACH
		for(double n : numerosArray){
			total += n;
		}
		return total;
	}
	
	
	
	///////// METODO 2 //////////
	
	//Esse metodo é a mesma coisa que o metodo acima
	//Para abribuir valores para esse metodo é diferente
	double subtracao(double[] numerosArray){
		double total = 0;
		
		//Ultilizando o FOREACH
		for(double n : numerosArray){
			total -= n;
		}
		return total;
	}
	
	
	
	///////// METODO 3 //////////	
	
	//Agora alem dos numeros, tambem recebe um valor diferente
	double soma2(String titulo, double ... numerosArray){
		double total = 0;
		System.out.println(titulo);
		
		//Ultilizando o FOREACH
		for(double n : numerosArray){
			total += n;
		}
		return total;
	}
	
}
