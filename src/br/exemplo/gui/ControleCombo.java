package br.exemplo.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ControleCombo extends JFrame implements ItemListener{

	private static final long serialVersionUID = 1L;
	
	//Combo box vai receber objeto do tipo String
	JComboBox<String> combo;
	JLabel label;
	
	//Array de imagens
	ImageIcon[] imagens = {
			new ImageIcon(getClass().getResource("fotos/01.jpg")),
			new ImageIcon(getClass().getResource("fotos/02.jpg")),
			new ImageIcon(getClass().getResource("fotos/03.jpg")),
			new ImageIcon(getClass().getResource("fotos/04.jpg")),
	};
	
	public ControleCombo() {
		super("Album de fotos");
		
		Container c = getContentPane();
		
		combo = new JComboBox<String>();
		combo.setFont(new Font("Arial", Font.PLAIN, 26));
		combo.addItem("Social");
		combo.addItem("Profissional");
		combo.addItem("Pirata");
		combo.addItem("Social");
		combo.addItemListener(this);
		
		label = new JLabel(imagens[0]);
		c.add(BorderLayout.NORTH, combo);
		c.add(BorderLayout.CENTER, label);
		
		
		setSize(300,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ControleCombo();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		//EXECUTAR AS ACOES QUANDO O COMBO FOR MODIFICADO
		
		//Verificando qual combo esta selecionado
		if(e.getStateChange() == ItemEvent.SELECTED){
			
			//getSelectedIndex - Coloca a imagem corespondente a orden do combo 
			label.setIcon(imagens[combo.getSelectedIndex()]);
		}
		
	}
}
