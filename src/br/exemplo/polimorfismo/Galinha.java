package br.exemplo.polimorfismo;

//final impede que essa classe (galinha) seja extendida
public final class Galinha extends Animal{

	public Galinha() {
		//Sempre que for referencia a SUPER classe AMINAL, usa o SUPER
		super(2,"Milho");
	}
	
	void fazerBarulho(){
		System.out.println("Có có!");
	}
	
}
