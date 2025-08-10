package design_patterns.behavioural.iterator;

import java.util.Iterator;

public class ClientV2 {
	public static void main(String[] args) {
		BookCollectionV2 bookCollection = new BookCollectionV2();
		bookCollection.addBook(new Book("C++ Book"));
		bookCollection.addBook(new Book("Java Book"));
		bookCollection.addBook(new Book("Python Book"));

		Iterator<Book> iterator = bookCollection.createIterator();
		while (iterator.hasNext()) {
			Book book = iterator.next();
			System.out.println(book);
		}
	}
}