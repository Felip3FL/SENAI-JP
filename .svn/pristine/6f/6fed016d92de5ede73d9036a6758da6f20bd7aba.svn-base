package api.fileio.exemplos.serializacao;

import java.io.Serializable;

public class Contrato implements Serializable  {
	private static final long serialVersionUID = 2051484698073827703L;
	private int numero; 
	private String assunto = "";
	private Integer codigo; 

	public Contrato() {
	}

	public Contrato(int numero) {
		super();
		this.numero = numero;
	}

	public Contrato(int numero, String assunto) {
		this.numero = numero;
		this.assunto = assunto;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	@Override
	public String toString() {
		return "numero: " + numero + "   assunto: " + assunto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assunto == null) ? 0 : assunto.hashCode());
		result = prime * result + numero;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contrato other = (Contrato) obj;
		if (assunto == null) {
			if (other.assunto != null)
				return false;
		} else if (!assunto.equals(other.assunto))
			return false;
		if (numero != other.numero)
			return false;
		return true;
	}

}
