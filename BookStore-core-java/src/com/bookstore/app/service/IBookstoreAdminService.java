package com.bookstore.app.service;

public interface IBookstoreAdminService {

	public void addBook(String name, String price);
	
	public void updateBook(String id, String name, String price, String isAvailable);
	
	public void getBookList();
	
	public void deleteBookList(String id);

	
	
}
