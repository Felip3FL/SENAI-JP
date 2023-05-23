package br.exemplo.heranca;

public class Animal {

	protected int serial; //PROTECTED aparecera apenas para a sub-classe
	
	double peso;
	String comida;
	
	public Animal(){
		this(0,null); //Chma o outro contrutor
	};
	
	public Animal(double peso, String comida){
		this.peso = peso;
		this.comida = comida;
	};
	
	void dormir(){System.out.println("Dormiu");}
	void fazerBarulho(){System.out.println("Fazer Barulho");}
	 
}
