package Modificacion;

import guardarropas.Guardarropas;
import prendas.Prenda;

import java.util.Objects;

public abstract class Modificacion {

	protected Prenda prenda;
	protected Guardarropas guardarropas;
	protected Boolean aceptada;

	public Modificacion(Prenda prenda, Guardarropas guardarropas) {
		this.prenda = prenda;
		this.guardarropas = guardarropas;
	}

	public Prenda getPrenda() {
		return prenda;
	}

	public Guardarropas getGuardarropas() {
		return guardarropas;
	}

	public Boolean estaAceptada() {
		return !faltaDefinirAceptacion() && aceptada;
	}

	public Boolean estaRechazada() {
		return !faltaDefinirAceptacion() && !aceptada;
	}

	public Boolean faltaDefinirAceptacion() {
		return Objects.isNull(aceptada);
	}

	public void aceptarModificacion() {
		aceptada = true;
	};

	public void rechazarModificacion() {
		aceptada = false;
	};

	public void deshacerModificacion() {
		aceptada = null;
	};

}
