package br.exemplo.thread.notifyAll;

import br.exemplo.anotacoes.Cabecalho;
import br.exemplo.anotacoes.ErrosCorrigidos;

@Cabecalho(
	instituicao = "NomeEmpresa", 
	projeto = "Ponte", 
	dataCriacao = "04/02/2013", 
	criador = "Felipe", 
	revisao = 2
)

/**
 * Uma <code>Ponte</code> representa o elo de liga��o entre objetos Produtores e
 * Consumidores de Informa��es. Os <i>Produtores</i> utilizam as Ponres para
 * gravar informa��es e compartilhar essas informa��es com os Consumidores que
 * l�em esses dados da Ponte para fazer o processamento
 * 
 * @author Felipe Lima
 * @version 1.3
 * @since 1.0
 * 
 * @see PonteNaoSincronizada
 * @see PonteSincronizada
 */

@ErrosCorrigidos(erros = {"0001","0002"})
//@ErrosCorrigidos("0001") //OPCAO 2
 
public interface Ponte {

	/**
	 * Armazena o valor informado na ponte. Geralmente ser� chamado pelas
	 * classes produtoras de dados.
	 * 
	 * @param valor
	 * @throws InterruptedException
	 * 
	 */
	public void set(int valor) throws InterruptedException;

	/**
	 * Recupera a informa��o armazenada na Ponte. Esse m�todo ser� chamado pelas
	 * Cosumidoras de dados.
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public int get() throws InterruptedException;

}
