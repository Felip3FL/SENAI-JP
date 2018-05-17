package d_heranca;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class CadColegas extends JFrame implements ActionListener {

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
	private JLabel lblNewLabel;
	private JTextField tfTwitter;
	private JLabel lblNumero;
	private JTextField tfWhatsapp;
	private JButton btnSalvar;
	private JButton btnListar;
	private JButton btnSair;


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
	//TODO: Cadastrar o endereço do colega (JDailog)
	public CadColegas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblNome = new JLabel("Nome");
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		
		lblEmail = new JLabel("Email");
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		
		lblIdade = new JLabel("Idade");
		
		tfIdade = new JTextField();
		tfIdade.setColumns(10);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(this);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
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
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(tfEmail, GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
								.addComponent(tfNome, GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
								.addComponent(tfIdade, GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)))
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 399, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnSalvar)
							.addGap(97)
							.addComponent(btnListar)
							.addPreferredGap(ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
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
						.addComponent(tfIdade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSalvar)
						.addComponent(btnSair)
						.addComponent(btnListar))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		pnFace = new JPanel();
		tabbedPane.addTab("Facebook", null, pnFace, null);
		
		lblFace = new JLabel("Face");
		
		tfFace = new JTextField();
		tfFace.setColumns(10);
		GroupLayout gl_pnFace = new GroupLayout(pnFace);
		gl_pnFace.setHorizontalGroup(
			gl_pnFace.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnFace.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFace)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tfFace, GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_pnFace.setVerticalGroup(
			gl_pnFace.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnFace.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_pnFace.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFace)
						.addComponent(tfFace, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		pnFace.setLayout(gl_pnFace);
		
		pnTwit = new JPanel();
		tabbedPane.addTab("Twitter", null, pnTwit, null);
		
		lblNewLabel = new JLabel("Nick Name");
		
		tfTwitter = new JTextField();
		tfTwitter.setColumns(10);
		GroupLayout gl_pnTwit = new GroupLayout(pnTwit);
		gl_pnTwit.setHorizontalGroup(
			gl_pnTwit.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnTwit.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tfTwitter, GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_pnTwit.setVerticalGroup(
			gl_pnTwit.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnTwit.createSequentialGroup()
					.addGap(35)
					.addGroup(gl_pnTwit.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(tfTwitter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		pnTwit.setLayout(gl_pnTwit);
		
		pnWhat = new JPanel();
		tabbedPane.addTab("Whatsapp", null, pnWhat, null);
		
		lblNumero = new JLabel("Número");
		
		tfWhatsapp = new JTextField();
		tfWhatsapp.setColumns(10);
		GroupLayout gl_pnWhat = new GroupLayout(pnWhat);
		gl_pnWhat.setHorizontalGroup(
			gl_pnWhat.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnWhat.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNumero)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tfWhatsapp, GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_pnWhat.setVerticalGroup(
			gl_pnWhat.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnWhat.createSequentialGroup()
					.addGap(36)
					.addGroup(gl_pnWhat.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumero)
						.addComponent(tfWhatsapp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		pnWhat.setLayout(gl_pnWhat);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void actionPerformed(ActionEvent ev) {
		Object botao = ev.getSource();
		
		//Obtem o objeto resposável por guardar os Objetos
		DbColega db = DbColega.getInstance();
		
		if(botao.equals(btnSalvar)){
			int aba = tabbedPane.getSelectedIndex();
			
			if(aba ==0){ // Facebook
				//Cria o objeto Colega do Facebook para cadastrar os dados
				ColegadoFace colega = new ColegadoFace();
				colega.setNome(tfNome.getText());
				colega.setEmail(tfEmail.getText());
				colega.setIdade(Integer.parseInt(tfIdade.getText()));
				colega.setFacebook(tfFace.getText());
				
				// Salva o Objeto Colega
				db.salve(colega);
				
			}else if(aba == 1){ //Twitter
				//Cria o objeto Colega do Twitter para cadastrar os dados
				ColegadoTwitter colega = new ColegadoTwitter();
				colega.setNome(tfNome.getText());
				colega.setEmail(tfEmail.getText());
				colega.setIdade(Integer.parseInt(tfIdade.getText()));
				colega.setTwitter(tfTwitter.getText());
				
				// Salva o Objeto Colega
				db.salve(colega);				
				
				
			}else{ // Whatsapp
				//Cria o objeto Colega do Whatsapp para cadastrar os dados
				ColegaWhatsApp colega = new ColegaWhatsApp();
				colega.setNome(tfNome.getText());
				colega.setEmail(tfEmail.getText());
				colega.setIdade(Integer.parseInt(tfIdade.getText()));
				colega.setNumTelefone(tfWhatsapp.getText());
				
				// Salva o Objeto Colega
				db.salve(colega);	
			}
			
			tfNome.setText("");
			tfEmail.setText("");
			tfIdade.setText("");
			tfFace.setText("");
			tfTwitter.setText("");
			tfWhatsapp.setText("");
			
			// Reposiciona na primeira aba
			tabbedPane.setSelectedIndex(0);
			
			// Põe o curso no campo nome
			tfNome.requestFocus();
			
		}else if(botao.equals(btnListar)){
			// Prepara uma String para conter os dados de todos os colegas cadastrados
			String msg = "Cadastro de Colegas\n\n";
			
			//Obtem a lista dos Colegas cadastrados
			List<Colega> lista = db.lista();
			
			//Percorre a lista
			for(int i = 0; i < lista.size();i++){
				//Para cada colega
				Colega colega = lista.get(i);
				//Obtenha seus dados
				msg += colega + "\n";
			}
			
			// Apresenta a lista final
			JOptionPane.showMessageDialog(this, msg);
			
			// Alternativa para o código acima utilizando
			// implementações do Java 8
			JOptionPane.showMessageDialog(this, "Cadastro de Colegas\n\n" + db.lista()
																			.stream()
																			.map(colega -> colega.toString())
																			.collect(Collectors.joining("\n")));
			
		}else {
			System.exit(0);
		}
	}
}
