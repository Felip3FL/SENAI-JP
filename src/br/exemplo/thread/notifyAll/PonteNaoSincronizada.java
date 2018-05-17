package br.exemplo.thread.notifyAll;

public class PonteNaoSincronizada implements Ponte {

	//representa valor armazenado nessa ponte
	private int valor = -1;
	
	@Override
	public void set(int valor) throws InterruptedException {
		System.out.print("Produziu "+valor);
		this.valor = valor;
		
	}

	@Override
	public int get() throws InterruptedException {
		System.err.print("Consumiu "+valor);
		return valor;
	}

}
