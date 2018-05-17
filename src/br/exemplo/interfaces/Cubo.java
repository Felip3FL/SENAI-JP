package br.exemplo.interfaces;

public class Cubo implements VolumeCalculavel, AreaCalculavel{

	double lado;
	public Cubo(double lado){
		this.lado = lado;
	}
	
	public double calculaVolume()  {
		return 6 * lado;
	}	
	
	public double calculaArea(){
		return lado * lado * lado;
	}
	
}
