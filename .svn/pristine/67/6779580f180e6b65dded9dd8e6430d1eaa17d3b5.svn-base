package api.fileio.exemplos.serializacao;

import java.awt.FileDialog;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

@SuppressWarnings("unchecked")
public class LeDados {
	public static void main(String[] args) {
		// Abre Dialogo para solicitar o nome do arquivo onde os objetos foram
		// gravados
		FileDialog dialogo = new FileDialog((JDialog) null, "Selecione o Arquivo");
		dialogo.setFile("*.obj");
		dialogo.setMode(FileDialog.LOAD);
		dialogo.setVisible(true);

		// Lê o arquivo e apresenta os objetos
		String nomeArquivo = dialogo.getDirectory() + dialogo.getFile();
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeArquivo));) {
			List<Contrato> lista = (List<Contrato>) in.readObject();

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
