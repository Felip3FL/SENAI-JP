package br.exemplo.refinado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author Felipe Lima
 * 
 * Aula 98 Classes Aninhadas e Anônimas
 * 
 */
 
public class Aninhamento extends JFrame{

	private static final long serialVersionUID = 1L;

	
	JButton botao;
	public Aninhamento() {
		super("Aninhamento");
		
		botao = new JButton("OK");
		botao.addActionListener(new ListenerAninhado());
		botao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {				
				//Classe anonima
				System.out.println("Classe anonima executa "+botao.getText());
			}
		});
		
		getContentPane().add(botao);
		
		//Default
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);
		setVisible(true);
	}

	public class ListenerAninhado implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			System.out.println("Classe aninhada executa "+botao.getText());
			
		}
		
	}
	
	public static void main(String[] args){
		
		new Aninhamento();
		
		//Declaracao classe envolvente
		//Aninhamento.ListenerAninhado listener = janela.new ListenerAninhado();
		
	}
	
}
