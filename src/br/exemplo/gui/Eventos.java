package br.exemplo.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Eventos extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	JButton botao = new JButton("Clique Aqui");

	public Eventos() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(300, 300);

		//JButton botao = new JButton("Clique Aqui");

		//Esse metodo espera o objeto que implemente a inferface ActionListener
		botao.addActionListener(this);

		getContentPane().add(botao);
		

	}

	public static void main(String[] args) {

		new Eventos();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println("Clicou");
		botao.setText("OK");
	}

}
