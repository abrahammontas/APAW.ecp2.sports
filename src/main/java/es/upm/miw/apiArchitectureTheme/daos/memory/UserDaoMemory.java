package es.upm.miw.apiArchitectureTheme.daos.memory;

import java.util.HashMap;

import es.upm.miw.apiArchitectureTheme.daos.User;
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
    protected String getName(User entity) {
        return entity.getName();
    }

    @Override
    protected void setName(User entity, String name) {
        entity.setName(name);

    }
    
    @Override
    public void addSport(User entity, Sport sport) {
        this.read(entity.getId()).getSports().add(sport);
    }

    @Override
    public List<User> usersBySport(String sport) {
        
    }
}