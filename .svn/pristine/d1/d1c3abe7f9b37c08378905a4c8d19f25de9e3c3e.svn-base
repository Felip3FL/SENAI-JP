package fundamentos.regex.exercicios;

import static fundamentos.gui.Util.criaBotao;
import static fundamentos.gui.Util.criaPainel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ScanTest extends JFrame implements ActionListener {
	// CEP: "99999-999"
	String cep = "";

	// FONE: "[[99 ](99) ][9]9999-9999"
	String fone = "";

	// RG: "[99]9.999.999[-X]"
	String rg = "";

	// CPF: "[99]9.999.999-99"
	String cpf = "";

	// CNPJ: "[99]9.999.999/9999-99"
	String cnpj = "";

	// E-mail: "[xx.]xx@xxxxx.xxxxx.xxxxx"
	String email = "";
	
	// URL: "xxxx.xxxxx.xxxxx"
	String site = "";

	private JTextField tfCep = new JTextField(9);
	private JTextField tfFone = new JTextField(18);
	private JTextField tfRg = new JTextField(13);
	private JTextField tfCpf = new JTextField(14);
	private JTextField tfCnpj = new JTextField(19);
	private JTextField tfEmail = new JTextField(25);
	private JTextField tfSite = new JTextField(25);
	private JButton btValida = criaBotao("Valida", KeyEvent.VK_V, this);
	private JButton btSair = criaBotao("Sair", KeyEvent.VK_S, this);

	private List<Regra> lista = new ArrayList<Regra>();
	
	public ScanTest() {
		// Inicializa a Lista de Regras de Validação
		lista.add(new Regra(tfCep, "CEP Inválido!", cep));
		lista.add(new Regra(tfFone, "Fone Inválido!", fone));
		lista.add(new Regra(tfRg, "RG Inválido!", rg));
		lista.add(new Regra(tfCpf, "CPF Inválido!", cpf));
		lista.add(new Regra(tfCnpj, "CNPJ Inválido!", cnpj));
		lista.add(new Regra(tfEmail, "E-Mail Inválido!", email));
		lista.add(new Regra(tfSite, "Site Inválido!", site));
		
		// Controi a Tela
		setTitle("Validador");

		JPanel painelCentral = new JPanel();
		painelCentral.setLayout(new BoxLayout(painelCentral,
				BoxLayout.PAGE_AXIS));
		painelCentral.add(criaPainel("CEP", tfCep));
		painelCentral.add(criaPainel("Fone", tfFone));
		painelCentral.add(criaPainel("RG", tfRg));
		painelCentral.add(criaPainel("CPF", tfCpf));
		painelCentral.add(criaPainel("CNPJ", tfCnpj));
		painelCentral.add(criaPainel("E-Mail", tfEmail));
		painelCentral.add(criaPainel("Site", tfSite));
		add(painelCentral, BorderLayout.CENTER);
		add(criaPainel(btValida, btSair), BorderLayout.SOUTH);

		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getRootPane().setDefaultButton(btValida);
		setResizable(false);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() == btValida) {
			String msg = "";
			JTextField obj = null;
			for (Regra regex : lista) {
				if(!regex.valida()) {
					msg += regex.msg + "\n";
					
					if(obj == null)
						obj = regex.campo;
				}
			}
			
			if(msg.isEmpty())
				JOptionPane.showMessageDialog(null, "Teste Ok!");
			else
				JOptionPane.showMessageDialog(null, "Lista de Erros\n\n" + msg);
			
			if(obj == null)
				tfCep.requestFocus();
			else
				obj.requestFocus();
		} else {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new ScanTest();
	}

	public class Regra {
		private JTextField campo;
		private String msg;
		private String regra;

		public Regra(JTextField campo, String msg, String regra) {
			super();
			this.campo = campo;
			this.msg = msg;
			this.regra = regra;
		}

		public JTextField getCampo() {
			return campo;
		}

		public void setCampo(JTextField campo) {
			this.campo = campo;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public String getRegra() {
			return regra;
		}

		public void setRegra(String regra) {
			this.regra = regra;
		}

		public boolean valida() {
			return Pattern.matches(regra, campo.getText());
		}
	}
}
