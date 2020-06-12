package Modificacion;

import guardarropas.Guardarropas;
import prendas.Prenda;

public class QuitarPrenda extends Modificacion {

	public QuitarPrenda(Prenda prenda, Guardarropas guardarropas) {
		super(prenda, guardarropas);
	}

	@Override
	public void aceptarModificacion() {
		super.aceptarModificacion();
		this.guardarropas.quitarPrenda(this.prenda);
	}

	@Override
	public void deshacerModificacion() {
		if (this.estaAceptada()) {
			this.guardarropas.agregarPrenda(prenda);
		}
		super.deshacerModificacion();
	}

}
