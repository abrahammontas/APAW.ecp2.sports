package es.upm.miw.webArchitecture.rest.data.models.daos.memory;

import es.upm.miw.webArchitecture.rest.business.models.entities.Entity1;
import es.upm.miw.webArchitecture.rest.data.models.daos.Entity1Dao;

public class Entity1DaoMemory extends GenericMemoryDao<Entity1, Integer> implements Entity1Dao {

    @Override
    protected Integer getId(Entity1 entity) {
        return null;
    }

}
