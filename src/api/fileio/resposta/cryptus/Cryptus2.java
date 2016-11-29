package api.fileio.resposta.cryptus;

import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Cryptus2 extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnArquivo;
	private JMenuItem mntmEncriptar;
	private JMenuItem mntmDesencriptar;
	private JSeparator separator;
	private JMenuItem mntmSair;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JMenuItem mntmVersao;
	private String nomeArquivoChave = "cryptus.cfg";
	private FileDialog dialogo = new FileDialog((JDialog) null);

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cryptus2 frame = new Cryptus2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Cryptus2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);

		mntmEncriptar = new JMenuItem("Encriptar");
		mntmEncriptar.addActionListener(this);
		mntmEncriptar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.META_MASK));
		mnArquivo.add(mntmEncriptar);

		mntmDesencriptar = new JMenuItem("Desencriptar");
		mntmDesencriptar.addActionListener(this);
		mntmDesencriptar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.META_MASK));
		mnArquivo.add(mntmDesencriptar);

		separator = new JSeparator();
		mnArquivo.add(separator);

		mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(this);
		mntmSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.META_MASK));
		mnArquivo.add(mntmSair);

		mntmVersao = new JMenuItem("Vers\u00E3o");
		mntmVersao.addActionListener(this);
		menuBar.add(mntmVersao);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		scrollPane = new JScrollPane();

		textArea = new JTextArea();
		textArea.setEditable(true);
		scrollPane.setViewportView(textArea);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(1)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
					.addGap(1))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(1)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
					.addGap(1))
		);
		contentPane.setLayout(gl_contentPane);
	}

	public void actionPerformed(ActionEvent ev) {
		Object item = ev.getSource();
		try {
			if (item.equals(mntmEncriptar)) {
				String nomeArquivoDestino = getArquivoSaida();

				// Criptografa o arquivo utilizando a chave de encriptação
				try (CipherOutputStream cos = 
						new CipherOutputStream(new FileOutputStream(new File(nomeArquivoDestino)), getCipher());
					  PrintWriter pw = new PrintWriter(new OutputStreamWriter(cos)); ) {

					pw.print(textArea.getText());

				}
			} else if (item.equals(mntmDesencriptar)) {
				String nomeArquivoOrigem = getArquivoEntrada();

				// Dessencripta o arquivo e mostra o conteúdo
				try (CipherInputStream cis = 
						new CipherInputStream(new FileInputStream(new File(nomeArquivoOrigem)),  getCipher());
						BufferedReader br = new BufferedReader(new InputStreamReader(cis));
					) {
					textArea.setText("");
					for(String linha;(linha = br.readLine()) != null;) {
						textArea.append(linha + "\n");
					}
				}
			} else if (item.equals(mntmVersao)) {
				JOptionPane.showMessageDialog(this, "Cryptus ++\nVersão 1.0.12423", 
						"Informações", JOptionPane.INFORMATION_MESSAGE);
			} else {
				System.exit(0);
			}
		} catch (IOException | CryptusException ex) {
			ex.printStackTrace();
		}
	}

	private Cipher createCipher() throws CryptusException {
		URL local = Cryptus2.class.getResource("Cryptus2.class");

		File chave = new File(local.getPath().replace("Cryptus2.class",nomeArquivoChave));
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(chave));){
			// Gera chaves de encriptação utilizando o algoritmo DES
			KeyGenerator kg = KeyGenerator.getInstance("DES");
			kg.init(new SecureRandom());
			SecretKey key = kg.generateKey();

			SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
			Class<?> spec = Class.forName("javax.crypto.spec.DESKeySpec");
			DESKeySpec ks = (DESKeySpec) skf.getKeySpec(key, spec);

			// Inicializa o Encriptador com a chave de encriptação
			Cipher c = Cipher.getInstance("DES/CFB8/NoPadding");
			c.init(Cipher.ENCRYPT_MODE, key);

			// Armazena as chaves no arquivo com extensão .key
			oos.writeObject(ks.getKey());
			oos.writeObject(c.getIV());

			return c;
		} catch (InvalidKeyException | ClassNotFoundException | NoSuchAlgorithmException
				| InvalidKeySpecException | NoSuchPaddingException | IOException ex) {
			throw new CryptusException("Problemas no processamento do algoritmo DES");
		}
	}

	public Cipher getCipher(/*String chave*/) throws CryptusException {
		try {
			URL local = Cryptus2.class.getResource(nomeArquivoChave);

			if(local == null) {
				return createCipher();
			} else {
				File chave = new File(local.toURI());

				try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(chave));) {
					// Lê a chave de desencriptação
					DESKeySpec ks = new DESKeySpec((byte[]) ois.readObject());
					SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
					SecretKey key = skf.generateSecret(ks);

					// Inicializa o cifrador com o algoritmo DES
					Cipher c = Cipher.getInstance("DES/CFB8/NoPadding");
					c.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec((byte[]) ois.readObject()));

					return c;
				}
			}
		} catch (IOException ex) {
			throw new CryptusException("Problemas na leitura das Chaves de encriptação");
		} catch (InvalidKeyException | ClassNotFoundException | NoSuchAlgorithmException
				| InvalidKeySpecException | NoSuchPaddingException | InvalidAlgorithmParameterException ex) {
			throw new CryptusException("Problemas no processamento do algoritmo DES");
		} catch (URISyntaxException e) {
			throw new CryptusException("Falha em gravar o arquivo de configuração");
		}
	}

	public String getArquivoEntrada() {
		dialogo.setTitle("Selecione o Arquivo de Origem");
		dialogo.setFile("*.txt");
		dialogo.setMode(FileDialog.LOAD);
		dialogo.setVisible(true);

		return dialogo.getDirectory() + dialogo.getFile();
	}

	public String getArquivoSaida() {
		dialogo.setTitle("Seleciona o Arquivo de Destino");
		dialogo.setFile("*.cph");
		dialogo.setMode(FileDialog.SAVE);
		dialogo.setVisible(true);

		return dialogo.getDirectory() + dialogo.getFile();
	}
}