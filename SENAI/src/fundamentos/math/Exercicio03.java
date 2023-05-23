package fundamentos.math;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Exercicio03 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblLado;
	private JLabel lblResultado;
	private JButton btnCalcular;
	private JButton btnSair;
	private JTextField tfResultado;
	private JTextField tfLado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exercicio03 frame = new Exercicio03();
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
	public Exercicio03() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 239, 148);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblLado = new JLabel("Lado");
		
		lblResultado = new JLabel("Resultado");
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(this);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		
		tfResultado = new JTextField();
		tfResultado.setColumns(10);
		
		tfLado = new JTextField();
		tfLado.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnCalcular)
							.addPreferredGap(ComponentPlacement.RELATED, 244, Short.MAX_VALUE)
							.addComponent(btnSair))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblResultado)
								.addComponent(lblLado))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(tfResultado, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
								.addComponent(tfLado, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLado)
						.addComponent(tfLado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblResultado)
						.addComponent(tfResultado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCalcular)
						.addComponent(btnSair))
					.addContainerGap(168, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	public void actionPerformed(ActionEvent ev) {
		Object botao = ev.getSource();
		
		if(botao.equals(btnCalcular)){
			Exercicio03_caixaDAgua caixaDAgua = new Exercicio03_caixaDAgua();
			
			caixaDAgua.setLado(Integer.parseInt(tfLado.getText()));
			
			tfResultado.setText(String.format("%,.2f", caixaDAgua.suporteCaixaDAgua()));
			
		}else if (botao.equals(btnSair)){
			System.exit(0);
		}
		
	}
}
