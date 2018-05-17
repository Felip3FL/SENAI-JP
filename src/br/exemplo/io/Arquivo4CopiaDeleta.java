package br.exemplo.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Arquivo4CopiaDeleta {

	public static void main(String[] args) throws IOException {

	/*	Path caminho = Paths.get("C:/Users/Felipe Lima/Documents/Desenvolvimento/Eclipse/Exemplos Codigos/files/Texto.txt");
		
		System.out.println("Esse caminho existe? "+Files.exists(caminho));
		System.out.println("Esse caminho � um diretorio? "+Files.isDirectory(caminho));
		System.out.println("� um arquivo regular (Arquivo comprensivel)? "+Files.isRegularFile(caminho));
		System.out.println("Pode ser lido? "+Files.isReadable(caminho));
		System.out.println("Pode ser executado? "+Files.isExecutable(caminho));
		System.out.println("Qual � o tamanho? "+Files.size(caminho));
		System.out.println("Ultima vez modificado: "+Files.getLastModifiedTime(caminho));
		System.out.println("Domo do arquivo: "+Files.getOwner(caminho));
		System.out.println("Qual � o tipo do arquivo: "+Files.probeContentType(caminho));
		
		*/
		
		////////// DELETE //////////
		
		//Files.delete(caminho); //Consegue deleta diretorio se tiver vazio
		//Files.deleteIfExists(caminho); //S� deleta se o diretorio existir, caso fracasa, n�o lanca Exception
		
		
		
		
		////////// CREATE //////////
		
		Path caminho = Paths.get("C:/Users/Felipe Lima/Documents/Desenvolvimento/Eclipse/Exemplos Codigos/files/Fonte.txt");
		Files.deleteIfExists(caminho);//Se ja exiti, delete
		Files.createFile(caminho); //Criando o arquivo
		Files.write(caminho, "Meu texto".getBytes());
		
		
		////////// COPY //////////
		
		Path copia = Paths.get("C:/Users/Felipe Lima/Documents/Desenvolvimento/Eclipse/Exemplos Codigos/files/Copia.txt");
		Files.copy(caminho, copia, StandardCopyOption.REPLACE_EXISTING);
		

		
		////////// MOVE //////////		
		
		Path mover = Paths.get("C:/Users/Felipe Lima/Documents/Desenvolvimento/Eclipse/Exemplos Codigos/files/move/Copia.txt");
		Files.createDirectories(mover.getParent());
		Files.move(copia, mover, StandardCopyOption.REPLACE_EXISTING);
		
		
		
	}

}
