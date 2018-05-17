package br.exemplo.relacionamento;

public class Carro3 {

	String modelo;
	int velocidadeMaxima;
	double segundosZeroACem;
	Motor3 motor;
	
/**Caso o usuario n�o passa um tipo de motor, entra nesse contrutor
 * 
	public Carro3(String modelo, int velocidadeMaxima, double segundosZeroACem){
		this(modelo, velocidadeMaxima, segundosZeroACem, null);
	}
*/
	
	//Construtor da classe carro3 que � iniciado toda vez que um objeto � criado (instanciando a classe)
	//Motor3 � um relacionamento, toda vem que cria um carro, o usuario ja cria tambem o motor a esse carro
	public Carro3(String modelo, int velocidadeMaxima, double segundosZeroACem, Motor3 motor){
		this.modelo = modelo;
		this.velocidadeMaxima = velocidadeMaxima;
		this.segundosZeroACem = segundosZeroACem;
		this.motor = motor; //Os atributos est�o na classe Motor3
	}
	
	
}
