package br.exemplo.redes;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ConselhoServidor {

	public static void main(String[] args) throws Exception {
		
		@SuppressWarnings("resource")
		ServerSocket server= new ServerSocket(5000);
		System.out.println("Servidor inicializado");
		//Ficar rodando...
		while(true){
			//Ficar aguardando a solicitação de  cliente
			Socket socket = server.accept();
			
			//Mensagem ao cliente
			try (PrintWriter w = new PrintWriter(socket.getOutputStream())){
				w.println("Aprenda java e seja contratado");	
			}
		}
		
	}
	
}
