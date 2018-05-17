package br.exemplo.relacionamento;

public class Carro2Teste {

	public static void main(String[] args) {

		//Criado objeto Ferrari, e ja é atribuidos os valores
		Carro2 ferrari = new Carro2("Ferrari F12", 320, 4.5);
		System.out.println(ferrari.modelo);

		
		//Criando um motor e ja atribuindo suas caracteristicas
		Motor2 v12 = new Motor2("V12",660);
		
		//Dizendo que o motor v12 pertence a objeto ferrari
		ferrari.motor = v12;
		
		System.out.println("Motor: "+ferrari.motor.potencia);
		
		
	}

}
