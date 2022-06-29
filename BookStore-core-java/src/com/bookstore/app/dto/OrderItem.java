/**
 * 
 */
package com.bookstore.app.dto;

/**
 * @author syedabbasali
 *
 */
public final class OrderItem {
	
	private Integer bookId = null;
	
	private Integer quantity = null;
	

	/**
	 * @return the bookId
	 */
	public Integer getBookId() {
		return bookId;
	}

	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderItems [bookId=" + bookId + ", quantity=" + quantity + "]";
	}

}
