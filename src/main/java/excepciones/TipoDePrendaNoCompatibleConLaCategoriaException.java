package excepciones;

public class TipoDePrendaNoCompatibleConLaCategoriaException extends RuntimeException {

    public TipoDePrendaNoCompatibleConLaCategoriaException(String message) {
        super(message);
    }
}
