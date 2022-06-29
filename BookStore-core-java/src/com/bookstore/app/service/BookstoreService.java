/**
 * 
 */
package com.bookstore.app.service;

import com.bookstore.app.constants.IConstants;

import java.util.List;

import com.bookstore.app.dto.*;

import com.bookstore.app.dao.DBConnector;

/**
 * @author syedabbasali
 *
 */
public class BookstoreService extends DBConnector implements IBookstoreAdminService, IBookstoreCustomerService {

	@Override
	public void addBook(String name, String price) {
		BookList book = new BookList();
		book.setBookName(name);
		book.setItemPrice(Double.valueOf(price));
		book.setIsAvailable(true);
		boolean isAdded = addBookInList(book);
		System.out.println(isAdded ? "Item added succesfully" : "Sorry! Internal error occured! Please try again!");
	}

	@Override
	public void updateBook(String id, String name, String price, String isAvailable) {
		BookList book = new BookList();
		book.setBookId(Integer.parseInt(id));
		book.setBookName(name);
		book.setItemPrice(Double.valueOf(price));
		book.setIsAvailable(isAvailable.equals("Y") ? true : false);
		boolean isCreated = updateBookInBookList(book);
		System.out.println(isCreated ? "Item updated succesfully" : "Sorry! Internal error occured! Please try again!");

	}
	
	@Override
	public void getBookList() {
			for (BookList book : getBooklist()) {
				System.out.println(book);
			}
	}
	
	@Override
	public void deleteBookList(String id) {
			boolean isCreated = deleteBookFromBookList(Integer.parseInt(id));
				System.out.println(isCreated ? "Item deleted succesfully" : "Sorry! Internal error occured! Please try again!");
			}
		


	private boolean deleteBookFromBookList(int parseInt) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void generateBills(OrderDetials order) {
		double total = 0;
		if (order != null && !order.getItems().isEmpty()) {
			List<BookList> bookList = getBooklist();
			for (OrderItem orderItem : order.getItems()) {
				int quantity = orderItem.getQuantity();
				double price = 0;
				String name = null;
				for (BookList item : bookList) {
					if (item.getBookId().equals(orderItem.getBookId())) {
						name = item.getBookName();
						if (item.getIsAvailable()) {
							price = item.getItemPrice();
							break;
						}
					}
				}
				if (price == 0 && name != null) {
					name += "-Item Not Available";
				}
				if (name == null) {
					name = "Item Not Available with Id" + orderItem.getBookId();
				}
				System.out.println(name + "\t" + quantity + "*" + price + " = " + (quantity * price));
				total = total + (quantity * price);
			}
			if (order.isPurchase()) {
				System.out.println("Packing charges: \t" + IConstants.PACKING_CHARGES);
				total = total + IConstants.PACKING_CHARGES;
			}
			System.out.println("-------------------------------------------");
			System.out.println("Total: " + total);
		}
	}


	}



