package es.upm.miw.apiArchitectureTheme.exceptions;

public class SportNameNotDefined extends Exception {

    private static final long serialVersionUID = 4576270548378784602L;
    public static final String DESCRIPTION = "El sport no existe en la base de datos";

    public SportNameNotDefined(String detail) {
        super(DESCRIPTION + ". (" + detail + ")");
    }

    public SportNameNotDefined() {
        this("");
    }

}
