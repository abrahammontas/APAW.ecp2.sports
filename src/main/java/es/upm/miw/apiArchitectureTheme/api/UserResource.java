package es.upm.miw.apiArchitectureTheme.api;

import es.upm.miw.apiArchitectureTheme.controllers.UserController;
import es.upm.miw.apiArchitectureTheme.entities.User;
import es.upm.miw.apiArchitectureTheme.exceptions.InvalidThemeFieldException;
import es.upm.miw.apiArchitectureTheme.exceptions.NotFoundThemeIdException;
import es.upm.miw.apiArchitectureTheme.wrappers.UserListWrapper;

public class UserResource {

    private void validateField(String field) throws InvalidThemeFieldException {
        if (field == null || field.isEmpty()) {
            throw new InvalidThemeFieldException(field);
        }
    }
    
    // GET **/users
    public UserListWrapper userList() {
        return new UserController().userList();
    }

    // POST **/users   body="nick,email"
    public void createUser(String nick, String email) throws InvalidThemeFieldException {
        this.validateField(nick);
        this.validateField(email);
        new UserController().createUser(nick, email);
    }
    
    // GET **users/search?sport=*
    public UserListWrapper searchBySport(String sport) throws NotFoundThemeIdException, InvalidThemeFieldException {
        this.validateField(sport);
        return new UserController().usersBySport(sport);
    }
    
    // POST **/users/{nick}/sport    body="nick,email"
    public void addSport(String user, String sport) throws InvalidThemeFieldException {
        this.validateField(sport);
        new UserController().addSport(user, sport);
    }

}
