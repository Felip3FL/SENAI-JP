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

public class TelaPorCodigo {

	public static void main(String[] args) {
		
		JFrame tela = new JFrame();
		
		tela.setLayout(new GridLayout(3,1));
		
		JPanel pnCampos = new JPanel();
		
		//Criando uma label e um Text
		JLabel lblNome = new JLabel("Nome");
		pnCampos.add(lblNome);
		JTextField txtNome = new JTextField(20);
		pnCampos.add(txtNome);
		tela.add(pnCampos);
		
		//Criando mais um label e um texto
		JPanel pnCampos2 = new JPanel();
		pnCampos2.add(new JLabel("E-mail"));
		pnCampos2.add(new JTextField(20));
		tela.add(pnCampos2);
		
		//Criando um painel e 2 botoes
		JPanel pnCampos3 = new JPanel();
		JButton cmdSair = new JButton("Sair");
		JButton cmdOK = new JButton("OK");
		pnCampos3.add(cmdOK);
		pnCampos3.add(cmdSair);
		tela.add(pnCampos3);
		
		//Definido um objeto como DEFAULT
		cmdOK.getRootPane().setDefaultButton(cmdOK);
		
		tela.setVisible(true);
		
		cmdOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, txtNome.getText() + " foi gravado com sucesso!");
				
			}
		});
		
	}
	
}
