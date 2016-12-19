package es.upm.miw.apiArchitectureTheme.daos.memory;

import es.upm.miw.apiArchitectureTheme.daos.DaoFactory;
import es.upm.miw.apiArchitectureTheme.daos.UserDao;
import es.upm.miw.apiArchitectureTheme.daos.SportDao;

public class DaoFactoryMemory extends DaoFactory {

	private UserDao userDao;
	private SportDao sportDao;

	public DaoFactoryMemory() {
	}

	@Override
	public UserDao getUserDao() {
		if (userDao == null) {
		    userDao = new UserDaoMemory();
		}
		return userDao;
	}

	@Override
	public SportDao getSportDao() {
		if (sportDao == null) {
		    sportDao = new SportDaoMemory();
		}
		return sportDao;
	}

}
