package es.upm.miw.apiArchitectureTheme.daos.memory;

import java.util.HashMap;
import java.util.List;

import es.upm.miw.apiArchitectureTheme.daos.DaoFactory;
import es.upm.miw.apiArchitectureTheme.daos.UserDao;
import es.upm.miw.apiArchitectureTheme.entities.Sport;
import es.upm.miw.apiArchitectureTheme.entities.User;

public class UserDaoMemory extends GenericMemoryDao<User> implements UserDao {

    public UserDaoMemory() {
        this.setMap(new HashMap<Integer, User>());
    }

    @Override
    protected Integer getId(User entity) {
        return entity.getId();
    }

    @Override
    protected void setId(User entity, Integer id) {
        entity.setId(id);
    }
    
    @Override
    public void addSport(String user, String sport) {
        User userEntity = DaoFactory.getFactory().getUserDao().getByName(user);
        this.read(userEntity.getId()).getSports().add(sport);
    }

    @Override
    public List<User> usersBySport(String sport) {
        return null;
    }
}