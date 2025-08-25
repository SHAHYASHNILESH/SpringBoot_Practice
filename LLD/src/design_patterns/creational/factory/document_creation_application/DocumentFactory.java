package design_patterns.creational.factory.document_creation_application;

public class DocumentFactory {

	public static Document createDocument(String type) {

		switch (type.toLowerCase()) {
		case "pdf":
			// TODO: Return a new instance of PDFDocument
			return new PDFDocument();

		case "word":
			// TODO: Return a new instance of WordDocument
			return new WordDocument();

		case "html":
			// TODO: Return a new instance of HTMLDocument
			return new HTMLDocument();

		default:
			throw new IllegalArgumentException("Unknown document type: " + type);
		}
	}
}
