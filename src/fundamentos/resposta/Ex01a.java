package fundamentos.resposta;

public class Ex01a {
	public static void main(String[] args) {
		
		int quat1 = Utilitarios.leInteiro("Informe a Quantidade 1");
		double val1 = Utilitarios.leReal("Informe o Valor 1");

		int quat2 = Utilitarios.leInteiro("Informe a Quantidade 2");
		double val2 = Utilitarios.leReal("Informe o Valor 2");
		
		int quat3 = Utilitarios.leInteiro("Informe a Quantidade 3");
		double val3 = Utilitarios.leReal("Informe o Valor 3");
		
		double total = quat1 * val1 + quat2 * val2 + quat3 + val3;
		
		Utilitarios.escrevaL("O Total é : ", total);
	}
}
