package api.fileio.resposta.cargaPesada;

import java.io.Serializable;


public class Veiculo implements Serializable {
	private static final long serialVersionUID = 540L;
	private String placa;
	private String hora;
	private String motorista;

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getMotorista() {
		return motorista;
	}

	public void setMotorista(String motorista) {
		this.motorista = motorista;
	}

	@Override
	public String toString() {
		return "placa: " + placa + " hora: " + hora + " motorista: " + motorista;
	}
}
