package br.exemplo.gui;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Layout0 extends JFrame{

	private static final long serialVersionUID = 1L;

	public Layout0 (){
		super("Titulo da minha janela");
		
		Container c = getContentPane();		//Container
		c.add(BorderLayout.NORTH, new JButton("Botao 1"));
		c.add(BorderLayout.SOUTH, new JButton("Botao 2"));
		
		
		//Quando aperta o X, o que o programa deve fazer
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300); //Tamanho da Janela
		setVisible(true); //Janela visivel?
		
		
	}
	
	public static void main(String[] args) {

		new Layout0();

	}

}
