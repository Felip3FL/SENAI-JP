package api.fileio.exemplos;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class TelaComMenu extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnArquivo;
	private JMenu mnAjuda;
	private JMenuItem mntmNovo;
	private JMenuItem mntmAbrir;
	private JMenuItem mntmFechar;
	private JSeparator separator;
	private JMenuItem mntmSair;
	private JMenuItem mntmContedo;
	private JMenuItem mntmVerso;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaComMenu frame = new TelaComMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaComMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 438, 297);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		mntmNovo = new JMenuItem("Novo");
		mntmNovo.setMnemonic('N');
		mnArquivo.add(mntmNovo);
		
		mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_MASK));
		mnArquivo.add(mntmAbrir);
		
		mntmFechar = new JMenuItem("Fechar");
		mnArquivo.add(mntmFechar);
		
		separator = new JSeparator();
		mnArquivo.add(separator);
		
		mntmSair = new JMenuItem("Sair");
		mntmSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
		mnArquivo.add(mntmSair);
		
		mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		mntmContedo = new JMenuItem("Conteúdo");
		mntmContedo.addActionListener(this);
		mnAjuda.add(mntmContedo);
		
		mntmVerso = new JMenuItem("Versão");
		mntmVerso.addActionListener(this);
		mnAjuda.add(mntmVerso);
		

		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		contentPane.setLayout(gl_contentPane);
	}

	public void actionPerformed(ActionEvent ev) {
		Object menu = ev.getSource();
		
		if(menu.equals(mntmAbrir)) {
			
		} else if(menu.equals(mntmNovo)) {
			
		} else if(menu.equals(mntmVerso)) {
			
		} else {
			System.exit(0);
		}
	}
}
