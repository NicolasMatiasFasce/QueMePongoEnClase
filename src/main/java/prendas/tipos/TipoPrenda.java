package prendas.tipos;

import prendas.categorias.Categoria;
import prendas.materiales.Material;

import java.util.List;

public abstract class TipoPrenda {

    protected List<Material> materialesValidos;

    protected Integer temperaturaLimite;

    public TipoPrenda() {
    }

    public List<Material> materialesValidos() {
        return this.materialesValidos;
    }

    public Integer temperaturaLimite() {
        return this.temperaturaLimite;
    }

    public abstract Categoria categoria();

}
