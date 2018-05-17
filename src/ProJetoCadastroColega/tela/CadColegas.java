package ProJetoCadastroColega.tela;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.stream.Collectors;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import ProJetoCadastroColega.dao.ColegaException;
import ProJetoCadastroColega.dao.DbColega;
import ProJetoCadastroColega.lib.SwUtil;
import ProJetoCadastroColega.lib.VerificaInteiro;
import ProJetoCadastroColega.lib.VerificaRegex;
import ProJetoCadastroColega.lib.VerificaValor;
import ProJetoCadastroColega.model.ColegaWhatsApp;
import ProJetoCadastroColega.model.ColegadoFace;
import ProJetoCadastroColega.model.ColegadoTwitter;
import ProJetoCadastroColega.model.Endereco;

@SuppressWarnings("serial")
public class CadColegas extends JFrame implements ActionListener, Serializable {

	private JPanel contentPane;
	private JLabel lblNome;
	private JTextField tfNome;
	private JLabel lblEmail;
	private JTextField tfEmail;
	private JLabel lblIdade;
	private JTextField tfIdade;
	private JTabbedPane tabbedPane;
	private JPanel pnFace;
	private JPanel pnTwit;
	private JPanel pnWhat;
	private JLabel lblFace;
	private JTextField tfFace;
	private JLabel lblTwit;
	private JTextField tfTwit;
	private JLabel lblNWhat;
	private JTextField tfWhat;
	private JButton btnSalvar;
	private JButton btnListar;
	private JButton btnSair;
	private JButton btnEndereo;

	private Endereco endResidencial = new Endereco();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadColegas frame = new CadColegas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//TODO: Implementar validação dos campos da tela
	//TODO: Incluir data de nascimento ao Colega
	public CadColegas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblNome = new JLabel("Nome");
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setInputVerifier(new VerificaRegex("[a-zA-Z]{3,}"));
		
		lblEmail = new JLabel("E-Mail");
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setInputVerifier(new VerificaRegex("[a-z_0-9\\._]{1,50}@[a-z]{1,50}\\.[a-z]{1,3}(\\.[a-z]{2})?"));
		
		lblIdade = new JLabel("Idade");
		
