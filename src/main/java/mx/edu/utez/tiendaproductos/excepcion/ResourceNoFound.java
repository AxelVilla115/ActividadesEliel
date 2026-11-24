package mx.edu.utez.tiendaproductos.excepcion;

public class ResourceNoFound extends RuntimeException {
    public ResourceNoFound(String message) {

        super(message);
    }
}
