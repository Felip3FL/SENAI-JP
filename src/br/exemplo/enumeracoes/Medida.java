package br.exemplo.enumeracoes;

public enum Medida {
	
	//Essas variaveis equivale a PUBLIC STATIC FINAL NomeVariavel = xx
	MM("Milimetro"), CM("Centimetro"), M("Metro");
	
	public String titulo;
	
	//Contrutor
	Medida(String titulo){
		this.titulo = titulo;
	}

	
}
