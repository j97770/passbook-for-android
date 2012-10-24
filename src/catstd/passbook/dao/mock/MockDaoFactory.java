package catstd.passbook.dao.mock;

import catstd.passbook.dao.DaoFactory;
import catstd.passbook.dao.ItemDAO;
import catstd.passbook.dao.UserDAO;

public class MockDaoFactory extends DaoFactory {

	private UserDAO userDAO;
	private ItemDAO itemDAO;
	
	public MockDaoFactory() {
		userDAO = new MockUserDAO();
		itemDAO = new MockItemDAO();
	}
	
	@Override
	public UserDAO getUserDAO() {
		return userDAO;
	}

	@Override
	public ItemDAO getItemDAO() {
		return itemDAO;
	}

}
