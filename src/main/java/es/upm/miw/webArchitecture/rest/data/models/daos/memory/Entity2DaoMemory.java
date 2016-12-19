package es.upm.miw.webArchitecture.rest.data.models.daos.memory;

import es.upm.miw.webArchitecture.rest.business.models.entities.Entity2;
import es.upm.miw.webArchitecture.rest.data.models.daos.Entity2Dao;

public class Entity2DaoMemory extends GenericMemoryDao<Entity2, Integer> implements Entity2Dao {

    @Override
    protected Integer getId(Entity2 entity) {
        return null;
    }

}
