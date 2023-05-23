package br.exemplo.serializacaoObjetos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import br.exemplo.metodos.Conta;

public class GravaConta {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		/*
		 * Serialização salva o objeto e suas variaveis de stancia
		 * 
		 */
		
		Conta conta1 = new Conta("Felipe", 111.1);
		Conta conta2 = new Conta("Roberio", 112.1);
		Conta conta3 = new Conta("Joao", 113.1);
		
		
		////////// ESCRITA DE OBJETO //////////
		
		FileOutputStream fos = new FileOutputStream("C:/Users/Felipe Lima/Documents/Desenvolvimento/Eclipse/Exemplos Codigos/files/objeto.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(conta1);
		oos.writeObject(conta2);
		oos.writeObject(conta3);
		
		oos.close();
		
		
		
		//////////ESCRITA DE OBJETO //////////
		
		//Endereço que desejo ler
		FileInputStream fis = new FileInputStream("C:/Users/Felipe Lima/Documents/Desenvolvimento/Eclipse/Exemplos Codigos/files/objeto.ser");
		
		//Ler o arquivo com objetos serializados dentro
		ObjectInputStream ois = new ObjectInputStream(fis);
		Conta c1 = (Conta) ois.readObject();
		Conta c2 = (Conta) ois.readObject();
		Conta c3 = (Conta) ois.readObject();
		
		//Fechar a conexao
		ois.close();
		
		//Apresenta a array do arquivo lido
		c1.getSaldo();
		c2.getSaldo();
		c3.getSaldo();
		
		
	}

}
