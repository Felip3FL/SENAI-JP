package br.exemplo.refinado;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Felipe Lima
 * 
 *         Aula 99 Recursividade
 */

public class Recursividade {

	//Metodo Recursivo
	//10 + (10-1) = 10 + (9) = 10 + (9 + 1) = 10 + (8).... até o 0
	public static int soma(int x) {
		if (x == 0) {
			return 0;
		} else {
			System.out.println(x);
			return x + soma(x - 1);
		}
	}

	//Metodo Recursivo
	//potencia(3, 4) = 3 * 3 * 3 * 3
	public static int potencia(int x, int e) {
		if (e == 1) {
			return x;
		} else {
			int y = x * potencia(x, e - 1);
			System.out.println(y);
			return y;
		}
	}

	//Metodo Recursivo
	public static void listar(Path path) {
		if (Files.isRegularFile(path)) {
			System.out.println(path.toAbsolutePath()); //Imprimir Arquivos
		} else {
			String s = "\n"+path.toAbsolutePath();
			System.err.println(s.toUpperCase()); //Imprimir pasta

			try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
				for (Path p : stream) {

					listar(p); //Imprimir todos diretoriose sub-diretorios
				}
			} catch (Exception erro1) {
			}
		}

	}

	public static void main(String[] args) {
		System.out.println("Soma de 10 = " + soma(10) + "\n");
		System.out.println("Potencia de 3^4 = " + potencia(3, 4) + "\n");

		//Lista todo conteudo do diretorio
		listar(Paths.get("C:/java/oo"));
	}

}
