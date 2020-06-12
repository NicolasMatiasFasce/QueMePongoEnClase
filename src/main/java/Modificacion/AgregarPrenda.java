package Modificacion;

import guardarropas.Guardarropas;
import prendas.Prenda;

public class AgregarPrenda extends Modificacion {

	public AgregarPrenda(Prenda prenda, Guardarropas guardarropas) {
		super(prenda, guardarropas);
	}

	@Override
	public void aceptarModificacion() {
		super.aceptarModificacion();
		this.guardarropas.agregarPrenda(this.prenda);
	}

	@Override
	public void deshacerModificacion() {
		if (this.estaAceptada()) {
			this.guardarropas.quitarPrenda(prenda);
		}
		super.deshacerModificacion();
	}

}
