package es.upm.miw.apiArchitectureTheme.daos;

import java.util.List;

import es.upm.miw.apiArchitectureTheme.entities.User;
import es.upm.miw.apiArchitectureTheme.entities.Sport;

public interface UserDao extends GenericDao<User, Integer> {

    public abstract void addSport(String user, String sport);

    public abstract List<User> usersBySport(String sport);

}