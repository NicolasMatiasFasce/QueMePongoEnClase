package proveedores_de_clima;

public interface IProveedorClima {
    Integer obtenerTemperaturaActual(String ciudad);

    Boolean estaActivo();
}
