package usuarios;

import Modificacion.Modificacion;
import alerta.Alerta;
import atuendos.Atuendo;
import atuendos.RepositorioDeUniformes;
import guardarropas.Guardarropas;
import prendas.Prenda;
import prendas.PrendaBuilder;
import prendas.categorias.Categoria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Usuario {

    private String email;
    private List<Guardarropas> guardarropas;
    private List<Guardarropas> guardarropasCompartidos;
    private PrendaBuilder borradorDeUltimaPrenda;
    private List<Modificacion> modificaciones = new ArrayList<>();

    public void setEmail(String emailString){
        this.email = emailString;
    }

    public String getEmail() {
        return email;
    }

    public Usuario(String email, List<Guardarropas> guardarropas) {
        this.email = email;
        this.guardarropas = guardarropas;

        RepoDeUsuarios.getInstance().agregarUsuario(this);
    }

    public void alertar(Alerta alerta) {
        // ???
    }

    public Usuario(String email, Guardarropas guardarropas) {
        this.email = email;
        this.guardarropas = Collections.singletonList(guardarropas);

        RepoDeUsuarios.getInstance().agregarUsuario(this);
    }

    public PrendaBuilder crearPrendaDeCategoria(Categoria categoria) {
        this.borradorDeUltimaPrenda = new PrendaBuilder(categoria);
        return borradorDeUltimaPrenda;
    }

    public void aceptarModificacion(Modificacion modificacion) {
        modificacion.aceptarModificacion();
    }
    public void rechazarModificacion(Modificacion modificacion) {
        modificacion.rechazarModificacion();
    }
    public void deshacerModificacion(Modificacion modificacion) {
        modificacion.deshacerModificacion();
    }

    public void recibirModificacion(Modificacion modificacion) {
        modificaciones.add(modificacion);
    }

    public void proponerModificacion(Usuario usuario, Modificacion modificacion) {
        usuario.recibirModificacion(modificacion);
    }

    public void recibirGuardarropasCompartido(Guardarropas guardarropasCompartido) {
        guardarropasCompartidos.add(guardarropasCompartido);
    }

    public void compartirGuardarropas(Usuario usuario, Guardarropas guardarropasACompartir) {
        usuario.recibirGuardarropasCompartido(guardarropasACompartir);
    }

    public void agregarPrendaAGuardarropas(Prenda prenda, Guardarropas guardarropasElegido) {
        guardarropasElegido.agregarPrenda(prenda);
    }

    public Atuendo generarSugerencia(String ciudad) {
        int randomNum = ThreadLocalRandom.current().nextInt(0, guardarropas.size() + 1);
        return guardarropas.get(randomNum).generarSugerencia(ciudad);
    }

    public List<Guardarropas> getGuardarropas() {
        return guardarropas;
    }

    public List<Atuendo> getUniformes() {
        return new RepositorioDeUniformes().getUniformes();
    }

    public PrendaBuilder getBorradorDeUltimaPrenda() {
        return borradorDeUltimaPrenda;
    }

    public void agregarGuardarropas(Guardarropas guardarropasNuevo) {
        guardarropas.add(guardarropasNuevo);
    }

}
