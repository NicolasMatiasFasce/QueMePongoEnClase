package prendas.tipos;

import prendas.categorias.Categoria;
import prendas.materiales.Material;

import java.util.Arrays;
import java.util.List;

public class TipoParteSuperior extends TipoPrenda {

    private TipoParteSuperior(List<Material> materiales, Integer temperaturaLimite) {
        this.materialesValidos = materiales;
        this.temperaturaLimite = temperaturaLimite;
    }

    public static final TipoParteSuperior REMERA = new TipoParteSuperior(Arrays.asList(Material.TELA, Material.SEDA, Material.ALGODON), 80);
    public static final TipoParteSuperior MUSCULOSA = new TipoParteSuperior(Arrays.asList(Material.TELA, Material.SEDA, Material.ALGODON), 80);
    public static final TipoParteSuperior CAMISA = new TipoParteSuperior(Arrays.asList(Material.TELA, Material.SEDA, Material.ALGODON), 80);
    public static final TipoParteSuperior BLUSA = new TipoParteSuperior(Arrays.asList(Material.TELA, Material.SEDA, Material.ALGODON), 80);
    public static final TipoParteSuperior BUZO = new TipoParteSuperior(Arrays.asList(Material.TELA, Material.ALGODON, Material.POLIESTER, Material.JEAN, Material.TERCIOPELO), 22);
    public static final TipoParteSuperior PULOVER = new TipoParteSuperior(Arrays.asList(Material.LANA, Material.POLIESTER, Material.TERCIOPELO), 22);
    public static final TipoParteSuperior SACO = new TipoParteSuperior(Arrays.asList(Material.TELA, Material.SEDA, Material.ALGODON), 24);
    public static final TipoParteSuperior CAMPERA = new TipoParteSuperior(Arrays.asList(Material.TELA, Material.ALGODON, Material.LANA, Material.CUERO, Material.JEAN, Material.POLIESTER), 14);
    public static final TipoParteSuperior CAMPERA_IMPERMEABLE = new TipoParteSuperior(Arrays.asList(Material.POLIESTER), 14);
    public static final TipoParteSuperior CAMPERA_POLAR = new TipoParteSuperior(Arrays.asList(Material.LANA, Material.TELA, Material.ALGODON, Material.POLIESTER), 10);

    @Override
    public Categoria categoria() {
        return Categoria.PARTE_SUPERIOR;
    }

}
