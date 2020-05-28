package prendas;

import excepciones.AtributoNuloException;
import excepciones.ColoresIgualesException;
import excepciones.MaterialInvalidoException;
import excepciones.TipoDePrendaNoCompatibleConLaCategoriaException;
import prendas.categorias.Categoria;
import prendas.materiales.Material;
import prendas.tipos.TipoPrenda;
import prendas.trama.Trama;

import java.awt.*;
import java.util.Objects;

public class PrendaBuilder {
    private Categoria categoria;
    private TipoPrenda tipo;
    private Material material;
    private Color colorPrincipal;
    private Color colorSecundario = NoColor.NO_COLOR;
    private Trama trama = Trama.LISO;

    public PrendaBuilder(Categoria categoria) {
        romperSiEsNulo(categoria, "La categoria no puede ser nula");
        this.categoria = categoria;
    }

    public PrendaBuilder especificarTipo(TipoPrenda tipo) {
        romperSiEsNulo(tipo, "El tipo no puede ser nulo");
        validarTipoSegunCategoria(tipo);
        this.tipo = tipo;
        return this;
    }

    public PrendaBuilder especificarMaterial(Material material) {
        romperSiEsNulo(material, "El material no puede ser nulo");
        romperSiEsNulo(this.tipo, "Antes de asignar un material debes asignar un tipo de prenda");
        validarMaterial(material);
        this.material = material;
        return this;
    }

    public PrendaBuilder especificarColorPrincipal(Color colorPrincipal) {
        romperSiEsNulo(colorPrincipal, "El color principal no puede ser nulo");
        this.colorPrincipal = colorPrincipal;
        return this;
    }

    public PrendaBuilder especificarColorSecundario(Color colorSecundario) {
        if (Objects.nonNull(colorSecundario) && colorSecundario.equals(this.colorPrincipal)) {
            throw new ColoresIgualesException("El color secundario no puede ser igual al principal");
        }
        this.colorSecundario = colorSecundario;
        return this;
    }

    public PrendaBuilder especificarTrama(Trama trama) {
        romperSiEsNulo(trama, "La trama no puede ser nula");
        this.trama = trama;
        return this;
    }

    public Prenda crearPrenda() {
        verificarSiHayAtributosNulos();
        return new Prenda(this.categoria, this.trama, this.tipo, this.material,
                this.colorPrincipal, this.colorSecundario);
    }

    private void validarTipoSegunCategoria(TipoPrenda tipo) {
        if (tipo.categoria() != categoria) {
            throw new TipoDePrendaNoCompatibleConLaCategoriaException("El tipo de prenda elegido no es compatible con la categoria cargada");
        }
    }

    private void validarMaterial(Material material) {
        if (this.tipo.materialesValidos().stream().noneMatch(m -> m.equals(material))) {
            throw new MaterialInvalidoException("El material no es válido para el tipo de prenda seleccionada");
        }
    }

    private void verificarSiHayAtributosNulos() {
        romperSiEsNulo(tipo, "El tipo de prenda no puede ser nulo");
        romperSiEsNulo(material, "El material no puede ser nulo");
        romperSiEsNulo(categoria, "La categoria no puede ser nula");
        romperSiEsNulo(colorPrincipal, "El color principal no puede ser nulo");
    }

    private void romperSiEsNulo(Object object, String message) {
        if (Objects.isNull(object))
            throw new AtributoNuloException(message);
    }
}
