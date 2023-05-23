package br.exemplo.redes;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ChatCliente extends JFrame {

	JTextField textoParaEnviar;
	PrintWriter escritor;
	Socket socket;
	String nome;
	JTextArea textRecebido;
	Scanner leitor;

	private class EscutaServidor implements Runnable {
		public void run() {
			try {
				String texto;
				while ((texto = leitor.nextLine()) != null) {
					textRecebido.append(texto + "\n");
				}
			} catch (Exception e) {

			}
		}
	}

	public ChatCliente(String nome) {
		super("Chat: " + nome);
		this.nome = nome;

		Font fonte = new Font("arial", Font.PLAIN, 26);
		textoParaEnviar = new JTextField();
		textoParaEnviar.setFont(fonte);
		JButton botao = new JButton("Enviar");
		botao.setFont(fonte);

		botao.addActionListener(new EnviarListener());

		Container envio = new JPanel();
		envio.setLayout(new BorderLayout());
		envio.add(BorderLayout.CENTER, textoParaEnviar);
		envio.add(BorderLayout.EAST, botao);

		textRecebido = new JTextArea();
		textRecebido.setFont(fonte);
		JScrollPane scroll = new JScrollPane(textRecebido);

		getContentPane().add(BorderLayout.CENTER, scroll);
		getContentPane().add(BorderLayout.SOUTH, envio);

		configurarRede();

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
	}

	private class EnviarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//Apos click no botao enviar
			escritor.println(nome + " : " + textoParaEnviar.getText());//Enviar a mensagem para servidor
			escritor.flush();//Garantir que informação foi encaminhada com sucesso
			textoParaEnviar.setText("");
			textoParaEnviar.requestFocus();//Curso volta para esse campo
		}
	}

	private void configurarRede() {
		try {
			socket = new Socket("127.0.0.1", 5000);
			escritor = new PrintWriter(socket.getOutputStream());//Representa um escritor de informações
			leitor = new Scanner(socket.getInputStream());
			new Thread(new EscutaServidor()).start();
		} catch (Exception erro) {

		}
	}

	public static void main(String[] args) {

		new ChatCliente("Felipe");
		new ChatCliente("Roberio");

	}

}
