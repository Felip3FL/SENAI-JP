package br.exemplo.anotacoes;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Felipe Lima
 * 
 * Aula 103 - Reflection
 * 
 */

public class Reflexao {
	
	//ClassNotFoundException - não encontra a classe na relação de classe q conhece
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		String nome = "br.exemplo.metodos.Conta";
		
		//Informa o nome da classe, que deseja carregar
		Class classe = Class.forName(nome);
		System.out.println("Nome da Classe: "+classe.getSimpleName());
		
		//Retorna uma array de campos de variaveis publicas
		Field[] f = classe.getFields();
		System.out.println("\nVariaveis Publicas:");
		for(Field field : f){ 
			System.out.println(field);
		}
		
		//Retorna uma array de todos os metodos
		Method[] m = classe.getDeclaredMethods();
		System.out.println("\nTodos os metodos de Conta:");
		for (Method method : m) {
			System.out.println(method.getName());
		}
		
		//Retorna uma array de todos os contrutores e seus parametros
		Constructor[] c = classe.getConstructors();
		System.out.println("\nTodos os contrutores de Conta:");
		for (Constructor constructor : c) {
			System.out.println(constructor);
		}
		
		Object o = classe.newInstance();
		Method md = classe.getMethod("setDepositar", double.class);
		//Method me = classe.getMethod("getSaldo");
		md.invoke(o, 120);
		//me.invoke(o);
		
		
		
	}
	
}
