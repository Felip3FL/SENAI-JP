package br.exemplo.gui;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Layout1 extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	public Layout1 (){
		super("Titulo da minha janela");
		
		Container c = getContentPane();		//Container
		c.setLayout(new FlowLayout());
		c.add(new JButton("Botao 1"));
		c.add(new JButton("Botao 2"));
		
		
		//Quando aperta o X, o que o programa deve fazer
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300); //Tamanho da Janela
		setVisible(true); //Janela visivel?
		
		
	}
	 
	public static void main(String[] args) {

		new Layout1();

	}

}
