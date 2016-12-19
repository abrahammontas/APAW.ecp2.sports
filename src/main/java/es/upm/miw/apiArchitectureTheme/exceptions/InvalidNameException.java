package es.upm.miw.apiArchitectureTheme.exceptions;

public class InvalidNameException extends Exception {
    private static final long serialVersionUID = 7261544715100416561L;
    public static final String DESCRIPTION = "No se puede agregar un objeto vacio";

    public InvalidNameException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }
    
    public InvalidNameException() {
        this("");
    }
}
