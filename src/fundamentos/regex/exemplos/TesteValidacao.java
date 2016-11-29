package fundamentos.regex.exemplos;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import fundamentos.lib.StatusValidador;
import fundamentos.lib.SwUtil;
import fundamentos.lib.VerificaRegex;
import fundamentos.lib.VerificaValor;

@SuppressWarnings("serial")
public class TesteValidacao extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblValor;
	private JFormattedTextField tfValor;
	private JButton btnOk;
	private JLabel lbMsg;
	private JLabel lblEmail;
	private JTextField tfEmail;
	private JLabel lbMsg2;
	private NumberFormat format = NumberFormat.getInstance();


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TesteValidacao frame = new TesteValidacao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TesteValidacao() {
		format.setMinimumFractionDigits(2);
		format.setMaximumFractionDigits(2);
		
		setResizable(false);
		setTitle("Teste Validador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 366, 232);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		lblValor = new JLabel("Valor");
		lblValor.setBounds(31, 27, 32, 15);

		lbMsg = new JLabel(" ");
		lbMsg.setForeground(Color.RED);
		lbMsg.setBounds(31, 50, 207, 15);

		tfValor = new JFormattedTextField(format);
		tfValor.setBounds(81, 25, 114, 19);
		tfValor.setColumns(10);
		tfValor.setInputVerifier(new VerificaValor(lbMsg));

		btnOk = new JButton("Ok");
		btnOk.addActionListener(this);
		btnOk.setBounds(31, 155, 52, 25);

		contentPane.setLayout(null);
		contentPane.add(lblValor);
		contentPane.add(tfValor);
		contentPane.add(btnOk);
		contentPane.add(lbMsg);
		
		lblEmail = new JLabel("E-Mail");
		lblEmail.setBounds(31, 93, 60, 15);
		contentPane.add(lblEmail);

		lbMsg2 = new JLabel(" ");
		lbMsg2.setForeground(Color.RED);
		lbMsg2.setBounds(31, 128, 207, 15);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(81, 91, 249, 19);
		contentPane.add(tfEmail);
		tfEmail.setColumns(10);
		tfEmail.setInputVerifier(new VerificaRegex(lbMsg2, "(\\w[\\w-]+\\.){0,}[\\w-]{3,}@[\\w-]{3,}(\\.\\w{2,}){1,2}"));
		
		contentPane.add(lbMsg2);
	}

	public void actionPerformed(ActionEvent ev) {
		  // percorre o frame e ferifica se tem erro
		StatusValidador status = SwUtil.verificaStatus(this);
		
		// Testa a condição de erro dos campos
		if(status.equals(StatusValidador.OK)) {
			double num = (double) tfValor.getValue();
			String email = tfEmail.getText();
		
			JOptionPane.showMessageDialog(this, "E-Mail: " + email + " Valor: R$ " + format.format(num));
		} else if(status.equals(StatusValidador.EM_BRANCO)) {
			JOptionPane.showMessageDialog(this, "Os Campos estão vazios");
		} else {
			JOptionPane.showMessageDialog(this, "Corrija os Erros");
		}
	}
}
