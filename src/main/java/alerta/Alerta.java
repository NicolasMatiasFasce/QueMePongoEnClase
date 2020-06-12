package alerta;

public enum Alerta {

	TORMENTA("Va a haber tormenta, llevate un paraguas!"),
	GRANIZO("Va a haber granizo, evita salir en auto!");

	Alerta(String notificacion) {
		this.notificacion = notificacion;
	}

	private String notificacion;

	public String notificacion() {
		return this.notificacion;
	}
}
