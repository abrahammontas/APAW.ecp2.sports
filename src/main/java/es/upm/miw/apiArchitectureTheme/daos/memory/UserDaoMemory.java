package es.upm.miw.apiArchitectureTheme.daos.memory;

import java.util.HashMap;
import java.util.List;

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
    public void addSport(User entity, Sport sport) {
        this.read(entity.getId()).getSports().add(sport);
    }

    @Override
    public List<User> usersBySport(String sport) {
        return null;
    }

    @Override
    public User getByName(String name) {
        List<User> users = this.findAll();
        User result = null;
        
        for (User user : users) {
            if (user.getNick().equals(name)) {
                result = user;
            }
        }
        
        return result;
    }
}