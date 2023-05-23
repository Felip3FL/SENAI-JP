package br.exemplo.anotacoes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

//Defini que unico elemento que pode receber essa anotação, que faz referencia a uma classe
@Target(ElementType.TYPE) 

public @interface Cabecalho {

	String instituicao();
	String projeto();
	String dataCriacao();
	String criador();
	int revisao() default 1;//Valor default(valor de inicialização) é 1
	
}
