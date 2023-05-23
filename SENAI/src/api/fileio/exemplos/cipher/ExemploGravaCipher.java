package api.fileio.exemplos.cipher;

import java.awt.FileDialog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.swing.JDialog;

public class ExemploGravaCipher {
	public static void main(String args[]) {		
		FileDialog dialogo = new FileDialog((JDialog)null, "Selecione o Arquivo de Destino");
		dialogo.setFile("*.cph");
		dialogo.setMode(FileDialog.SAVE);
		dialogo.setVisible(true);

		String nomeArquivoDestino = dialogo.getDirectory() + dialogo.getFile();
		String chave = nomeArquivoDestino.replace(".cph", ".des");
		
		try {
			// Gera chaves de encriptação utilizando o algoritmo DES
			KeyGenerator kg = KeyGenerator.getInstance("DES");
			kg.init(new SecureRandom());
			SecretKey key = kg.generateKey();
			SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
			Class<?> spec = Class.forName("javax.crypto.spec.DESKeySpec");
			DESKeySpec ks = (DESKeySpec) skf.getKeySpec(key, spec);

			// Inicializa o Encriptador com a chave de encriptação
			Cipher c = Cipher.getInstance("DES/CFB8/NoPadding");
			c.init(Cipher.ENCRYPT_MODE, key);
			
			// Criptografa o arquivo utilizando a chave de encriptação
			try (
					ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(chave)));
					CipherOutputStream cos = new CipherOutputStream(new FileOutputStream(new File(nomeArquivoDestino)), c);
					PrintWriter pw = new PrintWriter(new OutputStreamWriter(cos));
					){
				pw.println("Mensagem secreta");

				// Armazena as chaves no arquivo com extensão .key
				oos.writeObject(ks.getKey());
				oos.writeObject(c.getIV());
			} 
		} catch (ClassNotFoundException | IOException | InvalidKeySpecException | InvalidKeyException 
				| NoSuchAlgorithmException | NoSuchPaddingException  ex) {
			ex.printStackTrace();
		}
	}
}