package api.fileio.exemplos.serializacao;

import java.awt.FileDialog;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class GravaLeObjeto {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// Carrega uma coleção com Objetos
		List<Contrato> lista = new ArrayList<>();
		lista.add(new Contrato(123,
				"Construção de Nova Represa para abastecimento de São Paulo"));
		lista.add(new Contrato(124123,
				"Contratação de corpo policial para acabar com a marginalidade em São Paulo"));
		lista.add(new Contrato(34342,
				"Contratação de corpo docente para aumentar o nível da educação nesta"
						+ "Terra, pois com educação é que se Levanta um Pais"));

		// Abre Dialogo para solicitar o nome do Arquivo a ser Gravado
		FileDialog dialogo = new FileDialog((JDialog) null, "Selecione o Arquivo");
		dialogo.setFile("*.obj");
		dialogo.setMode(FileDialog.SAVE);
		dialogo.setVisible(true);

		// Grava a lista de Objetos no arquivo
		String nomeArquivo = dialogo.getDirectory() + dialogo.getFile();
		try ( 
				FileOutputStream fo = new FileOutputStream(nomeArquivo);
				ObjectOutputStream out = new ObjectOutputStream(fo)
			) {
			out.writeObject(lista);
		} catch (NotSerializableException ex) {
			System.out.println("O Objeto não pode ser Serializado");
			ex.printStackTrace();
		} catch (IOException ex) {
			System.out.println("Falha na gravação do Arquivo");
			ex.printStackTrace();
		}

		// Abre Dialogo para solicitar o nome do arquivo onde os objetos foram
		// gravados
		dialogo.setFile("*.obj");
		dialogo.setMode(FileDialog.LOAD);
		dialogo.setVisible(true);

		// Lê o arquivo e apresenta os objetos
		nomeArquivo = dialogo.getDirectory() + dialogo.getFile();
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(
				nomeArquivo));) {
			lista = (List<Contrato>) in.readObject();

			String msg = "Cadastro de Contratos\n\n";
			for (Contrato obj : lista) {
				msg += obj + "\n";
			}
			JOptionPane.showMessageDialog(null, msg);
		} catch (IOException | ClassNotFoundException ex) {
			System.out.println("Falha na gravação do Arquivo");
			ex.printStackTrace();
		}
	}
}
