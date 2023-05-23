package br.exemplo.gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ControleTexto extends JFrame {

	private static final long serialVersionUID = 1L;
	
	//Atributo dessa classse
	JButton ok, cancel;
	JTextField login;
	JPasswordField senha;

	public ControleTexto() {
		super("Controle Texto");

		login = new JTextField();
		senha = new JPasswordField();

		ok = new JButton("OK");
		ok.addActionListener(new BotaoOkListener());

		cancel = new JButton("Cancelar");
		cancel.addActionListener(new BotaoCancelListener());

		Container c = getContentPane();
		c.setLayout(new GridLayout(3, 2));
		c.add(new JLabel("Login: "));
		c.add(login);
		c.add(new JLabel("Senha: "));
		c.add(senha);
		c.add(ok);
		c.add(cancel);

		setVisible(true);
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {

		new ControleTexto();

	}

	//Clase que trata os eventos do botão OK
	class BotaoOkListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			System.out.println("Clicou em OK");

			String s = "login: " + login.getText() + "\nsenha: " + new String(senha.getPassword());
			JOptionPane.showMessageDialog(null, s);//Janela com informações do s

		}

	}

	//Clase que trata os eventos do botão OK
	class BotaoCancelListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			System.out.println("Clicou em Cancel");
			login.setText("");
			senha.setText("");

		}

	}

}
