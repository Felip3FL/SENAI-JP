package br.exemplo.contrutores;

public class Carro {

	String modelo;
	int velocidadeMaxima;
	double segundosZeroACem;
	
	//Construtor da classe carro que � iniciado toda vez que um objeto � criado (instaciado a classe)
	public Carro(String modelo, int velocidadeMaxima, double segundosZeroACem){
		this.modelo = modelo;
		this.velocidadeMaxima = velocidadeMaxima;
		this.segundosZeroACem = segundosZeroACem;
	}

}
