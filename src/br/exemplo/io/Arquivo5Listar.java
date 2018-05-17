package br.exemplo.io;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Arquivo5Listar {

	public static void main(String[] args) throws IOException {

		/*
		 * FileSystems é o sistema de direotiro de cada sistema operacional,
		 * isso ajuda a trabalha mais rapido;
		 * getDefault - para recurerar diretorio raiz;
		 * getRootDirectories - diretorio raiz Iterable<Path> -
		 * Grava o caminho do diretorios raiz;
		 */
		Iterable<Path> teste = FileSystems.getDefault().getRootDirectories();

		for (Path path : teste) {
			//Diretorio raiz:
			System.out.println(path);
		}

		/////////  LISTAR O CONTEUDO DE UM DIRETORIO //////////
		
		Path pasta = Paths.get("C:/Users/Felipe Lima/Documents/Desenvolvimento/Eclipse/Exemplos Codigos/files/");
		
		/*
		 * Para visualiza lista de diretorio/arquivos dentro de uma certa pasta
		 * Files.newDirectoryStream  - retorna um objeto do tipo directory
		 * 
		 */
		try(DirectoryStream<Path> stream = Files.newDirectoryStream(pasta)){
			
			for (Path path : stream) {
				System.out.println(path.getFileName());
			}
			
		}catch(IOException | DirectoryIteratorException erro1){
			
			erro1.printStackTrace();
			
		}
		
		
		///////// MOSTRA UNIDADES DO SISTEMA  //////////
		
		FileSystem unidade = FileSystems.getDefault();
		for(FileStore store : unidade.getFileStores()){
			System.out.println("\nUnidade: "+store.toString());
			System.out.println("Espaço: "+ store.getTotalSpace());
			System.out.println("Disponível: "+ store.getUsableSpace());
			System.out.println("Ultilizada: "+ (store.getTotalSpace() - store.getUsableSpace()));
			
		}
				
	}

}
