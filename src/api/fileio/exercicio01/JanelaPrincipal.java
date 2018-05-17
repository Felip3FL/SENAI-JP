package api.fileio.exercicio01;

import java.awt.EventQueue;
import java.awt.FileDialog;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.UIManager;


import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import javax.swing.JDialog;

import java.awt.TextArea;
import java.awt.BorderLayout;

public class JanelaPrincipal implements ActionListener {

	private JFrame frame;
	private JMenuBar menuBar;
	private JMenu mnArquivo;
	private JMenu mnInformaes;
	private JMenuItem mntmNovo;
	private JMenuItem mntmSalvar;
	private JMenuItem mntmAbrir;
	private JMenuItem mntmFechar;
	private JSeparator separator;
	private JMenuItem mntmSair;
	private JMenuItem mntmSobre;
	private TextArea txtaTexto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
		            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					JanelaPrincipal window = new JanelaPrincipal();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JanelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		mntmNovo = new JMenuItem("Novo");
		mntmNovo.addActionListener(this);
		mnArquivo.add(mntmNovo);
		
		mntmSalvar = new JMenuItem("Salvar");
		mntmSalvar.addActionListener(this);
		mnArquivo.add(mntmSalvar);
		
		mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.addActionListener(this);
		mnArquivo.add(mntmAbrir);
		
		mntmFechar = new JMenuItem("Fechar");
		mntmFechar.addActionListener(this);
		mnArquivo.add(mntmFechar);
		
		separator = new JSeparator();
		mnArquivo.add(separator);
		
		mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(this);
		mnArquivo.add(mntmSair);
		
		mnInformaes = new JMenu("Informações");
		menuBar.add(mnInformaes);
		
		mntmSobre = new JMenuItem("Sobre");
		mntmSobre.addActionListener(this);
		mnInformaes.add(mntmSobre);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		txtaTexto = new TextArea();
		frame.getContentPane().add(txtaTexto, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent ev) {
		
		Object menu = ev.getSource();
		
		if(menu.equals(mntmAbrir)){
			
			abrir();
			
			
		}else if(menu.equals(mntmNovo)){
			
		}else if(menu.equals(mntmSalvar)){
			
			salvar();
			
		}else if(menu.equals(mntmSair)){
			System.exit(0);
		}
		
		
	}
	
	public void abrir(){
		
		FileDialog dialogoAbrir = new FileDialog((JDialog)null, "Selecione o arquivo para abrir");
		
		dialogoAbrir.setFile("*.txt");
		dialogoAbrir.setMode(FileDialog.LOAD);
		dialogoAbrir.setVisible(true);
		
		String nomeArquivo = dialogoAbrir.getDirectory() + dialogoAbrir.getFile();
		
		try {
			FileInputStream fi = new FileInputStream(nomeArquivo);
			InputStreamReader fw = new InputStreamReader(fi,"Cp1252");
			BufferedReader in  = new BufferedReader(fw);
			
			txtaTexto.setText(null);
			
			String linha = in.readLine();
			
			while(linha != null){
				txtaTexto.setText(txtaTexto.getText() + "\n" + linha);
				linha = in.readLine();
			}
			
		} catch (IOException ex) {
			System.out.print("Falha na leitura do arquivo");
		}
		
	}
	
	public void salvar(){
		
		FileDialog dialogoAbrir = new FileDialog((JDialog)null, "Selecione o arquivo para salvar");
		
		dialogoAbrir.setFile("*.txt");
		dialogoAbrir.setMode(FileDialog.SAVE);
		dialogoAbrir.setVisible(true);
		
		String nomeArquivo = dialogoAbrir.getDirectory() + dialogoAbrir.getFile();
		
		try {
			
			PrintWriter fw = new PrintWriter(nomeArquivo);
			JOptionPane.showMessageDialog(null, txtaTexto.getText());
			fw.println(txtaTexto.getText());
			
			
		} catch (IOException ex) {
			System.out.print("Falha na gravação do arquivo");
		}
		
	}

	
}

