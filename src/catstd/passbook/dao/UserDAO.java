package catstd.passbook.dao;

import catstd.passbook.dao.dto.User;

public interface UserDAO {

	/**
	 * Insert or update user.
	 * If user inserted, then set his ID to dto-object
	 * @param user - user object to persist
	 * @throws PersistanceException
	 */
	void persist(User user) throws PersistanceException;
	
	/**
	 * Delete user from storage
	 * @param user - user object to delete
	 * @throws PersistanceException
	 */
	void delete(User user) throws PersistanceException;
	
	/**
	 * Get user from storage
	 * @param username
	 * @param password
	 * @return UserDTO
	 * @throws PersistanceException
	 * @throws ValidationException if username/password incorrect
	 */
	User get(String username, String password) throws PersistanceException, ValidationException;
	
}
