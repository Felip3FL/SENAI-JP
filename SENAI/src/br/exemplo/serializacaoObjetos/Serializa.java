package br.exemplo.serializacaoObjetos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class Serializa {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		/*
		 * Serialização salva o objeto e suas variaveis de stancia
		 */

		String[] nomes = { "Felipe", "Fernando", "Joao" };

		////////// ESCRITA DE OBJETO //////////

		FileOutputStream fos = new FileOutputStream(
				"C:/Users/Felipe Lima/Documents/Desenvolvimento/Eclipse/Exemplos Codigos/files/objeto.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(nomes);
		oos.close();

		////////// LEITURA DO OBJETO //////////

		//Endereço que desejo ler
		FileInputStream fis = new FileInputStream("C:/Users/Felipe Lima/Documents/Desenvolvimento/Eclipse/Exemplos Codigos/files/objeto.ser");

		//Ler o arquivo com objetos serializados dentro
		ObjectInputStream ois = new ObjectInputStream(fis);
		String[] nomes1 = (String[]) ois.readObject();

		//Fechar a conexao
		ois.close();

		//Apresenta a array do arquivo lido
		System.out.println(Arrays.toString(nomes1));

	}

}