		tfIdade = new JTextField();
		tfIdade.setColumns(10);
		tfIdade.setInputVerifier(new VerificaInteiro());;
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(this);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		
		btnEndereo = new JButton("Endereço");
		btnEndereo.addActionListener(this);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNome)
								.addComponent(lblEmail)
								.addComponent(lblIdade))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(tfIdade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
									.addComponent(btnEndereo, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
								.addComponent(tfEmail, GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
								.addComponent(tfNome, GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)))
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 411, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnSalvar)
							.addGap(104)
							.addComponent(btnListar)
							.addPreferredGap(ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
							.addComponent(btnSair)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(tfNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(tfEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdade)
						.addComponent(tfIdade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEndereo))
					.addGap(18)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSalvar)
						.addComponent(btnSair)
						.addComponent(btnListar))
					.addContainerGap())
		);
		
		pnFace = new JPanel();
		tabbedPane.addTab("Facebook", null, pnFace, null);
		
		lblFace = new JLabel("Face");
		
		tfFace = new JTextField();
		tfFace.setColumns(10);
		tfFace.setInputVerifier(new VerificaRegex("[A-Za-z0-9\\._]{3,}"));
		GroupLayout gl_pnFace = new GroupLayout(pnFace);
		gl_pnFace.setHorizontalGroup(
			gl_pnFace.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnFace.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFace)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tfFace, GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_pnFace.setVerticalGroup(
			gl_pnFace.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnFace.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_pnFace.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFace)
						.addComponent(tfFace, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		pnFace.setLayout(gl_pnFace);
		
		pnTwit = new JPanel();
		tabbedPane.addTab("Twitter", null, pnTwit, null);
		
		lblTwit = new JLabel("Nick Name");
		
		tfTwit = new JTextField();
		tfTwit.setColumns(10);
		tfTwit.setInputVerifier(new VerificaRegex("#[a-zA-Z\\._]{3,}"));
		GroupLayout gl_pnTwit = new GroupLayout(pnTwit);
		gl_pnTwit.setHorizontalGroup(
			gl_pnTwit.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnTwit.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTwit)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tfTwit, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_pnTwit.setVerticalGroup(
			gl_pnTwit.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnTwit.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_pnTwit.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTwit)
						.addComponent(tfTwit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(34, Short.MAX_VALUE))
		);
		pnTwit.setLayout(gl_pnTwit);
		
		pnWhat = new JPanel();
		tabbedPane.addTab("WhatsApp", null, pnWhat, null);
		
		lblNWhat = new JLabel("Nº do Telefone");
		
		tfWhat = new JTextField();
		tfWhat.setColumns(10);
		tfWhat.setInputVerifier(new VerificaInteiro());
		GroupLayout gl_pnWhat = new GroupLayout(pnWhat);
		gl_pnWhat.setHorizontalGroup(
			gl_pnWhat.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnWhat.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNWhat)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tfWhat, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_pnWhat.setVerticalGroup(
			gl_pnWhat.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnWhat.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_pnWhat.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNWhat)
						.addComponent(tfWhat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		pnWhat.setLayout(gl_pnWhat);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void actionPerformed(ActionEvent ev) {
		Object botao = ev.getSource();
		
		// Obtem o objeto responsável por guardar os Objetos
		DbColega db = DbColega.getInstance();
		
		
		try {
			if(botao.equals(btnEndereo)) {
				CadEndereco dialog = new CadEndereco(endResidencial);  //  envia o endereço para ser editado
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setLocationRelativeTo(this); // <<<====  centraliza o diálogo à frete da tela principal
				dialog.setVisible(true);
			} else if(botao.equals(btnSalvar)) {
				int aba = tabbedPane.getSelectedIndex();

				if(aba == 0) { // Facebook
					// Cria o objeto Colega do Facebook para cadastrar os dados
					ColegadoFace colega = new ColegadoFace();
					colega.setNome(tfNome.getText());
					colega.setEmail(tfEmail.getText());
					colega.setIdade(Integer.parseInt(tfIdade.getText()));
					colega.setFacebook(tfFace.getText());
					colega.setResidencia(endResidencial); // <<=== guarda o endereço do colega

					// Salva o Objeto Colaga
					db.salve(colega);
				} else if(aba == 1) { // Twitter
					// Cria o objeto Colega do Twitter para cadastrar os dados
					ColegadoTwitter colega = new ColegadoTwitter();
					colega.setNome(tfNome.getText());
					colega.setEmail(tfEmail.getText());
					colega.setIdade(Integer.parseInt(tfIdade.getText()));
					colega.setTwitter(tfTwit.getText());
					colega.setResidencia(endResidencial); // <<=== guarda o endereço do colega

					// Salva o Objeto Colaga
					db.salve(colega);				
				} else { // WhatsApp
					// Cria o objeto Colega do WhatsApp para cadastrar os dados
					ColegaWhatsApp colega = new ColegaWhatsApp();
					colega.setNome(tfNome.getText());
					colega.setEmail(tfEmail.getText());
					colega.setIdade(Integer.parseInt(tfIdade.getText()));
					colega.setNumTelefone(tfWhat.getText());
					colega.setResidencia(endResidencial); // <<=== guarda o endereço do colega

					// Salva o Objeto Colaga
					db.salve(colega);
				}

				// Rotina que limpa todos os campos de um JFrame
				SwUtil.limpa(this);

				endResidencial = new Endereco(); // << =====  Cria um novo endereço para um novo Colega
				
				// Põe o cursor no campo nome
				tfNome.requestFocus();
			} else if(botao.equals(btnListar)) {
				// Percorre o conteúdo da lista e cria uma String 
				// contendo os dados de cada Contado separando
				// estes por um New Line (\n)
				JOptionPane.showMessageDialog(this, 
						"Cadastro de Colegas\n\n" +
								db.lista().stream()
								.map(colega -> colega.toString())
								.collect(Collectors.joining("\n"))
						);			
			} else {
				System.exit(0);
			}
		}catch(ColegaException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
	}
}
