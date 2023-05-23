package br.exemplo.polimorfismo;

//final impede que essa classe (cachorro) seja extendida
public final class Cachorro extends Animal{

	public Cachorro() {
		//Sempre que for referencia a SUPER classe AMINAL, usa o SUPER
		super(30,"Carne");
	}
	
	void fazerBarulho(){
		System.out.println("Au Au!");
	}
	
}
