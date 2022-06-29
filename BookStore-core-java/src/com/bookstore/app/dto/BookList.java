package com.bookstore.app.dto;

public class BookList {

	private Integer bookId = null;
	
	private String bookName = null;
	
	private Double bookPrice = null;
	
	private Boolean isAvailable = null ;
	
	
	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Double getItemPrice() {
		return bookPrice;
	}

	public void setItemPrice(Double double1) {
		this.bookPrice = double1;
	}

	public boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(boolean b) {
		this.isAvailable = b;
	}

	@Override
	public String toString() {
		return "BookList [bookId=" + bookId + ", bookName=" + bookName + ", itemPrice=" + bookPrice + ", isAvailable="
				+ isAvailable + "]";
	}
	
}
