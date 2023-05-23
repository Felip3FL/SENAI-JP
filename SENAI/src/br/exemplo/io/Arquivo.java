package br.exemplo.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Arquivo {

	//IOException: caso não der errado a criacao do diretorio
	public static void main(String[] args) throws IOException {

		//Path = Caminho JAVA7
		Path caminho = Paths.get("C:/Users/Felipe Lima/Documents/Desenvolvimento/Eclipse/Exemplos Codigos/files/Texto.txt");
		
		System.out.println("Caminho absoluto: "+caminho.toAbsolutePath());
		System.out.println("Caminho pai: "+caminho.getParent());
		System.out.println("Raiz: "+caminho.getRoot());
		System.out.println("Nome: "+caminho.getFileName());
		
		
		// CRIAÇÃO DE DIRETORIOS
		Files.createDirectories(caminho.getParent());
		
		
		
		// ESCREVER E LER ARQUIVOS
		
		byte[] texto = "Meus Texto".getBytes();
		Files.write(caminho, texto); //Cria, limpa e escreve
		
		
		byte[] retorno = Files.readAllBytes(caminho);//Imprimir conteudo do arquivo
		System.out.println(new String(retorno));
		
	}

}
