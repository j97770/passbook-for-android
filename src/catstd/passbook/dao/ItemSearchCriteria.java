package catstd.passbook.dao;

import java.io.Serializable;

public class ItemSearchCriteria implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long userId;
	private Long itemId;
	
	public ItemSearchCriteria() {}
	
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public Long getItemId() {
		return itemId;
	}
	
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

}
