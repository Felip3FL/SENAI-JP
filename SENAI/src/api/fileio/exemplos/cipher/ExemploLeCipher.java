package api.fileio.exemplos.cipher;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.swing.JDialog;

public class ExemploLeCipher {
	public static void main(String args[]) {
		FileDialog dialogo = new FileDialog((JDialog)null, "Selecione o Arquivo");
		dialogo.setFile("*.cph");
		dialogo.setMode(FileDialog.LOAD);
		dialogo.setVisible(true);

		String nomeArquivo = dialogo.getDirectory() + dialogo.getFile();
		String chave = nomeArquivo.replace(".cph", ".des");
		
		try (
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(chave)));
			) {
			//Lê a chave de desencriptação
			DESKeySpec ks = new DESKeySpec((byte[]) ois.readObject());
			SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
			SecretKey key = skf.generateSecret(ks);
			
			// Inicializa o cifrador com o algoritmo DES
			Cipher c = Cipher.getInstance("DES/CFB8/NoPadding");
			c.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec((byte[]) ois.readObject()));
			
			// Dessencripta o arquivo e mostra o conteúdo
			try (
					CipherInputStream cis = new CipherInputStream(new FileInputStream(new File(nomeArquivo)), c);
					BufferedReader br = new BufferedReader(new InputStreamReader(cis));
				) {
				for(String linha;(linha = br.readLine()) != null;) {
					System.out.println(linha);
				}
			}
		} catch (ClassNotFoundException | IOException | InvalidKeySpecException | InvalidKeyException 
				| NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException ex) {
			ex.printStackTrace();
		}
	}
}