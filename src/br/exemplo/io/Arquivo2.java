package br.exemplo.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Arquivo2 {

	//IOException pode encontra erros ao tenta grava, ler....
	public static void main(String[] args) throws IOException {

		//Caminho do arquivos
		Path caminho = Paths
				.get("C:/Users/Felipe Lima/Documents/Desenvolvimento/Eclipse/Exemplos Codigos/files/Texto.txt");

		//StandardCharsets é a codificação do arquivo
		Charset utf8 = StandardCharsets.UTF_8;

		//BufferedWriter é ultilizado para grandes arquivos de text
		try (BufferedWriter w = Files.newBufferedWriter(caminho, utf8)) {
			//Esse metodo volta o objeto do tipo BufferedWriter

			//Escrever no arquivo
			w.write("Outro TEXTO\n");
			w.write("Outros Textos\n");

			/*
			 * //Grava os arquivos que esta no BufferedWriter, grava fisicamente
			 * os arquivos 
			 * w.flush();
			 */

		} catch (IOException erro1) {
			erro1.printStackTrace();
		} finally {
			/*
			 * No JAVA 7, não é mas necessario fechar a conexao if (w != null){
			 * //Se w foi modificado... então... 
			 * //Fechar a conexao com o arquivos 
			 * w.close(); }
			 */
		}
		
		
		///////// LEITURA //////////
		
		try(BufferedReader leitura = Files.newBufferedReader(caminho, utf8)){
			String linha = null;
			
			//Retorna a linha desse arquivos
			while((linha = leitura.readLine()) != null){
				System.out.println(linha);
			}
			
			
		}catch (IOException erro2){
			erro2.printStackTrace();
		}
		
		
	}

}
