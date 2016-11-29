package fundamentos.resposta;

import static fundamentos.resposta.Utilitarios.escrevaL;
import static fundamentos.resposta.Utilitarios.leInteiro;
import static fundamentos.resposta.Utilitarios.leReal;

public class Ex01b {
	public static void main(String[] args) {
		double total = 0;
		
		for (int i = 0; i < 3; i++) {
			int quat = leInteiro("Informe a Quantidade ", i+1);
			double val = leReal("Informe o Valor ", i+ 1);
			total += quat * val;
		}
				
		escrevaL("O Total é : ", total);
	}
}
