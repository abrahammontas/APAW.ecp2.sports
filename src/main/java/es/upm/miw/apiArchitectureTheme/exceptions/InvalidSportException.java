package es.upm.miw.apiArchitectureTheme.exceptions;

public class InvalidSportException extends Exception {
	private static final long serialVersionUID = -5173361541880534566L;

	public static final String DESCRIPTION = "El sport ya existe en la base de datos";

	public InvalidSportException(String detail) {
		super(DESCRIPTION + ". (" + detail + ")");
	}

	public InvalidSportException() {
		this("");
	}

}
