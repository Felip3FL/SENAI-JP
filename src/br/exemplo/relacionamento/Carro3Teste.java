package br.exemplo.relacionamento;

public class Carro3Teste {

	public static void main(String[] args) {

		//Criado objeto Ferrari, e ja é atribuidos os valores
		//Modelo, velocidade maxima, segundos de 0 a 100, (Motor: potencia, tipo) 
		Carro3 ferrari = new Carro3("Ferrari F12", 320, 4.5, new Motor3("W16",1200));
		
		System.out.println(ferrari.modelo);
		System.out.println("Motor: "+ferrari.motor.potencia);
		System.out.println("Motor: "+ferrari.motor.tipo);		
		
	}

}
