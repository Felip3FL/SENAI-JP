package api.jdbc.exercicio01x;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.greef.ui.calendar.JCalendar;

import api.jdbc.lib.GerenteException;
import fundamentos.lib.SwUtil;

@SuppressWarnings("serial")
public class CadAmigo extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNome;
	private JTextField tfNome;
	private JLabel lblNewLabel;
	private JTextField tfNumFone;
	private JButton btnIncluir;
	private JButton btnListar;
	private JButton btnSair;
	private JPanel panel;
	private JCalendar calendar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadAmigo frame = new CadAmigo();
					frame.setVisible(true);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});
	}

	public CadAmigo() {
		setTitle("Cad Amigos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		lblNome = new JLabel("Nome");
		lblNome.setBounds(11, 17, 37, 16);

		tfNome = new JTextField();
		tfNome.setBounds(60, 11, 379, 28);
		tfNome.setColumns(10);

		lblNewLabel = new JLabel("Nº Telefone");
		lblNewLabel.setBounds(11, 51, 74, 16);

		tfNumFone = new JTextField();
		tfNumFone.setBounds(97, 45, 222, 28);
		tfNumFone.setColumns(10);

		btnIncluir = new JButton("Incluir");
		btnIncluir.setBounds(81, 279, 84, 29);
		btnIncluir.addActionListener(this);

		btnListar = new JButton("Listar");
		btnListar.setBounds(183, 279, 79, 29);
		btnListar.addActionListener(this);

		btnSair = new JButton("Sair");
		btnSair.setBounds(280, 279, 75, 29);
		btnSair.addActionListener(this);
		contentPane.setLayout(null);
		contentPane.add(lblNome);
		contentPane.add(tfNome);
		contentPane.add(lblNewLabel);
		contentPane.add(tfNumFone);
		contentPane.add(btnIncluir);
		contentPane.add(btnListar);
		contentPane.add(btnSair);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Data de Nascimento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(11, 79, 201, 188);
		contentPane.add(panel);
		
		calendar = new JCalendar();
		calendar.setTodayDate();
		calendar.setShowHorizontalLines(true);
		calendar.setShowVerticalLines(true);
		calendar.setColor("Calendar.Today.Background", Color.cyan);
		calendar.setFont("Calendar.Today", new Font("Dialog", Font.PLAIN | Font.BOLD, 12));
		panel.add(calendar);
	}

	public void actionPerformed(ActionEvent ev) {
		Object botao = ev.getSource();

		try {
			if (botao.equals(btnIncluir)) {
				Date dataSelecionada = calendar.getSelectedDate();
				Instant tempo = Instant.ofEpochMilli(dataSelecionada.getTime());
				LocalDateTime time = LocalDateTime.ofInstant(tempo, ZoneId.systemDefault());
				
				LocalDate data = time.toLocalDate();
				String fone = tfNumFone.getText();

				if (!fone.matches("(\\([0-9]{2}\\) )?(9)?\\d{4}-\\d{4}")) {
					JOptionPane.showMessageDialog(this, "E-Mail Inválido!");
				} else {
					Amigo obj = new Amigo();
					obj.setNome(tfNome.getText());
					obj.setNumTelefone(fone);
					obj.setDataNascimento(data);

					AmigoDao.manager.salvar(obj);

					SwUtil.limpa(this);
					calendar.setTodayDate();
					tfNome.requestFocus();
				}
			} else if (botao.equals(btnListar)) {
				JOptionPane.showMessageDialog(this, 
						AmigoDao.manager.listaTodos()
							.stream()
							.map(Amigo::toString)
							.collect(Collectors.joining("\n")));
				
				tfNome.requestFocus();
			} else {
				System.exit(0);
			}
		} catch (DateTimeParseException ex) {
			JOptionPane.showMessageDialog(this, "Data Inválida!");
		} catch (GerenteException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage());
			ex.printStackTrace();
		}
	}
}
