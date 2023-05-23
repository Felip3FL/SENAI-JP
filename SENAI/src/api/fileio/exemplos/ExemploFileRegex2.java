package api.fileio.exemplos;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JDialog;

public class ExemploFileRegex2 {
	public static void main(String[] args) {
		FileDialog dialogo = new FileDialog((JDialog)null, "Selecione o Arquivo");
		dialogo.setFile("*");
		dialogo.setMode(FileDialog.LOAD);
		dialogo.setVisible(true);

		String nomeArquivo = dialogo.getDirectory() + dialogo.getFile();
		
		try (
				FileReader fr = new FileReader(nomeArquivo);
				BufferedReader in = new BufferedReader(fr);
				PrintWriter out = new PrintWriter(nomeArquivo+".out");
			) {

			Pattern ptrn = Pattern.compile("^([0-9]{2}:[0-9]{2}:[0-9]{2}).[0-9]{3} - abers - TID:b0081000 : .-. I/O (msg.*$)");
			
			String linha = in.readLine();
			while (linha != null) {
				//13:39:28.139 - abers - TID:b0081000 : <-- I/O msg received : connect 5001
			
				if(linha.matches(ptrn.pattern())) { // esta linha combina com o padrão
					Matcher mtx	= ptrn.matcher(linha);  
					mtx.find();                  // localiza os grupos demarcados na expressão regular
					
					if(mtx.groupCount() == 2) {
						// apresenta os textos dos grupos localizados
						out.println(mtx.group(1) + " - " + mtx.group(2)); 
					}					
				}
				
				linha = in.readLine();
			}
		} catch (IOException ex) {
			System.out.println("Falha na gravação do Arquivo");
		}
	}
}
