package catstd.passbook.dao.mock;

import java.util.HashSet;
import java.util.Set;

import catstd.passbook.dao.PersistanceException;
import catstd.passbook.dao.UserDAO;
import catstd.passbook.dao.ValidationException;
import catstd.passbook.dao.dto.User;

public class MockUserDAO implements UserDAO {

	private static Set<User> memoryStorage = new HashSet<User>();
	private static long nextId = 0;
	
	public void persist(User user) throws PersistanceException {
		if(memoryStorage.contains(user)) {
			memoryStorage.add(user);
		} else {
			user.setId(nextId++);
			memoryStorage.add(user);
		}
	}

	public void delete(User user) throws PersistanceException {
		memoryStorage.remove(user);
	}

	public User get(String username, String password) throws PersistanceException, ValidationException {
		for(User user : memoryStorage) {
		    if(user.getUsername().equals(username)) {
		        if(user.getPassword().equals(password)) {
		            return user;
		        }
		        break;
		    }
		}
		throw new ValidationException("Username or Password incorrect");
	}

}
