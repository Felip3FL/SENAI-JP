package api.fileio.resposta.cargaPesada;

import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;


@SuppressWarnings({"serial"})
public class ControleCarga extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnCarregar;
	private JButton btnSalvar;
	private JButton btnAbrir;
	private List<Veiculo> lista = new ArrayList<>();
	private VeiculoModel model = new VeiculoModel(lista);

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControleCarga frame = new ControleCarga();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ControleCarga() {
		setTitle("Controle de Entrada de Ve\u00EDculos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		scrollPane = new JScrollPane();
		
		btnCarregar = new JButton("Carregar");
		btnCarregar.addActionListener(this);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(this);
		
		btnAbrir = new JButton("Abrir");
		btnAbrir.addActionListener(this);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnCarregar)
							.addGap(18)
							.addComponent(btnSalvar)
							.addGap(18)
							.addComponent(btnAbrir)
							.addGap(70))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCarregar)
						.addComponent(btnSalvar)
						.addComponent(btnAbrir))
					.addContainerGap())
		);
		
		table = new JTable();
		table.setAutoCreateRowSorter(true);
		table.setModel(model);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
	
	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent ev) {
		Object botao = ev.getSource();
		try {		
			if (botao.equals(btnCarregar)) {
				String nomeArquivo = selecionaArquivo(FileDialog.LOAD);
				BufferedReader in = new BufferedReader(new FileReader(nomeArquivo));
				Pattern ptrn = Pattern.compile("[A-Z][a-z]{2}..[0-9] ([0-9]{2}:[0-9]{2}:[0-9]{2}) mac.*([A-Z]{3}-[0-9]{4}).*client '(.*)' \\[130\\].*");
				
				String linha = in.readLine();
				while (linha != null) {
					if(linha.matches(ptrn.pattern())) {
						Matcher mtx	= ptrn.matcher(linha);  
						mtx.find();  
						
						if(mtx.groupCount() == 3) {
							Veiculo obj = new Veiculo();
							obj.setHora(mtx.group(1));
							obj.setPlaca(mtx.group(2));
							obj.setMotorista(mtx.group(3));
							lista.add(obj);
						} 
					}
					linha = in.readLine();
				}
				model.setLista(lista);
				in.close();
			} else if (botao.equals(btnSalvar)) {
				String nomeArquivo = selecionaArquivo(FileDialog.SAVE);
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeArquivo));
				out.writeObject(lista);
				out.close();
			} else if (botao.equals(btnAbrir)) {
				String nomeArquivo = selecionaArquivo(FileDialog.LOAD);
				ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeArquivo));
				lista = (List<Veiculo>)in.readObject();
				in.close();
				model.setLista(lista);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public String selecionaArquivo(int modo) {
		FileDialog dialogo = new FileDialog((JDialog)null, "Selecione o Arquivo");
		dialogo.setFile("*");
		dialogo.setMode(modo);
		dialogo.setVisible(true);

		return dialogo.getDirectory() + dialogo.getFile();
	}
}

