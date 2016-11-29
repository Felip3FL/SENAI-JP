package fundamentos.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Tela1 {
	public static void main(String[] args) {
		JFrame tela = new JFrame();
//		tela.setPreferredSize(new Dimension(200,200));
		
//		BoxLayout layout = new BoxLayout(tela, BoxLayout.PAGE_AXIS); 
		tela.setLayout(new GridLayout(3, 1));
		
		JPanel pnCampos = new JPanel();
		pnCampos.add(new JLabel("Nome"));
		JTextField tfNome = new JTextField(20);
		pnCampos.add(tfNome);
		tela.add(pnCampos);

		JPanel pnCampos2 = new JPanel();
		pnCampos2.add(new JLabel("E-Mail"));
		JTextField tfEmail = new JTextField(20);
		pnCampos2.add(tfEmail);
		tela.add(pnCampos2);
		
		JPanel pnBotoes = new JPanel();
		JButton btOk = new JButton("Ok");
		
		tela.getRootPane().setDefaultButton(btOk);
		
		btOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nome = tfNome.getText();
				String email = tfEmail.getText();
				
				JOptionPane.showMessageDialog(null, 
						"Nome: " + nome + "\nE-Mail: " + email);
				
				tfNome.setText("");
				tfEmail.setText("");
				tfNome.requestFocus();
			}
		});

		//btOk.addActionListener(new ExecutaOK(tfNome, tfEmail));

		
		pnBotoes.add(btOk);
		
		JButton btSair = new JButton("Sair");
		btSair.addActionListener( e -> System.exit(0) );
		pnBotoes.add(btSair);
		tela.add(pnBotoes);
		
		tela.pack();
		tela.setLocationRelativeTo(null);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setVisible(true);
	}
}

//class Sair implements ActionListener {
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		System.exit(0);
//	}
//}

//class ExecutaOK implements ActionListener {
//	private JTextField tfNome;
//	private JTextField tfEmail;
//	
//	public ExecutaOK(JTextField nome, JTextField email) {
//		this.tfNome = nome;
//		this.tfEmail = email;
//	}	
//	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		String nome = tfNome.getText();
//		String email = tfEmail.getText();
//		
//		JOptionPane.showMessageDialog(null, 
//				"Nome: " + nome + "\nE-Mail: " + email);
//		
//		tfNome.setText("");
//		tfEmail.setText("");
//	}
//}