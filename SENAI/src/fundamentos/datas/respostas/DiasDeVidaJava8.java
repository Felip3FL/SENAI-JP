package fundamentos.datas.respostas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fundamentos.lib.SwUtil;

@SuppressWarnings("serial")
public class DiasDeVidaJava8 extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JLabel lblDataDeNascimento;
	private JFormattedTextField tfData;
	private JButton btnCalcular;
	private JButton btnSair;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DiasDeVidaJava8 frame = new DiasDeVidaJava8();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DiasDeVidaJava8() {
		setTitle("Dias de Vida - Java 8");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 337, 144);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setBounds(23, 30, 137, 16);
		contentPane.add(lblDataDeNascimento);
		
		tfData = SwUtil.criaMascara("##/##/####");
		tfData.setBounds(171, 24, 134, 28);
		contentPane.add(tfData);
		tfData.setColumns(10);
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(this);
		btnCalcular.setBounds(23, 75, 117, 29);
		contentPane.add(btnCalcular);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		btnSair.setBounds(188, 75, 117, 29);
		contentPane.add(btnSair);
		
		setLocationRelativeTo(null);
	}
	
	public void actionPerformed(ActionEvent ev) {
		Object botao = ev.getSource();
		
		if(botao.equals(btnCalcular)) {
			try {
				// Valida a data
				LocalDate data = LocalDate.parse(tfData.getText(), SwUtil.getDateTimeFormatter());

				// Calcula o nº de dias entre a data informada e hoje
				long dias = ChronoUnit.DAYS.between(data, LocalDate.now()); 

				// Mostra o resultado
				JOptionPane.showMessageDialog(null, "Você já viveu " + dias + " dias", "R E S U L T A D O",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Data inválida", "E R R O", 
						JOptionPane.ERROR_MESSAGE);
			}
			tfData.setText("");
			tfData.requestFocus();
		} else {
			System.exit(0);
		}
	}
}
