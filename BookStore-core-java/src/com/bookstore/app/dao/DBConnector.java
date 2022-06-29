package com.bookstore.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.app.constants.IConstants;
import com.bookstore.app.dto.BookList;


public class DBConnector {

	
	protected boolean addBookInList(BookList book) {
		boolean isCreated=false;
		try {
			Connection connection = establishConnection();
			Statement statement = connection.createStatement();
			StringBuilder query = new StringBuilder(
					"insert into bookstore values (nextval('bookstore_tbl_seq'),'");
			query.append(book.getBookName() + "',");
			query.append(book.getItemPrice() + ",");
			query.append((book.getIsAvailable() ? 0 : 1) + ");");
			System.out.println(query.toString());			
			statement.execute(query.toString());
			isCreated= true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isCreated;
	}
	protected List<BookList> getBooklist() {
		List<BookList> bookList = new ArrayList<>();	
		try {
			Connection connection = establishConnection();
			Statement statement = connection.createStatement();
			ResultSet results = statement.executeQuery("select * from bookstore;");
			while (results.next()) {
				BookList book= new BookList();
				book.setBookId(results.getInt(1));
				book.setBookName(results.getString(2));
				book.setItemPrice(results.getDouble(3));
				int flag = results.getInt(4);
				if (flag == 0) {
					book.setIsAvailable(true);
				} else {
					book.setIsAvailable(false);
				}
				bookList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookList;
	}
	
	protected boolean updateBookInBookList(BookList item) {
		boolean isCreated = false;
		try {
			Connection connection = establishConnection();
			Statement statement = connection.createStatement();
			StringBuilder query = new StringBuilder("update bookstore set item_name=");
			query.append(item.getBookName() + "',");
			query.append("item_price=");
			query.append(item.getItemPrice() + ",");
			query.append("available=");
			query.append((item.getIsAvailable() ? 0 : 1));
			query.append(" where book_id=" + item.getBookId() + ";");
			isCreated = true;
			statement.execute(query.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isCreated;
	}
	protected boolean deleteItemFromBookLsit(Integer itemId) {
		boolean isCreated = false;
		try {
			Connection connection = establishConnection();
			Statement statement = connection.createStatement();
			StringBuilder query = new StringBuilder("delete from bookList where item_id=");
			query.append(itemId + ";");
			statement.execute(query.toString());
			isCreated = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isCreated;
	}
	
	
	


	private Connection establishConnection() {
		Connection connection = null;
		
		try {
			Class.forName(IConstants.DB_DRIVER);
			connection = DriverManager.getConnection(IConstants.DB_URL, IConstants.DB_USER, IConstants.DB_PASS);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return connection;

		
		
		
		
	}
	
	
	
}
