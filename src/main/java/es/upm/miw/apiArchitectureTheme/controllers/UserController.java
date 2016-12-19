package es.upm.miw.apiArchitectureTheme.controllers;

import java.util.List;

import es.upm.miw.apiArchitectureTheme.daos.DaoFactory;
import es.upm.miw.apiArchitectureTheme.entities.Theme;
import es.upm.miw.apiArchitectureTheme.wrappers.OverageWrapper;
import es.upm.miw.apiArchitectureTheme.wrappers.UserListWrapper;
import es.upm.miw.apiArchitectureTheme.wrappers.UserWrapper;

public class UserController {

    public UserListWrapper userList() {
        List<User> userList = DaoFactory.getFactory().getThemeDao().findAll();
        UserListWrapper userListWrapper = new UserListWrapper();
        for (Theme theme : userList) {
            userListWrapper.adduserWrapper(new UserWrapper(user.getNick(), theme.getEmail()));
        }
        return userListWrapper;
    }

    public void createUser(String nick, String email) {
        DaoFactory.getFactory().getThemeDao().create(new User(nick, email));
    }
    
    public UserListWrapper usersBySport(String sport) {
          List<User> users = DaoFactory.getFactory().getUserDao().usersBySport(sport);
          UserListWrapper userListWrapper = new UserListWrapper();
          
          for (User user : users) {
              userListWrapper.addUserWrapper(new UserWrapper(user.getNick(), user.getEmail()));
          }
          
          return userListWrapper;
      }

    //ADD SPORT
}
