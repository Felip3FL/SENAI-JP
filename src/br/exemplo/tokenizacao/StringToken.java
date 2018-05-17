package br.exemplo.tokenizacao;

public class StringToken {

	public static void main(String[] args) {

		
		String texto = "XHTML; CSS; JavaScript; Jquery; Java";
		String[] tokens = texto.split(";");
		System.out.println(tokens.length + " tokens");
		
		//IMPRIMIR TOKENS
		
		for (String token : tokens){
			System.out.println(token);
		}

	}

}
