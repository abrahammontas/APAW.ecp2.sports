package es.upm.miw.webArchitecture.rest.data.models.daos.memory;

import es.upm.miw.webArchitecture.rest.data.models.daos.DaoFactory;
import es.upm.miw.webArchitecture.rest.data.models.daos.Entity1Dao;
import es.upm.miw.webArchitecture.rest.data.models.daos.Entity2Dao;

public class DaoFactoryMemory extends DaoFactory {

    public DaoFactoryMemory() {
    }

    @Override
    public Entity1Dao getEntity1Dao() {
        // TODO Auto-generated method stub
        return new Entity1DaoMemory();
    }

    @Override
    public Entity2Dao getEntity2Dao() {
        return new Entity2DaoMemory();
    }

}
