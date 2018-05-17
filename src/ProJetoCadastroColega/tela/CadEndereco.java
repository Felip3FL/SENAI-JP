package ProJetoCadastroColega.tela;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import ProJetoCadastroColega.lib.VerificaInteiro;
import ProJetoCadastroColega.lib.VerificaRegex;
import ProJetoCadastroColega.model.Endereco;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class CadEndereco extends JDialog implements ActionListener {
	private JLabel lblLogr;
	private JTextField tfLogr;
	private JLabel lblN;
	private JTextField tfNum;
	private JLabel lblBairro;
	private JTextField tfBairro;
	private JLabel lblCep;
	private JTextField tfCep;
	private JButton btnSalvar;
	private JButton btnFechar;

	private Endereco meuEndereco;
	
	public CadEndereco(Endereco end) {  // <<======  Recebe o endereço para ser editado
		meuEndereco = end;			    // <<======  Guardar o endereco para uso posterior
		
		setResizable(false);
		setModal(true);
		setTitle("Cad. Endereço");
		setBounds(100, 100, 450, 193);
		
		lblLogr = new JLabel("Logr.");
		
		tfLogr = new JTextField();
		tfLogr.setColumns(10);
		tfLogr.setInputVerifier(new VerificaRegex("[a-zA-Z]{3,}"));
		
		lblN = new JLabel("Nº");
		
		tfNum = new JTextField();
		tfNum.setColumns(10);
		tfNum.setInputVerifier(new VerificaInteiro());
		
		lblBairro = new JLabel("Bairro");
		
		tfBairro = new JTextField();
		tfBairro.setColumns(10);
		tfBairro.setInputVerifier(new VerificaRegex("[a-zA-Z]{3,}"));
		
		lblCep = new JLabel("CEP");
		
		tfCep = new JTextField();
		tfCep.setColumns(10);
		tfCep.setInputVerifier(new VerificaInteiro());
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(this);
		
		btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(this);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblLogr)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(tfLogr, GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblN)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(tfNum, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblBairro)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(tfBairro, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblCep)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(tfCep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSalvar)
							.addGap(18)
							.addComponent(btnFechar)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLogr)
						.addComponent(tfLogr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblN)
						.addComponent(tfNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBairro)
						.addComponent(tfBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblCep)
						.addComponent(tfCep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSalvar)
						.addComponent(btnFechar))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);

		// Carrega o conteúdo do endereço na tela
		tfLogr.setText(meuEndereco.getLogradouro());
		tfNum.setText(meuEndereco.getNumero());
		tfBairro.setText(meuEndereco.getBairro());
		tfCep.setText(meuEndereco.getCep());
		
	}
	
	public void actionPerformed(ActionEvent ev) {
		if(ev.getSource().equals(btnSalvar)) {
			// Salva os dados da tela no objeto Endereco
			meuEndereco.setLogradouro(tfLogr.getText());
			meuEndereco.setNumero(tfNum.getText());
			meuEndereco.setBairro(tfBairro.getText());
			meuEndereco.setCep(tfCep.getText());
		}
		// Fecha a tela de Cad. de Endereco
		setVisible(false);
	}
}
