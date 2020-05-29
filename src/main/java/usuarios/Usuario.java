package usuarios;

import atuendos.Atuendo;
import atuendos.RepositorioDeUniformes;
import guardarropas.Guardarropas;
import prendas.Prenda;
import prendas.PrendaBuilder;
import prendas.categorias.Categoria;

import java.util.List;

public class Usuario {

    private String email;
    private Guardarropas guardarropas;
    private PrendaBuilder borradorDeUltimaPrenda;

    public void setEmail(String emailString){
        this.email = emailString;
    }

    public String getEmail() {
        return email;
    }

    public Usuario(String email, Guardarropas guardarropas) {
        this.email = email;
        this.guardarropas = guardarropas;
    }

    public PrendaBuilder crearPrendaDeCategoria(Categoria categoria) {
        this.borradorDeUltimaPrenda = new PrendaBuilder(categoria);
        return borradorDeUltimaPrenda;
    }

    public void agregarPrendaAGuardarropas(Prenda prenda) {
        guardarropas.agregarPrenda(prenda);
    }

    public Atuendo generarSugerencia(String ciudad) {
        return guardarropas.generarSugerencia(ciudad);
    }

    public Guardarropas getGuardarropas() {
        return guardarropas;
    }

    public void setGuardarropas(Guardarropas guardarropas) {
        this.guardarropas = guardarropas;
    }

    public List<Atuendo> getUniformes() {
        return new RepositorioDeUniformes().getUniformes();
    }

    public PrendaBuilder getBorradorDeUltimaPrenda() {
        return borradorDeUltimaPrenda;
    }

}
