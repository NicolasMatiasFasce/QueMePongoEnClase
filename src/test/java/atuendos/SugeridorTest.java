package atuendos;

import guardarropas.Guardarropas;
import org.junit.Before;
import org.junit.Test;
import prendas.Prenda;
import prendas.categorias.Categoria;
import prendas.materiales.Material;
import prendas.tipos.TipoAccesorio;
import prendas.tipos.TipoCalzado;
import prendas.tipos.TipoParteInferior;
import prendas.tipos.TipoParteSuperior;
import prendas.trama.Trama;

import java.awt.*;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SugeridorTest {

	Sugeridor sugeridor;

	@Before
	public void setUp() {
		sugeridor = new Sugeridor();
	}

	@Test
	public void sugeridorMeGeneraUnAtuendoSinAccesorioYUnAtuendoConAccesorio() {
		Guardarropas guardarropas = new Guardarropas(new HashSet<>());
		guardarropas.agregarPrenda(new Prenda(Categoria.PARTE_SUPERIOR, Trama.LISO, TipoParteSuperior.REMERA, Material.TELA, Color.BLACK));
		guardarropas.agregarPrenda(new Prenda(Categoria.PARTE_INFERIOR, Trama.LISO, TipoParteInferior.JOGGING, Material.TELA, Color.BLACK));
		guardarropas.agregarPrenda(new Prenda(Categoria.CALZADO, Trama.LISO, TipoCalzado.ZAPATILLAS, Material.TELA, Color.BLACK));
		guardarropas.agregarPrenda(new Prenda(Categoria.ACCESORIO, Trama.LISO, TipoAccesorio.ANTEOJOS, Material.METAL, Color.BLACK));
		List<Atuendo> atuendos = sugeridor.atuendosValidosParaTemperatura(30, guardarropas);
		assertEquals(2, atuendos.size());
	}

	@Test
	public void sugeridorMeGeneraUnAtuendoSinAccesorio() {
		Guardarropas guardarropas = new Guardarropas(new HashSet<>());
		guardarropas.agregarPrenda(new Prenda(Categoria.PARTE_SUPERIOR, Trama.LISO, TipoParteSuperior.REMERA, Material.TELA, Color.BLACK));
		guardarropas.agregarPrenda(new Prenda(Categoria.PARTE_INFERIOR, Trama.LISO, TipoParteInferior.JOGGING, Material.TELA, Color.BLACK));
		guardarropas.agregarPrenda(new Prenda(Categoria.CALZADO, Trama.LISO, TipoCalzado.ZAPATILLAS, Material.TELA, Color.BLACK));
		List<Atuendo> atuendos = sugeridor.atuendosValidosParaTemperatura(30, guardarropas);
		assertEquals(1, atuendos.size());
	}

	@Test
	public void sugeridorMeGeneraCuatroAtuendos() {
		Guardarropas guardarropas = new Guardarropas(new HashSet<>());
		guardarropas.agregarPrenda(new Prenda(Categoria.PARTE_SUPERIOR, Trama.LISO, TipoParteSuperior.REMERA, Material.TELA, Color.BLACK));
		guardarropas.agregarPrenda(new Prenda(Categoria.PARTE_INFERIOR, Trama.LISO, TipoParteInferior.JOGGING, Material.TELA, Color.BLACK));
		guardarropas.agregarPrenda(new Prenda(Categoria.PARTE_INFERIOR, Trama.LISO, TipoParteInferior.JOGGING_CORTO, Material.TELA, Color.BLACK));
		guardarropas.agregarPrenda(new Prenda(Categoria.CALZADO, Trama.LISO, TipoCalzado.ZAPATILLAS, Material.TELA, Color.BLACK));
		guardarropas.agregarPrenda(new Prenda(Categoria.ACCESORIO, Trama.LISO, TipoAccesorio.ANTEOJOS, Material.METAL, Color.BLACK));
		List<Atuendo> atuendos = sugeridor.atuendosValidosParaTemperatura(30, guardarropas);

		assertEquals(4, atuendos.size());
	}

	@Test
	public void sugeridorSinPrendaSuperiorNoMeGeneraAtuendos() {
		Guardarropas guardarropas = new Guardarropas(new HashSet<>());
		guardarropas.agregarPrenda(new Prenda(Categoria.PARTE_INFERIOR, Trama.LISO, TipoParteInferior.JOGGING, Material.TELA, Color.BLACK));
		guardarropas.agregarPrenda(new Prenda(Categoria.PARTE_INFERIOR, Trama.LISO, TipoParteInferior.JOGGING_CORTO, Material.TELA, Color.BLACK));
		guardarropas.agregarPrenda(new Prenda(Categoria.CALZADO, Trama.LISO, TipoCalzado.ZAPATILLAS, Material.TELA, Color.BLACK));
		guardarropas.agregarPrenda(new Prenda(Categoria.ACCESORIO, Trama.LISO, TipoAccesorio.ANTEOJOS, Material.METAL, Color.BLACK));
		List<Atuendo> atuendos = sugeridor.atuendosValidosParaTemperatura(30, guardarropas);

		assertEquals(0, atuendos.size());
	}

	@Test
	public void sugeridorSinPrendasNoMeGeneraAtuendos() {
		Guardarropas guardarropas = new Guardarropas(new HashSet<>());
		List<Atuendo> atuendos = sugeridor.atuendosValidosParaTemperatura(30, guardarropas);

		assertEquals(0, atuendos.size());
	}

}
