package catstd.passbook.dao;

import java.util.List;

import catstd.passbook.dao.dto.Item;

public interface ItemDAO {

	/**
	 * Insert or update item to storage
	 * @param item
	 * @throws PersistanceException
	 */
	void persist(Item item) throws PersistanceException;

	/**
	 * Delete item from storage
	 * @param item
	 * @throws PersistanceException
	 */
	void delete(Item item) throws PersistanceException;
	
	/**
	 * Find items from storage matching criteria
	 * @param criteria
	 * @return list of items
	 * @throws PersistanceException
	 */
	List<Item> find(ItemSearchCriteria criteria) throws PersistanceException;
	
}
