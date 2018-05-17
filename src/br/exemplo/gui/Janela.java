package br.exemplo.gui;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Janela extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public Janela(){
		
		//JFrame é a Janela
		super("Nome da minha Janela!");
		
		//Criando o botao para coloca-lo no container
		JButton botao = new JButton("Botão 1");
		
		//Controles são colocados detro de container
		getContentPane().add(botao);
		
		
		setSize(300,300);//Tamanho da janel
		setVisible(true); //Janela visivel ou não
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Ao aperta X, oque fazer
		


		
	}
	
	public static void main(String[] args) {
		//Chamando o contrutor Janela
		new Janela();

	}

}
