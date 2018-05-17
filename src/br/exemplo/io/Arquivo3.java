package br.exemplo.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import br.exemplo.metodos.Conta;

public class Arquivo3 {
	
	private Path caminho = Paths.get("C:/Users/Felipe Lima/Documents/Desenvolvimento/Eclipse/Exemplos Codigos/src/files/Conta.txt");
	private Charset utf8 = StandardCharsets.UTF_8;
	
	public void armazenarContas(ArrayList<Conta> contas) throws IOException{

		
		//Inicializa um BufferedWriter
		try(BufferedWriter escrever = Files.newBufferedWriter(caminho, utf8)){
			for (Conta conta : contas){
				escrever.write((int) conta.getSaldo());
			}
		}
	}
	
	
	public ArrayList<Conta> recuperarContas () throws IOException{
		ArrayList<Conta> contas = new ArrayList<>();
		try(BufferedReader leitura = Files.newBufferedReader(caminho, utf8)){
			String linha = null;
			while((linha = leitura.readLine())!= null){
				String[] t = linha.split(";");
				System.out.println(t[0]+t[1]);
				Conta conta = new Conta(t[0], Double.parseDouble(t[1]));
				contas.add(conta);
			}
		}
		return contas;
	}
	
	
	public static void main(String[] args) throws IOException {

		ArrayList<Conta> contas = new ArrayList<>();
		
		contas.add(new Conta("Felipe",10.000));
		contas.add(new Conta("Lawrence",56.11));
		contas.add(new Conta("Sandra",123.45));
		contas.add(new Conta("Beatriz",123.50));
			
		Arquivo3 operacao = new Arquivo3();
		//operacao.armazenarContas(contas);
		ArrayList<Conta> contas2 = operacao.recuperarContas();
		for (Conta conta : contas2) {
			conta.getSaldo();
		}
		
		
		

	}
	


}
