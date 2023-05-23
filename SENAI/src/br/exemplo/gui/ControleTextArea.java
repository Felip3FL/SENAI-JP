package br.exemplo.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ControleTextArea extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	JTextArea texto;
	
	public ControleTextArea() {
		super("Editor de Textos");
		
		texto = new JTextArea();
		JScrollPane scroll = new JScrollPane(texto);//Exibir barra de rolagem
		texto.setFont(new Font("Arial", Font.PLAIN, 26));
		
		JButton botao = new JButton("Abrir Arquivo");
		botao.setFont(new Font("Arial", Font.PLAIN, 26));
		botao.addActionListener(this);
		
		Container c = getContentPane();
		//c.add(texto);
		c.add(BorderLayout.CENTER, scroll);
		c.add(BorderLayout.SOUTH, botao);
		
		
		//DEFAULT
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {

		new ControleTextArea(); 

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Metodo que vai recupera arquivo no computador e apresenta no editor de texto
		
		JFileChooser c = new JFileChooser();
		
		//showOpenDialo - Dialogo para abrir um arquivo
		//THIS indica que é para abrir essa janela
		c.showOpenDialog(this);
		File file = c.getSelectedFile();//Esse metodo recebe o arquivo selecionado
		try{
			Path path = Paths.get(file.getAbsolutePath());
			String retorno = new String(Files.readAllBytes(path));
			texto.setText(retorno);
		}catch(Exception erro){
			JOptionPane.showMessageDialog(this,  "Não conseguimos carregar arquivps");
		}
		
	}

}
