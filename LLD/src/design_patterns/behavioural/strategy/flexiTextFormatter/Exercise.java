package design_patterns.behavioural.strategy.flexiTextFormatter;

import java.util.Scanner;

public class Exercise {

	// Do not modify the run method. It facilitates the formatting process of a
	// document using different formatting strategies.
	public void run() {

		Scanner sc = new Scanner(System.in);
		Document document = new Document();

		String userInput = sc.nextLine();
		document.setContent(userInput);

		// Using PlainTextFormatter
		// TODO: Set the formatter for the document to PlainTextFormatter.
		document.setFormatter(new PlainTextFormatter());

		System.out.println("Plain Text:");
		document.display();

		// Using HTMLFormatter
		// TODO: Set the formatter for the document to HTMLFormatter.
		document.setFormatter(new HTMLFormatter());
		System.out.println("HTML Format:");
		document.display();

		// Using MarkdownFormatter
		// TODO: Set the formatter for the document to MarkdownFormatter.
		document.setFormatter(new MarkdownFormatter());
		System.out.println("Markdown Format:");
		document.display();

		sc.close();
	}
}