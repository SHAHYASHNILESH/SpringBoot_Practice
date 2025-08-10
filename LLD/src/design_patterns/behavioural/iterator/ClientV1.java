package design_patterns.behavioural.iterator;

public class ClientV1 {
	public static void main(String[] args) {
		BookCollectionV1 bookCollection = new BookCollectionV1();
		bookCollection.addBook(new Book("C++ Book"));
		bookCollection.addBook(new Book("Java Book"));
		bookCollection.addBook(new Book("Python Book"));

		for (int i = 0; i < bookCollection.getBooks().size(); i++) {
			System.out.println(bookCollection.getBooks().get(i));
		}
	}
}
