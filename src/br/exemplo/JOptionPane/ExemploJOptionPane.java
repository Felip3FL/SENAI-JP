package br.exemplo.JOptionPane;

import javax.swing.JOptionPane;  //Biblioteca que contem o JOptionPane

public class ExemploJOptionPane {

	public static void main (String[] args){
		
		String nome; //Variavel que vai receber o valor digitado pelo usuario
		
		//JOtionPane � a janela que sera exibida
		//showInputDialog � para receber dados
		nome = JOptionPane.showInputDialog("Qual o seu nome? ");
		
		
		//showMessageDialog apresenta apenas uma siples janela de dialogo
		//null = paramento
		JOptionPane.showMessageDialog(null, "Seu nome � "+nome);
		
		
	}
	
}
