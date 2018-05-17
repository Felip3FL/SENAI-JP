package br.exemplo.polimorfismo;

//Caso queira uma classe abtrata
//public abstract class Animal { //Classe abstrata

public class Animal {

	protected int serial; //PROTECTED aparecera apenas para a sub-classe
	
	double peso;
	String comida;
	
	public Animal(){
		this(0,null); //Chama o outro contrutor
	};
	
	public Animal(double peso, String comida){
		this.peso = peso;
		this.comida = comida;
	};
	
	//FINAL no metodo, impede que ele seja sobre-escrito por outras classes
	final void dormir(){System.out.println("Dormiu");}
	
	void fazerBarulho(){System.out.println("Fazer Barulho");}
	
	//Caso queira uma classe abstrata
	//abstract void fazerBarulho(); //Metodo abstrato (Metodo sem corpo)
	//Só pode existir em uma classe que não pode ser instanciada
	 
}
