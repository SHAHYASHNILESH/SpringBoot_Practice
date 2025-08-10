package design_patterns.behavioural.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookCollectionV2 {
	private List<Book> books = new ArrayList<>();

	public void addBook(Book book) {
		books.add(book);
	}

	public List<Book> getBooks() {
		return books;
	}

	public Iterator<Book> createIterator() {
		return new BookIterator(this.books);
	}

	// Another Class (Nested Class)
	private class BookIterator implements Iterator<Book> {
		private List<Book> books;
		private int position = 0;

		public BookIterator(List<Book> books) {
			this.books = books;
		}

		@Override
		public boolean hasNext() {
			return position < books.size();
		}

		@Override
		public Book next() {
			return books.get(position++);
		}
	}
}