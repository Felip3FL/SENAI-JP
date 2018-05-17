package br.exemplo.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ControleLabel1 extends JFrame {

	private static final long serialVersionUID = 1L;

	public ControleLabel1(){
		super("Label");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(700,700);
		
		JLabel simples = new JLabel("Label Simples");
		simples.setToolTipText("Meu Tooltip");//ToolTip é quando o mouse fica por cima do label
		
		
		Font fonte = new Font("arial", Font.BOLD | Font.ITALIC, 28);
		JLabel label = new JLabel("Label Simples");
		label.setFont(fonte);
		label.setForeground(Color.BLUE);
		
		
		////////// IMAGENS EM LABEL //////////

		//getClass().getResource informa que a imagem esta na mesma pasta que o projeto 
		ImageIcon icon = new ImageIcon(getClass().getResource("fotos/droid.png"));
		JLabel imagem = new JLabel(icon);
		
		
		////////// IMAGENS EM LABEL //////////
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(simples);
		c.add(label);
		c.add(imagem);//Imagem
		
	}
	
	public static void main(String[] args) {

		new ControleLabel1();

	}

}
