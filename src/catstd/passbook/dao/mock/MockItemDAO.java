package catstd.passbook.dao.mock;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import catstd.passbook.dao.ItemDAO;
import catstd.passbook.dao.ItemSearchCriteria;
import catstd.passbook.dao.PersistanceException;
import catstd.passbook.dao.dto.Item;

public class MockItemDAO implements ItemDAO {

    private static Set<Item> memoryStorage = new HashSet<Item>();
    private static long nextId = 0;
    
	public void persist(Item item) throws PersistanceException {
	    if(memoryStorage.contains(item)) {
            memoryStorage.add(item);
        } else {
            item.setId(nextId++);
            memoryStorage.add(item);
        }
	}

	public void delete(Item item) throws PersistanceException {
	    memoryStorage.remove(item);
	}

	public List<Item> find(ItemSearchCriteria criteria) throws PersistanceException {
	    List<Item> items = new ArrayList<Item>();
	    for(Item item : memoryStorage) {
	        if(criteria.getUserId() != null && !criteria.getUserId().equals(item.getOwner().getId())) {
	            continue;
	        }
	        if(criteria.getItemId() != null && !criteria.getItemId().equals(item.getId())) {
	            continue;
	        }
	        items.add(item);
	    }
		return items;
	}

}
