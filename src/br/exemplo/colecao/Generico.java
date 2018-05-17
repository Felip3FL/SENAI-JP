package br.exemplo.colecao;

import java.util.ArrayList;

public class Generico <E> {

	//<E> representa um elemento generico
	
	E elemento; //OBJECT é o tipo mais generico de elemento de dados

	public void setElemento(E elemento) {
		this.elemento = elemento;
	}

	public E getElemento() {
		return elemento;
	}

	
	//Caracteres coringa
	public double soma(ArrayList<? extends Number> list){
	double total = 0;
		for (Number numeros : list){
			total+= numeros.doubleValue();
		}
		return total; 
	}
	
	
	public static void main(String[] args) {

		//Generico<String> - Deve informa o tipo de dados que vai manipular
		Generico<String> g = new Generico<>();
		g.setElemento("Lago Paranoá");
		//g.setElemento(123456);
 
		g.getElemento().toUpperCase();

	}
}
