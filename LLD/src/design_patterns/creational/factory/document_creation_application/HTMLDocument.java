package design_patterns.creational.factory.document_creation_application;

public class HTMLDocument extends Document {

	@Override
	public void displayType() {
		System.out.println("Creating an HTML Document");
	}
}
