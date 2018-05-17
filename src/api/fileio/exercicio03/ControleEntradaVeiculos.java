package api.fileio.exercicio03;

import java.awt.EventQueue;

import javax.swing.JFrame;

import fundamentos.lib.VerificaCellEditor;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import ProJetoCadastroColega.lib.TableVerificaRegex;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ControleEntradaVeiculos implements ActionListener {

	private JFrame frame;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JButton btnCarregar;
	private JButton btnSalvar;
	private JButton btnAbrir;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControleEntradaVeiculos window = new ControleEntradaVeiculos();
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
	public ControleEntradaVeiculos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		btnCarregar = new JButton("Carregar");
		btnCarregar.addActionListener(this);
		panel.add(btnCarregar);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(this);
		btnSalvar.setVerticalAlignment(SwingConstants.TOP);
		panel.add(btnSalvar);
		
		btnAbrir = new JButton("Abrir");
		btnAbrir.addActionListener(this);
		panel.add(btnAbrir);
		
		scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		table.getColumnModel().getColumn(0).setCellEditor(new VerificaCellEditor(new TableVerificaRegex(".{1,45}")));
		//table.getColumnModel().getColumn(1).setCellEditor(new VerificaCellEditor(new TableVerificaRegex(".{5,450}")));
		
	}

	public void actionPerformed(ActionEvent arg0) {
	}
}
