package api.fileio.exemplos;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JDialog;

public class ExemploReaderWriter {
	public static void main(String[] args) {
		
		FileDialog dialogo = new FileDialog((JDialog)null, "Selecione o Arquivo");
		dialogo.setFile("*.txt");
		dialogo.setMode(FileDialog.SAVE);
		dialogo.setVisible(true);

		String nomeArquivo = dialogo.getDirectory() + dialogo.getFile();
		try (
				PrintWriter fw = new PrintWriter(nomeArquivo);
			) {
			fw.println("Este é um texto - 1!");
			fw.println("Este é um texto - 2!");
			fw.println("Este é um texto - 3!");
			fw.println("Este é um texto - 4!");
		} catch (IOException ex) {
			System.out.println("Falha na gravação do Arquivo");
		}

		dialogo.setMode(FileDialog.LOAD);
		dialogo.setVisible(true);

		 nomeArquivo = dialogo.getDirectory() + dialogo.getFile();
		
		try (
				FileReader fw = new FileReader(nomeArquivo);
				BufferedReader in = new BufferedReader(fw);
			) {
			
			String linha = in.readLine();
			while (linha != null) {
				System.out.println(linha);
				
				linha = in.readLine();
			}
		} catch (IOException ex) {
			System.out.println("Falha na gravação do Arquivo");
		}
	}
}
