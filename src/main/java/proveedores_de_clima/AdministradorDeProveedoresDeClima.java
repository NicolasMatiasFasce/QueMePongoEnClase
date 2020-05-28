package proveedores_de_clima;

import excepciones.NoAndaNingunProveedorException;
import proveedores_de_clima.accuweather.ProveedorAccuWeather;

import java.util.HashSet;
import java.util.Set;

public class AdministradorDeProveedoresDeClima {

    private Set<IProveedorClima> proveedores = new HashSet<>();

    public AdministradorDeProveedoresDeClima() {
        this.proveedores.add(new ProveedorAccuWeather());
    }

    public Integer obtenerTemperaturaActual(String ciudad) {
        IProveedorClima proveedorEncontrado = encontrarPrimerProveedorFuncional();
        return proveedorEncontrado.obtenerTemperaturaActual(ciudad);
    }

    public IProveedorClima encontrarPrimerProveedorFuncional() {
        IProveedorClima proveedorEncontrado = proveedores
                .stream()
                .filter(IProveedorClima::estaActivo)
                .findFirst()
                .orElse(null);
        if (proveedorEncontrado == null)
            throw new NoAndaNingunProveedorException("No funciona ningun proveedor");
        return proveedorEncontrado;
    }

    public void agregarProveedor(IProveedorClima proveedorNuevo) {
        proveedores.add(proveedorNuevo);
    }
}
