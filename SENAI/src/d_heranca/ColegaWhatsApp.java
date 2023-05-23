package d_heranca;

public final class ColegaWhatsApp extends Colega {
	private String numTelefone;

	public String getNumTelefone() {
		return numTelefone;
	}

	public void setNumTelefone(String numTelefone) {
		this.numTelefone = numTelefone;
	}

	@Override
	public String toString() {
		return super.toString() +  " WhatsApp: " + numTelefone;
	}

}
