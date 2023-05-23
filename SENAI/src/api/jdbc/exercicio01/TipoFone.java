package api.jdbc.exercicio01;

public enum TipoFone {
	SELECIONE {
		@Override
		public String toString() {
			return "-- Selecione --";
		}
	},
	CELULAR,
	COMERCIAL,
	FAX,
	RECADO,
	RESIDENCIAL;
}
