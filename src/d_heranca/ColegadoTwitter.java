package d_heranca;

public class ColegadoTwitter extends Colega {
	private String twitter;

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	@Override
	public String toString() {
		return super.toString() + " Twitter: " + twitter;
	}
	
}
