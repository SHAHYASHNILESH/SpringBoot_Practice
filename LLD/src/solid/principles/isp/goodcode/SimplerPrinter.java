package solid.principles.isp.goodcode;

import solid.principles.isp.badcode.Document;

public class SimplerPrinter implements Printer {
	@Override
	public void print(Document doc) {
		System.out.println("Printing the document");
	}
}