package es.upm.miw.apiArchitectureTheme.api;

import java.util.List;

import es.upm.miw.apiArchitectureTheme.controllers.SportController;
import es.upm.miw.apiArchitectureTheme.daos.DaoFactory;
import es.upm.miw.apiArchitectureTheme.entities.Sport;
import es.upm.miw.apiArchitectureTheme.exceptions.InvalidNameException;
import es.upm.miw.apiArchitectureTheme.exceptions.InvalidSportException;

public class SportResource {

    private void validateField(String field) throws InvalidSportException, InvalidNameException {
        if (field == null || field.isEmpty()) {
            throw new InvalidNameException(field);
        }
        
        List<Sport> sportList = DaoFactory.getFactory().getSportDao().findAll();
        
        for (Sport sport : sportList) {
            if (sport.getName().equals(field)) {
                throw new InvalidSportException(field);
            }
        }
    }
    
    // POST **/sport   body="name"
    public void createSport(String name) throws InvalidSportException, InvalidNameException {
        this.validateField(name);
        new SportController().createSport(name);
    }

}
