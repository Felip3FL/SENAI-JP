package objeto.exemplos._interface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TesteDoList6 {
	static List<Amigo> lista = new ArrayList<>();

	public static void main(String[] args) {
		
		Amigo a = new Amigo();
		a.setNome("Beltrano");
		a.setEmail("bel@uol.com.br");
		a.setIdade(15);
		
		Amigo b = new Amigo("Fulano", "fufu@gmail.com");
		b.setNome(b.getNome() + " de Tal");
		b.setIdade(22);
	
		Amigo c = new Amigo("Beltrano", "bel@uol.com.br", 11);
		
		lista.add(b);
		lista.add(a);
		lista.add(c);
		
		Collections.sort(lista,  Comparator.comparing(Amigo::getIdade).reversed());
		
		for (Amigo amigo : lista) {
			System.out.println(amigo);
		}

		System.out.println("\n--------------------------------\n");

		Collections.sort(lista, Comparator.comparing(Amigo::getNome).thenComparing(Amigo::getIdade));
		
		for (Amigo amigo : lista) {
			System.out.println(amigo);
		}
	}
}
