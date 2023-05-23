package fundamentos.math.exemplos;

import java.util.Random;

public class NumerosAleatorios {
	public static void main(String[] args) {
//		for(int i =0;i < 5;i++) 
//			System.out.println((int)Math.ceil(Math.random()*5));

		Random rdn = new Random();
		for(int i =0;i < 5;i++) {
			 System.out.println(rdn.nextInt(10)+1);
			 System.out.println(rdn.nextBoolean());
		}
	}
}
