/**
 * 
 */
package com.bookstore.app.dto;

import java.util.ArrayList;
import java.util.List;

import com.bookstore.app.dto.OrderItem;

/**
 * @author syedabbasali
 *
 */
public final class OrderDetials {
	
	
	private List<OrderItem> items = new ArrayList<OrderItem>();

	private boolean isPurchase = false;
	
	
	

	/**
	 * @return the items
	 */
	public List<OrderItem> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	/**
	 * @return the isPurchase
	 */
	public boolean isPurchase() {
		return isPurchase;
	}

	/**
	 * @param isPurchase the isPurchase to set
	 */
	public void setPurchase(boolean isPurchase) {
		this.isPurchase = isPurchase;
	}

	public String toString() {
		return "OrderDetails [items=" + items + ", isPurchase=" + isPurchase + "]";
	}
}
