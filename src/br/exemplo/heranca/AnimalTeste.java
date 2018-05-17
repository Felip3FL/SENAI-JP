package br.exemplo.heranca;

public class AnimalTeste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Cachorro toto = new Cachorro();
		toto.comida = "Carne";
		toto.dormir();
		
		Galinha carijo = new Galinha();
		carijo.dormir();
		
		//INSTANCEOF avalia se determinado objeto é de um tipo especifico 
		System.out.println("Toto é um Cachorro? "+(toto instanceof Cachorro));
		System.out.println("Toto é um animal? "+(toto instanceof Animal));
		System.out.println("Carijo é um animal? "+(carijo instanceof Animal));
		
	}

}
