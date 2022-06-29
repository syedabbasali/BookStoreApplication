package com.bookstore.app;

import java.util.Scanner;

import com.bookstore.app.dto.OrderDetials;
import com.bookstore.app.dto.OrderItem;
import com.bookstore.app.service.BookstoreService;


public class MainClass {

	public static void main(String[] args) {
		System.out.println("* * * * * * * * * * * * * * * * * * * * *  * * * * * ");
		System.out.println("***** Welcome to Great Indian Library******** ");
		System.out.println("* * * * * * * * * * * * * * * * * * * * *  * * * * *");

		boolean flag = true;
		Scanner bookscan = new Scanner(System.in);
		while (flag) {
			System.out.println("\r\nPlease proceed with the following instructions:\r\n");
			System.out.println("Press 1 for admin functions");
			System.out.println("Press 2 for customer functions");
			System.out.println("Press 0 for exit");
			BookstoreService service = new BookstoreService();
			String Input1 = bookscan.nextLine();
			switch (Input1) {
			case "1":
				System.out.println("Press 1 for full list of book");
				System.out.println("Press 2 to add book");
				System.out.println("Press 3 to edit book description");
				System.out.println("Press 4 to delete book");
				System.out.println("Press 0 for exit");
				System.out.println("Press 9 for main menu");

				String input2 = bookscan.nextLine();
				switch (input2) {
				case "1":
					System.out.println("Fetching booklist...");
					service.getBookList();
					break;
				case "2":
					System.out.println("Adding book...");
					String name = "";
					System.out.println("Please enter the name of the book: ");
					name += bookscan.nextLine();
					System.out.println("Please enter the price of the book: ");
					String price = bookscan.nextLine();
					try {
						Double.parseDouble(price);
						service.addBook(name, price);
					} catch (Exception e) {
						System.err.println("INVALID INPUT! TRY AGAIN!");
					}
					break;
				case "3":
					System.out.println("Updating item...");
					System.out.println("Please enter the id of the item: ");
					String id = bookscan.nextLine();
					System.out.println("Please enter the name of the item: ");
					name = "";
					name += bookscan.nextLine();
					System.out.println("Please enter the price of the item: ");
					price = bookscan.nextLine();
					System.out.println("Please enter the availibility of the item (Y/N): ");
					String isAvailable = bookscan.nextLine();
					try {
						Integer.parseInt(id);
						Double.parseDouble(price);
						service.updateBook(id, name, price, isAvailable);
					} catch (Exception e) {
						System.err.println("INVALID INPUT! TRY AGAIN!");
					}
					break;
				case "4":
					System.out.println("Deleting item...");
					System.out.println("Please enter the id of the item: ");
					id =bookscan.nextLine();
					try {
						Integer.parseInt(id);
						service.deleteBookList(id);
					} catch (Exception e) {
						System.err.println("INVALID INPUT! TRY AGAIN!");
					}
					break;
				case "9":
					break;
				case "0":
					System.out.println("****THANK YOU. VISIT AGAIN.*****");
					flag = false;
					break;
				default:
					System.out.println("****THANK YOU. VISIT AGAIN.*****");
					flag = false;
					break;
				}
				break;
			case "2":
				System.out.println("Hello, Sir/Mam! Please check BookList and order whatever you need..");
				service.getBookList();
				OrderDetials order = new OrderDetials();
				boolean moreItem = true;
				while (moreItem) {
					OrderItem item = new OrderItem();
					System.out.println("Please enter id of the item: ");
					String id = bookscan.nextLine();
					System.out.println("Please enter quantity of the item: ");
					String quantity = bookscan.nextLine();
					try {
						item.setBookId(null);
						item.setQuantity(Integer.parseInt(quantity));
					} catch (Exception e) {
						System.err.println("INVALID INPUT! TRY AGAIN!");
						break;
					}
					order.getItems().add(item);
					System.out.println("Want to add more item? (Y/N): ");
					String des = bookscan.nextLine();
					if (!"Y".equals(des)) {
						moreItem = false;
					}
				}
				System.out.println("Want take away? (Y/N): ");
				String des = bookscan.nextLine();
				if ("Y".equals(des)) {
					order.setPurchase(true);
				}
				service.generateBills(order);
				System.out.println("****THANK YOU. VISIT AGAIN.*****");
				flag = false;
				break;
			case "0":
				System.out.println("****THANK YOU. VISIT AGAIN.*****");
				flag = false;
				break;
			default:
				System.out.println("****THANK YOU. VISIT AGAIN.*****");
				flag = false;
				break;
			}
		}
		bookscan.close();
	}
}
