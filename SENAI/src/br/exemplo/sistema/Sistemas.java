package br.exemplo.sistema;

import java.io.IOException;

public class Sistemas {
	public static void main(String[] args) throws IOException {
		
		//Properties p = System.getProperties();
		//System.out.println(p.getProperty("Versão Java: "+"java.version"+"\n\n"));
		//p.setProperty("br.exemplo.version", "1.0.0");//Definindo propriedade de nosso programa
		
		//Mostrar todas as propriedade do projeto e sistema operacional
		/*Set<Object> pk = p.keySet();//Coleção sem duplicidade das chaves
		for (Object key : pk) {
			System.out.println(key + " = " + p.get(key));
		}*/
		
		//recuperar a senha de forma segura, sem que fica expostar
		/*Console c = System.console();
		System.out.print("Usuario: ");
		String usuario;
		usuario = c.readLine();
		System.out.print("Senha: ");
		char[] pass = c.readPassword();
		System.out.println("Usuario= "+user+" Senha="+pass);*/
		
		Runtime.getRuntime().exec("calc");
		
	}
}
