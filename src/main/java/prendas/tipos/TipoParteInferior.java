package prendas.tipos;

import prendas.categorias.Categoria;
import prendas.materiales.Material;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TipoParteInferior extends TipoPrenda {

	private TipoParteInferior(List<Material> materiales, Integer teperaturaLimite) {
		this.materialesValidos = materiales;
		this.temperaturaLimite = teperaturaLimite;
	}

	public static final TipoParteInferior JEAN = new TipoParteInferior(Collections.singletonList(Material.JEAN), 80);
	public static final TipoParteInferior TRAJE = new TipoParteInferior(Arrays.asList(Material.TELA, Material.SEDA, Material.ALGODON), 80);
	public static final TipoParteInferior POLLERA = new TipoParteInferior(Arrays.asList(Material.JEAN, Material.SEDA, Material.TELA, Material.ALGODON, Material.CUERO, Material.POLIESTER), 80);
	public static final TipoParteInferior BERMUDA = new TipoParteInferior(Arrays.asList(Material.JEAN, Material.SEDA, Material.TELA, Material.ALGODON, Material.CUERO, Material.POLIESTER), 80);
	public static final TipoParteInferior CALZA = new TipoParteInferior(Arrays.asList(Material.TELA, Material.ALGODON, Material.POLIESTER), 80);
	public static final TipoParteInferior JOGGING = new TipoParteInferior(Arrays.asList(Material.TELA, Material.ALGODON), 80);
	public static final TipoParteInferior JOGGING_CORTO = new TipoParteInferior(Arrays.asList(Material.TELA, Material.ALGODON), 80);

	@Override
	public Categoria categoria() {
		return Categoria.PARTE_INFERIOR;
	}

}
