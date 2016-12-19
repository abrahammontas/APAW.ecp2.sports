package es.upm.miw.apiArchitectureTheme.api;

import java.util.List;

import es.upm.miw.apiArchitectureTheme.controllers.UserController;
import es.upm.miw.apiArchitectureTheme.daos.DaoFactory;
import es.upm.miw.apiArchitectureTheme.entities.Sport;
import es.upm.miw.apiArchitectureTheme.entities.User;
import es.upm.miw.apiArchitectureTheme.exceptions.InvalidNameException;
import es.upm.miw.apiArchitectureTheme.exceptions.InvalidSportException;
import es.upm.miw.apiArchitectureTheme.exceptions.InvalidUserFieldException;
import es.upm.miw.apiArchitectureTheme.exceptions.NotFoundThemeIdException;
import es.upm.miw.apiArchitectureTheme.exceptions.SportNameNotDefined;
import es.upm.miw.apiArchitectureTheme.wrappers.UserListWrapper;

public class UserResource {

    private void validateField(String type, String field) throws InvalidNameException, InvalidUserFieldException, SportNameNotDefined {
        if (field == null || field.isEmpty()) {
            throw new InvalidNameException(field);
        }
        
        if(type == "nick"){
            List<User> userList = DaoFactory.getFactory().getUserDao().findAll();
            
            for (User user : userList) {
                if (user.getNick().equals(field)) {
                    throw new InvalidUserFieldException(field);
                }
            }
        }
        
        if(type == "sport"){
            List<Sport> sportList = DaoFactory.getFactory().getSportDao().findAll();
            boolean isSet = false;
            
            for (Sport sport : sportList) {
                if (sport.getName().equals(field)) {
                    isSet = true;
                    break;
                }
            }
            
            if(!isSet) {
                throw new SportNameNotDefined(field);
            }
        }
    }
    
    // GET **/users
    public UserListWrapper userList() {
        return new UserController().userList();
    }

    // POST **/users   body="nick,email"
    public void createUser(String nick, String email) throws InvalidUserFieldException, InvalidNameException, SportNameNotDefined {
        this.validateField("nick", nick);
        this.validateField("email", email);
        new UserController().createUser(nick, email);
    }
    
    // GET **users/search?sport=*
    public UserListWrapper searchBySport(String sport) throws NotFoundThemeIdException, InvalidUserFieldException, InvalidNameException, SportNameNotDefined {
        this.validateField("sport", sport);
        return new UserController().usersBySport(sport);
    }
    
    // PUT **/users/{nick}/sport    body="nick,email"
    public void addSport(String user, String sport) throws InvalidUserFieldException, InvalidNameException, InvalidSportException, SportNameNotDefined {
        this.validateField("sport", sport);
        new UserController().addSport(user, sport);
    }
}
