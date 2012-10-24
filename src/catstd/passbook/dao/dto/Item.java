package catstd.passbook.dao.dto;

import java.io.Serializable;

public class Item implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long id;
	private User owner;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	@Override
	public int hashCode() {
		return Long.valueOf(id).hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Item) {
			Item o = (Item) obj;
			return this.id == o.id;
		}
		return false;
	}
	
}
