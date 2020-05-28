package atuendos;

import prendas.PrendaBuilder;
import prendas.categorias.Categoria;
import prendas.materiales.Material;
import prendas.tipos.TipoCalzado;
import prendas.tipos.TipoParteInferior;
import prendas.tipos.TipoParteSuperior;
import prendas.trama.Trama;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class RepositorioDeUniformes {

	private List<Atuendo> uniformes = new ArrayList<>();

	public static final Atuendo uniformeMilitar = new Atuendo(
			new HashSet<>(Collections.singletonList(new PrendaBuilder(Categoria.PARTE_SUPERIOR)
					.especificarTipo(TipoParteSuperior.MUSCULOSA)
					.especificarColorPrincipal(Color.GREEN)
					.especificarTrama(Trama.ESTAMPADO)
					.especificarColorSecundario(Color.LIGHT_GRAY)
					.especificarMaterial(Material.TELA)
					.crearPrenda())),
			new HashSet<>(Collections.singletonList(new PrendaBuilder(Categoria.PARTE_INFERIOR)
					.especificarTipo(TipoParteInferior.JOGGING)
					.especificarColorPrincipal(Color.GREEN)
					.especificarTrama(Trama.ESTAMPADO)
					.especificarColorSecundario(Color.LIGHT_GRAY)
					.especificarMaterial(Material.TELA)
					.crearPrenda())),
			new HashSet<>(Collections.singletonList(new PrendaBuilder(Categoria.CALZADO)
					.especificarTipo(TipoCalzado.BOTAS)
					.especificarColorPrincipal(Color.BLACK)
					.especificarMaterial(Material.CUERO)
					.crearPrenda())),
			new HashSet<>()
	);
	public static final Atuendo uniformeAbogado = new Atuendo(
			new HashSet<>(Collections.singletonList(new PrendaBuilder(Categoria.PARTE_SUPERIOR)
					.especificarTipo(TipoParteSuperior.SACO)
					.especificarColorPrincipal(Color.BLACK)
					.especificarMaterial(Material.SEDA)
					.crearPrenda())),
			new HashSet<>(Collections.singletonList(new PrendaBuilder(Categoria.PARTE_INFERIOR)
					.especificarTipo(TipoParteInferior.TRAJE)
					.especificarColorPrincipal(Color.BLACK)
					.especificarMaterial(Material.SEDA)
					.crearPrenda())),
			new HashSet<>(Collections.singletonList(new PrendaBuilder(Categoria.CALZADO)
					.especificarTipo(TipoCalzado.ZAPATOS)
					.especificarColorPrincipal(Color.BLACK)
					.especificarMaterial(Material.CUERO)
					.crearPrenda())),
			new HashSet<>()
	);
	public static Atuendo uniformeColectivero = new Atuendo(
			new HashSet<>(Collections.singletonList(new PrendaBuilder(Categoria.PARTE_SUPERIOR)
					.especificarTipo(TipoParteSuperior.CAMISA)
					.especificarColorPrincipal(Color.BLUE)
					.especificarMaterial(Material.ALGODON)
					.crearPrenda())),
			new HashSet<>(Collections.singletonList(new PrendaBuilder(Categoria.PARTE_INFERIOR)
					.especificarTipo(TipoParteInferior.JEAN)
					.especificarColorPrincipal(Color.BLUE)
					.especificarMaterial(Material.JEAN)
					.crearPrenda())),
			new HashSet<>(Collections.singletonList(new PrendaBuilder(Categoria.CALZADO)
					.especificarTipo(TipoCalzado.ZAPATILLAS)
					.especificarColorPrincipal(Color.BLACK)
					.especificarMaterial(Material.TELA)
					.crearPrenda())),
			new HashSet<>()
	);

	public RepositorioDeUniformes() {
		this.uniformes.add(uniformeMilitar);
		this.uniformes.add(uniformeAbogado);
		this.uniformes.add(uniformeColectivero);
	}

	public List<Atuendo> getUniformes() {
		return uniformes;
	}

}
