package br.exemplo.regularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressaoRegular {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String padrao = "Java";
		
		boolean validacao = "Java".matches(padrao);
		System.out.println(validacao);

		//(i?) ignora a caixa alta
		validacao = "Java".matches("(?i)java");
		System.out.println(validacao);
		
		/*METACARACTERES
		 
		 .qualquer caracter	
		 \d digitos			[0-9]
		 \D n�o � digito	[^0-9]
		 \s espa�os			[\t\n\x0b\f\r]
		 \S n�o � espa�o	[^\s]
		 \w letra			[a-zA-Z_0-9]
		 \W n�o � letra		[]
		 
		 */
		
		validacao = "@".matches(".");
		System.out.println("@ . \t"+validacao);
		
		validacao = "2".matches("\\d");
		System.out.println("2 \\d \t"+validacao);
		
		validacao = "A".matches("\\w");
		System.out.println("A \\w \t"+validacao);
		
		validacao = " ".matches("\\s");
		System.out.println("  \\s \t"+validacao);
		
		validacao = "Pi".matches("..");
		System.out.println("Pi .. \t"+validacao);
		
		validacao = "Pie".matches("...");
		System.out.println("Pie ...\t"+validacao);

		validacao = "21".matches("\\d\\d");
		System.out.println("21 \\d\\d "+validacao);		
		
		//VALIDA UM CEP
		String cep = "\\d\\d\\d\\d\\d-\\d\\d\\d";
		validacao = "08190-400".matches(cep);
		System.out.println("Cep 08190-400 � valido? "+validacao);
		
		
		
		/*QUANTIFICADORES
		 
		 X{n}		X, exatamente n vezes
		 X{n,}		X, pelo menos n vezes
		 X{n, m}	X, pelo menos n mas nn�o mais do que m vezes
		 X?			X, 0 ou 1 vez
		 X*			X, 0 ou + vezes
		 X+			X, 1 ou + vezes
		 
		 */
		
		validacao = "21".matches("\\d{2}");
		System.out.println("\n 21 \\d{2} \t"+validacao);
		
		validacao = "212".matches("\\d{2,}"); //N�o pode haver mesno de 2
		System.out.println("212 \\d{2,} \t"+validacao);
		
		validacao = "21231".matches("\\d{2,5}"); //>= 2 e <= 5
		System.out.println("21231 \\d{2,5} \t"+validacao);
		
		validacao = "a".matches(".?");//0-1 
		System.out.println("a .? \t\t"+validacao);
		
		validacao = "aasd".matches(".*");//0 ou + 
		System.out.println("aasd .* \t"+validacao);

		validacao = "08190-400".matches("\\d{5}-\\d{3}"); 
		System.out.println("Cep 08190-400 � valido? "+validacao);	
		
		validacao = "12/05/2013".matches("\\d{2}/\\d{2}/\\d{4}"); 
		System.out.println("Data 12/05/2013 � valido? "+validacao);
		
		
		
		/*METACARACTER DE FRONTEIRA
		 * 
		  ^ inicia
		  $ finaliza
		  | ou
		   
		 */
		
		validacao = "felip3.fl@gmail.com".matches("^felip3.*");
		System.out.println("felip3.fl@gmail.com come�a com felip3? "+validacao);
		
		validacao = "felip3.fl@gmail.com".matches(".*com");
		System.out.println("felip3.fl@gmail.com � um email valido (.com)? "+validacao);
		
		validacao = "felip3.fl@gmail.com".matches(".*@.*");
		System.out.println("felip3.fl@gmail.com � um email valido? "+validacao);
		
		validacao = "Felipe Silva Lima".matches("^Felipe.*Lima$");
		System.out.println("Inicia Felipe e termina com Lima? "+validacao);
		
		validacao = "SIM".matches("SIM|NAO");
		System.out.println("� sim ou n�o? "+validacao);
		
		
		/*AGRUPADORES
		 [...]				Agruoamento
		 [a-z]				Alcance
		 [a-e]				Uni�o
		 [a-z&&[aeiou]]		Interse��o
		 [�bc]				Exe��o
		 [a-z&&[^m-p]]		Subtra��o
		 \x 				Fuga Literal
		
		 * */
		
		validacao = "a".matches("[a-z]");
		System.out.println("De A a Z (caixa baixa)? "+validacao);
		
		validacao = "2".matches("[0-3]");
		System.out.println("De 0 a 3? "+validacao);
		
		validacao = "Felipe".matches("[fF]elipe");
		System.out.println("� Felipe? "+validacao);
		
		validacao = "Felipe".matches("[A-Z][a-zA-Z]*");
		System.out.println("Felipe � um nome valido? "+validacao);
		
		validacao = "alho".matches("[^abc]lho");
		System.out.println("N�o pode come�a com abc (alho) =  "+validacao);
		
		validacao = "Felipi".matches("F[ei]lip[ei]");
		System.out.println("Filipi ? "+validacao);
		
		validacao = "felip3.fl@gmail.com".matches("\\ww+@\\w+\\.\\w{2,3}");
		System.out.println("felip3.fl@gmail.com � email valido? "+validacao);
		
		String doce = "Qual � o Doce mais doCe que o doce?";
		Matcher matcher = Pattern.compile("(?i)doce").matcher(doce);
		while (matcher.find()){
			System.out.println(matcher.group());
		}
		
		/*SUBTITUI��O
		 
		  
		 
		  
		 */
		
		String r = doce.replaceAll("(?i)doce","SALGADO");
		System.out.println(r);
		
		r = doce.replaceAll("[dD][aeiuo]","XX");
		System.out.println(r);
		
		r = "Tabulando este texto".replaceAll("\\s", "\t");
		System.out.println(r);
		
		
		String url = "www.ti.com.br/clientes-2011.html";
		String re = "www.ti.com.br/\\w{2,}-\\d{4}.html";
		validacao = url.matches(re);
		re = "(www.ti.com.br)/(\\w{2,})-(\\d{4}).html";
		r = url.replaceAll(re, "http://$1/$3/$2.jsp");
		System.out.println(re);
		System.out.println(url);
		
	}

}
