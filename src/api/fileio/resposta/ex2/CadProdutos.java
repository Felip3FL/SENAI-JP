package api.fileio.resposta.ex2;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class CadProdutos extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JLabel lblCod;
	private JTextField tfCod;
	private JLabel lblNome;
	private JTextField tfNome;
	private JLabel lblDescrio;
	private JTextField tfDesc;
	private JLabel lblValor;
	private JTextField tfValor;
	private JLabel lblQuantidade;
	private JTextField tfQtd;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnInserir;
	private JButton btnSalvar;
	private JButton btnSair;
	
	private List<Produto> lista = new ArrayList<Produto>();
	private ModelProduto model = new ModelProduto(lista);

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadProdutos frame = new CadProdutos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CadProdutos() {
		setMinimumSize(new Dimension(450, 300));
		setTitle("Cadastro de Produtos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblCod = new JLabel("Cod.");
		
		tfCod = new JTextField();
		tfCod.setColumns(10);
		
		lblNome = new JLabel("Nome");
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		
		lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		
		tfDesc = new JTextField();
		tfDesc.setColumns(10);
		
		lblValor = new JLabel("Valor");
		
		tfValor = new JTextField();
		tfValor.setColumns(10);
		
		lblQuantidade = new JLabel("Quantidade");
		
		tfQtd = new JTextField();
		tfQtd.setColumns(10);
		
		scrollPane = new JScrollPane();
		
		btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(this);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(this);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblCod)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfCod, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(lblNome)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfNome, GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblDescrio)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfDesc, GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblValor)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfValor, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(lblQuantidade)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfQtd, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnInserir, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
							.addGap(89)
							.addComponent(btnSalvar, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
							.addGap(99)
							.addComponent(btnSair, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCod)
						.addComponent(tfCod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNome)
						.addComponent(tfNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDescrio)
						.addComponent(tfDesc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValor)
						.addComponent(tfValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblQuantidade)
						.addComponent(tfQtd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnInserir)
						.addComponent(btnSair)
						.addComponent(btnSalvar))
					.addContainerGap())
		);
		
		table = new JTable();
		table.setModel(model);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		
		
		carregaProdutos();
	}
	
	public void actionPerformed(ActionEvent ev) {
		Object cmd = ev.getSource();
		
		if(cmd.equals(btnInserir)) {
			Produto prod = new Produto();
			prod.setCodigo(Integer.parseInt(tfCod.getText()));
			prod.setNome(tfNome.getText());
			prod.setDescricao(tfDesc.getText());
			prod.setValor(Double.parseDouble(tfValor.getText()));
			prod.setQuantidade(Integer.parseInt(tfQtd.getText()));
			
			model.adiciona(prod);
			
			tfCod.setText("");
			tfNome.setText("");
			tfDesc.setText("");
			tfValor.setText("");
			tfQtd.setText("");
			tfCod.requestFocus();
		} else if(cmd.equals(btnSalvar)) {
			FileDialog fd = new FileDialog(this, 
					"Selecione o nome do arquivo para armazenar os produtos", FileDialog.SAVE);
			fd.setLocationRelativeTo(this);
			fd.setFile("*.dat");
			fd.setVisible(true);
			
			String nome = fd.getFile();
			if(nome != null) {
				try {
					FileOutputStream fs = new FileOutputStream(fd.getDirectory() + nome);
					ObjectOutputStream out = new ObjectOutputStream(fs);
					out.writeObject(lista);
					out.close();
					JOptionPane.showMessageDialog(this, "Produtos Salvos");
				} catch(IOException ex) {
					JOptionPane.showMessageDialog(this, "Erro ao salvar os produtos");
				}
			}
		} else {
			System.exit(0);
		}
	}

	@SuppressWarnings("unchecked")
	public void carregaProdutos() {
		FileDialog fd = new FileDialog(this, 
				"Selecione o nome do arquivo que contém a lista de produtos", FileDialog.LOAD);
		fd.setLocationRelativeTo(this);
		fd.setFile("*.dat");
		fd.setVisible(true);
		
		String nome = fd.getFile();
		if(nome != null) {
			try {
				FileInputStream fs = new FileInputStream(fd.getDirectory() + nome);
				ObjectInputStream out = new ObjectInputStream(fs);
				lista = (List<Produto>)out.readObject();
				out.close();
				model.setLista(lista);
			} catch(Exception ex) {
				JOptionPane.showMessageDialog(this, "Erro ao salvar os produtos");
				ex.printStackTrace();
			}
		}

	}
}
