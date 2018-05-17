package br.exemplo.anotacoes;

import java.io.Serializable;

@Cabecalho(
	instituicao = "NomeEmpresa", 
	projeto = "Ponte", 
	dataCriacao = "04/02/2013", 
	criador = "Felipe", 
	revisao = 2
)

@SuppressWarnings("serial") //Ignorar a notifica��o de Version ou outros...
public class Anotacao implements Serializable {
	 
	@SuppressWarnings("unused") //Ignorar a notifica��o de variavel n�o ultilizada
	private int x; //N�o ultilizei
	
	@Deprecated //Essa classe vai ser implementada no futuro
	public void anotar(){}
	
	@Override //Informa que sobre-escreveu um dos metodos da classe 
	public String toString(){
		return null;
	}
	
}
