package prendas.tipos;

import prendas.categorias.Categoria;
import prendas.materiales.Material;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TipoAccesorio extends TipoPrenda {

    private TipoAccesorio(List<Material> materiales) {
        this.materiales = materiales;
    }

    public static final TipoAccesorio RELOJ = new TipoAccesorio(Arrays.asList(Material.METAL, Material.GOMA, Material.CUERO));
    public static final TipoAccesorio PULSERA = new TipoAccesorio(Arrays.asList(Material.METAL, Material.GOMA, Material.PLASTICO));
    public static final TipoAccesorio ANTEOJOS = new TipoAccesorio(Arrays.asList(Material.METAL, Material.PLASTICO));
    public static final TipoAccesorio PANUELO = new TipoAccesorio(Arrays.asList(Material.TELA, Material.SEDA));
    public static final TipoAccesorio ANILLO = new TipoAccesorio(Collections.singletonList(Material.METAL));
    public static final TipoAccesorio COLLAR = new TipoAccesorio(Arrays.asList(Material.METAL, Material.GOMA, Material.PLASTICO));
    public static final TipoAccesorio TOBILLERA = new TipoAccesorio(Arrays.asList(Material.METAL, Material.GOMA, Material.PLASTICO));
    public static final TipoAccesorio PARAGUAS = new TipoAccesorio(Arrays.asList(Material.PLASTICO, Material.POLIESTER));
    public static final TipoAccesorio SOMBRERO = new TipoAccesorio(Arrays.asList(Material.POLIESTER, Material.TELA));
    public static final TipoAccesorio GORRO_DE_LANA = new TipoAccesorio(Collections.singletonList(Material.LANA));

    @Override
    public Integer temperaturaLimite() {
        return 80;
    }

    @Override
    public Categoria categoria() {
        return Categoria.ACCESORIO;
    }
}
