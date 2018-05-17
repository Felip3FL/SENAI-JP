package br.exemplo.exemplos;

import javax.swing.JOptionPane;



public class IMC {

	public static void main(String[]args){
		
		//Coletando as informa��o do usuario
		
		//JOptionPane � um tipo de janela
		//showInputDialog � uma janela interrogando o usuario
		String peso = JOptionPane.showInputDialog("Qual � o seu peso? ");
		String altura = JOptionPane.showInputDialog("Qual � sua altura em metros? ");
		
		
		
		//Calculo do IMC
		
		//Double.parseDouble(peso) = esta covertendo peso (que � string) para double 
		double pesoEmQuilogramas = Double.parseDouble(peso);
		double alturaEmMetros = Double.parseDouble(altura);
		double imc = pesoEmQuilogramas / (alturaEmMetros * alturaEmMetros);
		
		
		
		//Operador ternario
		
		String msg = 
		(imc >= 20 && imc <= 25) ? "Peso ideal" : "Fora do Peso ideal" ; 
		
		
		
		//Apresentando resultados com interface grafica
		
		msg = "IMC = " + imc + "\n" + msg;
		
		JOptionPane.showMessageDialog(null, msg);
		
	}
	
}
