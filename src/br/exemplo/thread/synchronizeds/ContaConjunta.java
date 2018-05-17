package br.exemplo.thread.synchronizeds;

public class ContaConjunta {

	private int saldo = 100;

	public int getSaldo() {
		return saldo;
	}

	//synchronized mantem as thread sem inteferir uma na outra
	//Ele vai ser bloqueado até que esse seja terminado
	public synchronized void sacar(int valor, String cliente) {

		if (saldo >= valor) {
			int saldoOriginal = saldo;
			System.out.println(cliente + " vai sacar");
			try {
				System.out.println(cliente+" esperando");
				Thread.sleep(1000);//aguardando processamento
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
			saldo -= valor;
			System.out.println(cliente+" sacou "+valor+" [Saldo Original= "+saldoOriginal+", Saldo Final= "+saldo+"]");
			
		} else {
			System.out.println(cliente+", saldo insuficiente");
		}

	}
	
}
