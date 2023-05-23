package br.exemplo.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Layout2 extends JFrame{

	private static final long serialVersionUID = 1L;

	public Layout2() {

		super("Layout 2");
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout(10,10));
		
		Container c2 = new JPanel();
		c2.setLayout(new GridLayout(4,1));
		
		c2.add(new JButton("Ok"));
		c2.add(new JButton("Cancel"));
		c2.add(new JButton("Setup"));
		c2.add(new JButton("Help"));
		
		c.add(BorderLayout.CENTER, new JButton("Centro"));
		c.add(BorderLayout.EAST, c2);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		setVisible(true);
		
		/* BORDER LAYOUT
		 * 
		BorderLayout(20,20) é o intervalo entre os elementos
		c.setLayout(new BorderLayout(20,20));
		
		c.add(BorderLayout.NORTH, new JButton("N"));
		c.add(BorderLayout.SOUTH, new JButton("S"));
		c.add(BorderLayout.CENTER, new JButton("C"));
		c.add(BorderLayout.EAST, new JButton("E"));
		c.add(BorderLayout.WEST, new JButton("W"));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		setVisible(true);
		*/
		
		/* GRID LAYOUT 
		 * 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		setVisible(true);
		
		c.setLayout(new GridLayout(2,3));
		c.add(new JButton("1"));
		c.add(new JButton("2"));
		c.add(new JButton("3"));
		c.add(new JButton("4"));
		c.add(new JButton("5"));
		c.add(new JButton("6"));
		*/
		
		
	}

	public static void main(String[] args) {

		new Layout2();

	}

}
