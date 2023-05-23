package br.exemplo.thread.notifyAll;

public class PonteSincronizada implements Ponte{

	private int valor = -1;
	private boolean ocupada = false;
	
	@Override
	//synchronized para executar uma vez de cada
	public synchronized void set(int valor) throws InterruptedException {
		
		while(ocupada){
			System.out.println("Ponte cheia. Produtor aguarda.");
			wait();
		}
		
		System.out.print("Produziu "+valor);
		this.valor = valor;
		
		ocupada = true;
		notifyAll();
	}

	@Override
	//synchronized para executar uma vez de cada	
	public synchronized int get() throws InterruptedException {
		while(!ocupada){
			System.out.print("Ponte vazia. Cosumidor aguarda\n");
			wait();//Pedir para metodo aguarda até que a ponte esteja ocupada
		}
		System.err.print("Consumiu "+valor);
		ocupada = false;
		notifyAll();
		return valor;
	}
	
	

}
