package es.upm.miw.apiArchitectureTheme.exceptions;

public class InvalidUserFieldException extends Exception {
	private static final long serialVersionUID = -642045799876625537L;
	public static final String DESCRIPTION = "Nick del Usuario ya existe en la base de datos";

	public InvalidUserFieldException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

	public InvalidUserFieldException() {
		this("");
	}

}
