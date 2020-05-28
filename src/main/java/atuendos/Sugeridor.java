package atuendos;

import guardarropas.Guardarropas;
import prendas.Prenda;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.google.common.collect.Sets.cartesianProduct;

public class Sugeridor {

	private Boolean prendaEsValidaParaTemperatura(Prenda prenda, Integer temperatura) {
		return prenda.getTipo().temperaturaLimite() > temperatura;
	}

	public List<Atuendo> generarSugerencias(Integer temperatura, Guardarropas guardarropas) {
		Set<Prenda> calzados = guardarropas.obtenerCalzados().stream()
				.filter(prenda -> this.prendaEsValidaParaTemperatura(prenda, temperatura))
				.collect(Collectors.toSet());
		Set<Prenda> prendasInferiores = guardarropas.obtenerPrendasInferiores().stream()
				.filter(prenda -> this.prendaEsValidaParaTemperatura(prenda, temperatura))
				.collect(Collectors.toSet());
		Set<Prenda> prendasSuperiores = guardarropas.obtenerPrendasSuperiores().stream()
				.filter(prenda -> this.prendaEsValidaParaTemperatura(prenda, temperatura))
				.collect(Collectors.toSet());
		Set<Prenda> accesorios = guardarropas.obtenerAccesorios().stream()
				.filter(prenda -> this.prendaEsValidaParaTemperatura(prenda, temperatura))
				.collect(Collectors.toSet());

		List<Atuendo> atuendosConAccesorios = cartesianProduct(prendasSuperiores, prendasInferiores, calzados, accesorios).stream()
				.map(lista -> new Atuendo(Collections.singleton(lista.get(0)), Collections.singleton(lista.get(1)),
						Collections.singleton(lista.get(2)), Collections.singleton(lista.get(3)))).collect(Collectors.toList());

		List<Atuendo> atuendosSinAccesorios = cartesianProduct(prendasSuperiores, prendasInferiores, calzados).stream()
				.map(lista -> new Atuendo(Collections.singleton(lista.get(0)), Collections.singleton(lista.get(1)),
						Collections.singleton(lista.get(2)), new HashSet<>())).collect(Collectors.toList());

		atuendosConAccesorios.addAll(atuendosSinAccesorios);

		return atuendosConAccesorios;
	}

	public List<Atuendo> atuendosValidosParaAhora(Integer temperatura, Guardarropas guardarropas) {
		return generarSugerencias(temperatura, guardarropas);
	}

}
