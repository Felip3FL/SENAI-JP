package br.exemplo.thread;

public class PingPong extends Thread {

	String palavra;
	long tempo;

	public PingPong(String palavra, long tempo) {
		this.palavra = palavra;
		this.tempo = tempo;
	}

	//Executa a Thred
	public void run() {
		 
		try {
			for (int i = 0; i < 5; i++) {
				System.out.println(palavra);
				Thread.sleep(tempo); //Pausa aqui at� o tempo acabar
			}
		} catch (InterruptedException erro1) {
			return; //Isso informa para o metodo que terminou a execu��o
		}

	}

	
	public static void main(String[] args) {

		//Esse Thread s�o executados simuntaneamente
		new PingPong("Ping", 1500).start(); //S�o impreso ao mesmo tempo
		new PingPong("Pong", 2000).start(); //N�o depende da classe acima para come�a executar

		System.out.println("Ver Thread");

	}

}
