package br.exemplo.exemplos;

public class Operadores {

	public static void main (String[] args){
		
		///////// OPERADPRES MATEMATICOS
		
		int x = 6;
		int y = x++; //pré-incremento
		int z = ++x; //pós-incremento
		
		System.out.println("x = "+x);
		System.out.println("y = "+y);
		System.out.println("z = "+z);
		
		
		
		///////// OPERADORES DE COMPARAÇÃO
		
		Integer x1 = 6;
		
		System.out.println(x1 instanceof Integer);
		
		
		
		////////// OPERADORES DE ATRIBUIÇÃO
		
		int x2 = 6;
		
		x2 += 3; //Mesma coisa que fazer x = x + 3
		x2 -= 3; //Mesma coisa que fazer x = x - 3
		x2 *= 3; //Mesma coisa que fazer x = x * 3
		x2 /= 3; //Mesma coisa que fazer x = x / 3
		x2 %= 3; //Mesma coisa que fazer x = x % 3
		
		System.out.println("X2 = "+x2);		
		
		
		
		//////////// OPERADORES ESPECIAIS
		
		int idade = 6;
		
		String resultado; //Vai receber a mensagem abaixo
		resultado = idade >= 18 ? "Maior de Idade":"Menor de Idade";
		
		System.out.println("Resultado: "+resultado);
		
		
		//Diametro : 2r
		double raio = 10;
		double diametro = 2 * raio;
		
		System.out.println("Diametro: "+diametro);
		
		
		//Circunferencia : 2 PI r
		double pi = Math.PI;
		double circunferencia = 2 * pi * raio;
		
		System.out.println("Circunferencia: "+circunferencia);
		
		//Área PI r2
		double area = pi * (raio * raio);
		System.out.println("Área: "+area);
		
		 
		
	}  
	
}
