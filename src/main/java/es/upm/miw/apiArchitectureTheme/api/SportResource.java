package es.upm.miw.apiArchitectureTheme.api;

import es.upm.miw.apiArchitectureTheme.controllers.SportController;
import es.upm.miw.apiArchitectureTheme.exceptions.InvalidThemeFieldException;

public class SportResource {

    private void validateField(String field) throws InvalidThemeFieldException {
        if (field == null || field.isEmpty()) {
            throw new InvalidThemeFieldException(field);
        }
    }
    
    // POST **/sport   body="name"
    public void createSport(String name) throws InvalidThemeFieldException {
        this.validateField(name);
        new SportController().createSport(name);
    }

}
