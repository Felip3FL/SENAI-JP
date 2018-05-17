package br.exemplo.relacionamento;

public class Carro2 {

	String modelo;
	int velocidadeMaxima;
	double segundosZeroACem;
	Motor2 motor;
	
	//Construtor da classe carro que é iniciado toda vez que um objeto é criado (instanciando a classe)
	public Carro2(String modelo, int velocidadeMaxima, double segundosZeroACem){
		this.modelo = modelo;
		this.velocidadeMaxima = velocidadeMaxima;
		this.segundosZeroACem = segundosZeroACem;
	}
	

}
