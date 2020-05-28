package atuendos;

import prendas.Prenda;

import java.util.Objects;
import java.util.Set;

public class Atuendo {

    private Set<Prenda> parteSuperior;
    private Set<Prenda> parteInferior;
    private Set<Prenda> calzado;
    private Set<Prenda> accesorio;

    public Atuendo(Set<Prenda> parteSuperior, Set<Prenda> parteInferior, Set<Prenda> calzado, Set<Prenda> accesorio) {
        this.parteSuperior = parteSuperior;
        this.parteInferior = parteInferior;
        this.calzado = calzado;
        this.accesorio = accesorio;
    }

    public Set<Prenda> obtenerParteSuperior() {
        return parteSuperior;
    }

    public Set<Prenda> obtenerParteInferior() {
        return parteInferior;
    }

    public Set<Prenda> obtenerCalzado() {
        return calzado;
    }

    public Set<Prenda> obtenerAccesorio() {
        return accesorio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atuendo atuendo = (Atuendo) o;
        return parteSuperior.equals(atuendo.parteSuperior) &&
                parteInferior.equals(atuendo.parteInferior) &&
                calzado.equals(atuendo.calzado) &&
                Objects.equals(accesorio, atuendo.accesorio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parteSuperior, parteInferior, calzado, accesorio);
    }

}
