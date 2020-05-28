package prendas;

import prendas.categorias.Categoria;
import prendas.materiales.Material;
import prendas.tipos.TipoPrenda;
import prendas.trama.Trama;

import java.awt.*;
import java.util.Objects;

public class Prenda {

    private Categoria categoria;
    private TipoPrenda tipo;
    private Material material;
    private Color colorPrincipal;
    private Color colorSecundario = NoColor.NO_COLOR;
    private Trama trama;

    public Prenda(Categoria categoria, Trama trama, TipoPrenda tipo, Material material, Color colorPrincipal) {
        this.categoria = categoria;
        this.tipo = tipo;
        this.material = material;
        this.colorPrincipal = colorPrincipal;
        this.trama = trama;
    }

    public Prenda(Categoria categoria, Trama trama, TipoPrenda tipo, Material material, Color colorPrincipal, Color colorSecundario) {
        this.categoria = categoria;
        this.trama = trama;
        this.tipo = tipo;
        this.material = material;
        this.colorPrincipal = colorPrincipal;
        this.colorSecundario = Objects.nonNull(colorSecundario) ? colorSecundario : NoColor.NO_COLOR;
    }

    public Prenda() {
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Trama getTrama() {
        return trama;
    }

    public TipoPrenda getTipo() {
        return tipo;
    }

    public Material getMaterial() {
        return material;
    }


    public Color getColorPrincipal() {
        return colorPrincipal;
    }

    public Color getColorSecundario() {
        return colorSecundario;
    }
}
