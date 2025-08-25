package design_patterns.creational.factory.document_creation_application;

public class PDFDocument extends Document {

	@Override
	public void displayType() {
		System.out.println("Creating a PDF Document");
	}
}
