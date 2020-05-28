package prendas.tipos;

import prendas.categorias.Categoria;
import prendas.materiales.Material;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TipoCalzado extends TipoPrenda {

	private TipoCalzado(List<Material> materiales, Integer temperaturaLimite) {
		this.materiales = materiales;
		this.temperaturaLimite = temperaturaLimite;
	}

	public static final TipoCalzado BOTAS = new TipoCalzado(Arrays.asList(Material.CUERO, Material.TELA, Material.JEAN, Material.TERCIOPELO), 80);
    public static final TipoCalzado SANDALIAS = new TipoCalzado(Collections.singletonList(Material.GOMA), 80);
    public static final TipoCalzado TACOS = new TipoCalzado(Arrays.asList(Material.CUERO, Material.TELA), 80);
    public static final TipoCalzado ZAPATILLAS = new TipoCalzado(Arrays.asList(Material.CUERO, Material.TELA, Material.JEAN), 80);
    public static final TipoCalzado OJOTAS = new TipoCalzado(Collections.singletonList(Material.GOMA), 80);
    public static final TipoCalzado BORCEGOS = new TipoCalzado(Arrays.asList(Material.CUERO, Material.TELA, Material.JEAN, Material.TERCIOPELO), 80);
    public static final TipoCalzado ZAPATOS = new TipoCalzado(Arrays.asList(Material.CUERO, Material.TELA), 80);

	@Override
	public Categoria categoria() {
		return Categoria.CALZADO;
	}
}
