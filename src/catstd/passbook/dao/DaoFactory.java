package catstd.passbook.dao;

import catstd.passbook.dao.mock.MockDaoFactory;


public abstract class DaoFactory {

	public static final int SQLITE = 1;
	public static final int MOCK = 2;
	
	public static DaoFactory newInstance(int type) throws InstantiationException {
		switch(type) {
			case SQLITE:
				return null;
			case MOCK:
				return new MockDaoFactory();
		}
		throw new InstantiationException("Can't find instance class for type " + Integer.toString(type));
	}
	
	public abstract UserDAO getUserDAO();
	
	public abstract ItemDAO getItemDAO();
	
}
