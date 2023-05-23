package api.jdbc.exercicio02;

import java.time.LocalDate;

public class CadastroContratos {
	private Integer idContrato;
	private LocalDate data;
	private String numero;
	private String descricao;

	public Integer getidContrato() {
		return idContrato;
	}

	public void setidContrato(Integer id) {
		this.idContrato = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "id: " + idContrato + " data: " + data + " numero: " + numero
				+ " descricao: " + descricao;
	}
}
