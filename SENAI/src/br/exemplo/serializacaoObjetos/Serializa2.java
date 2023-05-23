package br.exemplo.serializacaoObjetos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;

import br.exemplo.metodos.Conta;

public class Serializa2 {

	public void armazenarContas(ArrayList<Conta> contas) throws IOException{

		try(FileOutputStream fos = new FileOutputStream("C:/Users/Felipe Lima/Documents/Desenvolvimento/Eclipse/Exemplos Codigos/files/contas.ser")){
			try(ObjectOutputStream oos = new ObjectOutputStream(fos)){
				oos.writeObject(contas);
			}
		}
		}

	@SuppressWarnings("unchecked")
	public ArrayList<Conta> recuperarContas() throws IOException, ClassNotFoundException {

		try (FileInputStream fis = new FileInputStream("C:/Users/Felipe Lima/Documents/Desenvolvimento/Eclipse/Exemplos Codigos/files/contas.ser")) {
			try (ObjectInputStream ois = new ObjectInputStream(fis)) {
				return (ArrayList<Conta>)ois.readObject();
			}
		}
	}


	public static void main(String[] args) throws IOException, ClassNotFoundException {

		ArrayList<Conta> contas = new ArrayList<>();

		contas.add(new Conta("Felipe", 10.000));
		contas.add(new Conta("Lawrence", 56.11));
		contas.add(new Conta("Sandra", 123.45));
		contas.add(new Conta("Beatriz", 123.50));

		Serializa2 operacao = new Serializa2();
		operacao.armazenarContas(contas);
		ArrayList<Conta> contas2 = operacao.recuperarContas();
		for (Conta conta : contas2) {
			conta.getSaldo();
		}

	}

}
