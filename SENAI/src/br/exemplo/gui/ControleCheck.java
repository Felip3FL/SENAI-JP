package br.exemplo.gui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ControleCheck extends JFrame{

	private static final long serialVersionUID = 1L;

	//Atributo de classe
	JTextField texto;
	
	//Foi necessario deixa como atributo de classe pois vou usar em outra classe
	JCheckBox bold, italic;
	
	
	public ControleCheck() {
		super();

			
		//Definindo texto
		texto = new JTextField("Veja a Fonte Mudar", 12);
		texto.setFont(new Font("Serif", Font.PLAIN, 26)); //Alterar estilo de fonte
		
		
		//Check List
		//JCheckBox bold = new JCheckBox("Bold");
		bold = new JCheckBox("Bold");
		bold.addItemListener(new MinhaCheckBoxListener());
		
		//JCheckBox italic = new JCheckBox("Italic");
		italic = new JCheckBox("Italic");
		italic.addItemListener(new MinhaCheckBoxListener()); 
		
		//Novo layout
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(texto);
		c.add(bold);
		c.add(italic);
		
		
		//Default
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);
		setVisible(true);

	}
	
	class MinhaCheckBoxListener implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent e) {

			//Click no CkechBox
			System.out.println("Click no CkeckBox");
			if(bold.isSelected() && italic.isSelected()){
				texto.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 26));
			}else if(bold.isSelected()){
				texto.setFont(new Font("Serif", Font.BOLD, 26));
			}else if(italic.isSelected()){
				texto.setFont(new Font("Serif",Font.ITALIC, 26));
			}else{
				texto.setFont(new Font("Serif",Font.PLAIN, 26));
			}
			
		}		
	}
	
	public static void main(String[] args) {
		new ControleCheck();
	}

}