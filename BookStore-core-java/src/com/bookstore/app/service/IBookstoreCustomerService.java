package com.bookstore.app.service;

import com.bookstore.app.dto.OrderDetials;

/**
 * @author syedabbasali
 *
 */
public interface IBookstoreCustomerService {
	public void generateBills(OrderDetials order);
	

}
