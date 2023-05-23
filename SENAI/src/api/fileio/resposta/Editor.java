package api.fileio.resposta;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;

@SuppressWarnings("serial")
public class Editor extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnArquivo;
	private JMenuItem mntmNovo;
	private JMenuItem mntmAbrir;
	private JMenuItem mntmFechar;
	private JSeparator separator;
	private JMenuItem mntmSair;
	private JMenu mnInformaes;
	private JMenuItem mntmVerso;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JMenuItem mntmSalvar;
	private File nomeArquivo;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Editor frame = new Editor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Editor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		mntmNovo = new JMenuItem("Novo");
		mntmNovo.addActionListener(this);
		mnArquivo.add(mntmNovo);
		
		mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.addActionListener(this);
		
		mntmSalvar = new JMenuItem("Salvar");
		mntmSalvar.setEnabled(false);
		mntmSalvar.addActionListener(this);
		mnArquivo.add(mntmSalvar);
		mnArquivo.add(mntmAbrir);
		
		mntmFechar = new JMenuItem("Fechar");
		mntmFechar.setEnabled(false);
		mntmFechar.addActionListener(this);
		mnArquivo.add(mntmFechar);
		
		separator = new JSeparator();
		mnArquivo.add(separator);
		
		mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(this);
		mnArquivo.add(mntmSair);
		
		mnInformaes = new JMenu("Informa\u00E7\u00F5es");
		menuBar.add(mnInformaes);
		
		mntmVerso = new JMenuItem("Vers\u00E3o");
		mntmVerso.addActionListener(this);
		mnInformaes.add(mntmVerso);
		contentPane = new JPanel();
		
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
	}

	public void actionPerformed(ActionEvent ev) {
		String cmd = ev.getActionCommand();
		
		if(cmd.equals("Novo")) {
			textArea.setText("");
			setMenuEdit(true);
		} else if(cmd.equals("Abrir")) {
			FileDialog fd = new FileDialog(this, "Selecione um arquivo", FileDialog.LOAD);
			fd.setLocationRelativeTo(this);
			fd.setFile("*.txt");
			fd.setVisible(true);
			
			String nome = fd.getFile();
			
			setNomeArquivo(new File(fd.getDirectory() + nome));

			if(nome != null) {
				try (BufferedReader in = new BufferedReader(new FileReader(getNomeArquivo()));) {
					textArea.setText("");
					
					for(String linha; (linha = in.readLine()) != null;)
						textArea.append(linha + "\n");
					
					textArea.setCaretPosition(0);
					textArea.getCaret().setVisible(true); // força o aparecimento do cursor
					setMenuEdit(true);
				} catch(IOException e) {
					JOptionPane.showMessageDialog(this, "Erro na leitura do arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		} else if(cmd.equals("Salvar")) {
			FileDialog fd = new FileDialog(this, "Selecione o nome do arquivo", FileDialog.SAVE);
			
			if(getNomeArquivo() != null) {
				fd.setDirectory(getNomeArquivo().getParent());
				fd.setFile(getNomeArquivo().getName());
			}
			
			fd.setLocationRelativeTo(this);
			fd.setVisible(true);
			
			String nome = fd.getFile();
			
			if(nome != null) {
				try (PrintWriter out = new PrintWriter(fd.getDirectory() + nome);) {

					int inicio = 0;
					int fim = -1;
					for (int i = 0; i < textArea.getLineCount(); i++) {
						fim = textArea.getLineEndOffset(i);
						String linha = "";
						if(fim > inicio) {
							String texto = textArea.getText().substring(inicio, fim);
							if(texto.contains("\n"))
								linha = texto.substring(0, texto.length()-1);
							else
								linha = texto;
						}
						out.println(linha);
						inicio = fim;
					}

					textArea.setText("");
					textArea.getCaret().setVisible(false); // força oclutamento do cursor
				    setMenuEdit(false);
					setNomeArquivo(null);
				} catch(BadLocationException e) {
					JOptionPane.showMessageDialog(this, "Erro no processamento do texto\nContate oSSoPorte", "Erro", JOptionPane.ERROR_MESSAGE);
				} catch(IOException e) {
					JOptionPane.showMessageDialog(this, "Erro na leitura do arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		} else if(cmd.equals("Fechar")) {
			int resp = JOptionPane.showConfirmDialog(this, 
					"Confirma fechar o arquivo\nas alterações serão descartadas!",
					"Atenção", JOptionPane.YES_NO_OPTION, 
					JOptionPane.QUESTION_MESSAGE);
			
			if(resp == 0) {
				textArea.setText("");
				setMenuEdit(false);
				setNomeArquivo(null);
			}
		} else if(cmd.equals("Versão")) {
			JOptionPane
					.showMessageDialog(this, "Editor 1/2 Boca\nVersão 0.1", 
							"Informações", JOptionPane.INFORMATION_MESSAGE);
		} else {
			System.exit(0);
		}
	}
	
	public File getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(File nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public void setMenuEdit(boolean val) {
		mntmNovo.setEnabled(!val);
		mntmAbrir.setEnabled(!val);
		mntmSalvar.setEnabled(val);
		mntmFechar.setEnabled(val);
		mntmSair.setEnabled(!val);
		textArea.setEditable(val);
	}

}
