package fundamentos.math.exercicios;

import java.util.Random;

public class Arredondamentos {
	public static void main(String[] args) {
		
		System.out.println("----- Math -----");
		for (int i = 0; i < 5; i++) {
			System.out.println((int)Math.ceil(Math.random()*100));
		}
		
		System.out.println("--- Random ---");
		
		Random r = new Random();
		for (int i = 0; i < 5; i++) {
			System.out.println(r.nextInt(100)+1);
		}
	}
}
