package proveedores_de_clima;

import excepciones.NoAndaNingunProveedorException;
import proveedores_de_clima.accuweather.ProveedorAccuWeather;

import java.util.HashSet;
import java.util.Set;

public class AdministradorDeProveedoresDeClima {

    private Set<ProveedorClima> proveedores = new HashSet<>();

    public AdministradorDeProveedoresDeClima() {
        this.proveedores.add(new ProveedorAccuWeather());
    }

    public Integer obtenerTemperaturaActual(String ciudad) {
        ProveedorClima proveedorEncontrado = encontrarPrimerProveedorFuncional();
        return proveedorEncontrado.obtenerTemperaturaActual(ciudad);
    }

    private ProveedorClima encontrarPrimerProveedorFuncional() {
        ProveedorClima proveedorEncontrado = proveedores
                .stream()
                .filter(ProveedorClima::estaActivo)
                .findFirst()
                .orElse(null);
        if (proveedorEncontrado == null)
            throw new NoAndaNingunProveedorException("No funciona ningun proveedor");
        return proveedorEncontrado;
    }

    public void agregarProveedor(ProveedorClima proveedorNuevo) {
        proveedores.add(proveedorNuevo);
    }
}
