package proveedores_de_clima;

public interface ProveedorClima {
    Integer obtenerTemperaturaActual(String ciudad);

    Boolean estaActivo();
}
