package es.upm.miw.apiArchitectureTheme.controllers;

import java.util.List;

import es.upm.miw.apiArchitectureTheme.daos.DaoFactory;
import es.upm.miw.apiArchitectureTheme.entities.Sport;
import es.upm.miw.apiArchitectureTheme.entities.User;
import es.upm.miw.apiArchitectureTheme.exceptions.InvalidSportException;
import es.upm.miw.apiArchitectureTheme.exceptions.InvalidUserFieldException;
import es.upm.miw.apiArchitectureTheme.wrappers.UserListWrapper;
import es.upm.miw.apiArchitectureTheme.wrappers.UserWrapper;

public class UserController {

    public UserListWrapper userList() {
        List<User> userList = getAllUsers();
        UserListWrapper userListWrapper = new UserListWrapper();
        for (User user : userList) {
            userListWrapper.addUserWrapper(new UserWrapper(user.getNick(), user.getEmail()));
        }
        return userListWrapper;
    }

    public void createUser(String nick, String email) {
        DaoFactory.getFactory().getUserDao().create(new User(nick, email));
    }
    
    public UserListWrapper usersBySport(String sport) {
          List<User> users = DaoFactory.getFactory().getUserDao().usersBySport(sport);
          UserListWrapper userListWrapper = new UserListWrapper();
          
          for (User user : users) {
              userListWrapper.addUserWrapper(new UserWrapper(user.getNick(), user.getEmail()));
          }
          
          return userListWrapper;
      }

    public void addSport(String user, String sport) throws InvalidUserFieldException, InvalidSportException {
        User userEntity = DaoFactory.getFactory().getUserDao().getByName(user);
        Sport sportEntity = DaoFactory.getFactory().getSportDao().getByName(sport);
        
        if (userEntity != null) {
            if (sportEntity != null) {
                DaoFactory.getFactory().getUserDao().addSport(userEntity, sportEntity);
            } else {
                throw new InvalidSportException(sport);
            }
        } else {
            throw new InvalidUserFieldException(user);
        }
    }
    
    public List<User> getAllUsers() {
        List<User> userList = DaoFactory.getFactory().getUserDao().findAll();
        return userList;
    }
}
