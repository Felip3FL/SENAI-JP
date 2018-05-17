package br.exemplo.polimorfismo;

public class AnimalTeste {

	
	public static void barulho(Animal animal){
		animal.fazerBarulho();
	}
	
	
	public static void main(String[] args) {
		
		Animal toto = new Cachorro();
		toto.fazerBarulho();
		barulho(toto);
		
		Animal carijo = new Galinha();
		carijo.fazerBarulho();
		barulho(carijo);
		
		Animal desconhecido = new Animal();
		desconhecido.fazerBarulho();
		
		
	}

}
