package br.exemplo.anotacoes;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Documented //Anota��es aparecer na documenta��o
@Target({ElementType.TYPE, ElementType.METHOD})

public @interface ErrosCorrigidos {

	String[] erros();
	//String[] value(); //OPCAO 2
	
}
