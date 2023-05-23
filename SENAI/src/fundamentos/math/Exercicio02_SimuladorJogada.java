package fundamentos.math;

import java.util.Random;

public class Exercicio02_SimuladorJogada {
	Random random = new Random();
	
	public int getNumerosDeDadosAleatorio(){
		return random.nextInt(6) + 1;
	}
	
}
