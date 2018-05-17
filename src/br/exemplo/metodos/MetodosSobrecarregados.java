package br.exemplo.metodos;

public class MetodosSobrecarregados {
	
	//S�o permitidos metodos com nomes iguais, mas � necessario ter assinaturas diferentes
	
	//Aqui s� cairam argumentos que passem 1
	double media(int x){
		System.out.print("Media(int x) ");
		return x;
	}

	
	//Aqui s� cairam argumentos que passem 2
	double media(int x, int y){
		System.out.print("Media(int x) ");
		return x;
	}
	
	
	//Aqui s� cairam argumentos que passem 3 ou mais
	double media(int ... numeros){
		int total = 0;
		
		//Somando numeros
		for(int n : numeros){
			total += n;
		}
		
		System.out.print("media(int ... numeros) ");
		return total/numeros.length;
	}
	
	
	//Aqui s� cairam argumentos tipo String
	double media(String x, String y){
		System.out.print("media(String x, String y) ");
		
		//Converte numero String para INT
		int ix = Integer.parseInt(x);
		int iy = Integer.parseInt(y);
		
		return (ix + iy)/2;
	}

	
}
