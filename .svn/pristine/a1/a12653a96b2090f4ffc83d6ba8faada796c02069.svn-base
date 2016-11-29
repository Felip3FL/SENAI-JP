package fundamentos.datas.respostas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.time.temporal.TemporalQueries;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class FormataDadaJava8 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblInforme;
	private JFormattedTextField tfData;
	private JButton btnFormata;
	private JButton btnSair;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormataDadaJava8 frame = new FormataDadaJava8();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FormataDadaJava8() {
		setTitle("Formata Data - Java 8");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 347, 153);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblInforme = new JLabel("Informe uma Data");
		lblInforme.setBounds(23, 31, 122, 16);
		contentPane.add(lblInforme);

		// Constroi o verificador de data
		DateTimeFormatter df =  DateTimeFormatter.ofPattern("d/MM/y"); //SwUtil.getDateTimeFormatter();
		df.withResolverStyle(ResolverStyle.STRICT);         
		
		// Associa ao JFormattedTextField
		tfData = new JFormattedTextField(df.toFormat(TemporalQueries.localDate()));
		tfData.setBounds(157, 25, 134, 28);
		contentPane.add(tfData);
		tfData.setColumns(10);
		
		btnFormata = new JButton("Formatar");
		btnFormata.addActionListener(this);
		btnFormata.setBounds(23, 83, 117, 29);
		contentPane.add(btnFormata);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		btnSair.setBounds(213, 83, 117, 29);
		contentPane.add(btnSair);
		
		setLocationRelativeTo(null);
	}
	public void actionPerformed(ActionEvent ev) {
		Object botao = ev.getSource();
		
		if(botao.equals(btnFormata)) {
			LocalDate data = (LocalDate)tfData.getValue();
			
			if(data != null) {
				String msg = "Dia: "   + data.getDayOfMonth() + 
							 "\nMês: " + data.getMonthValue() +
							 "\nAno: " + data.getYear();
				
				JOptionPane.showMessageDialog(null, msg);
				tfData.setValue(null);
				tfData.requestFocus();
			} else
				JOptionPane.showMessageDialog(null, "Data Inválida");
		} else {
			System.exit(0);
		}
	}
}
