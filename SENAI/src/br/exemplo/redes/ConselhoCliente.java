package br.exemplo.redes;

import java.net.Socket;
import java.util.Scanner;

public class ConselhoCliente {

	public static void main(String[] args) throws Exception {

		//De 0 - 1013 são portas reservadas
		@SuppressWarnings("resource")
		Socket socket = new Socket("127.0.0.1", 5000);

		//Recuperar mensagem reebida
		Scanner s = new Scanner(socket.getInputStream());
		//s.nextLine();//Toda vez que uma mensagem chegar, ele recebe a mensagem
		System.out.println("Mensagem: " + s.nextLine());
		s.close();//Fechar o scanner
		
	}

}
