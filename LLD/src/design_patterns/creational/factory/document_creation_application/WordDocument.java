package design_patterns.creational.factory.document_creation_application;

public class WordDocument extends Document {

	@Override
	public void displayType() {
		System.out.println("Creating a Word Document");
	}
}
