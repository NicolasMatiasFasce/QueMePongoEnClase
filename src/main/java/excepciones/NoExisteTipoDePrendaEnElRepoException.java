package excepciones;

public class NoExisteTipoDePrendaEnElRepoException extends RuntimeException {

    public NoExisteTipoDePrendaEnElRepoException(String message) {
        super(message);
    }
}
