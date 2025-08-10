package design_patterns.behavioural.strategy.flexiTextFormatter;

public class Document {

	private String content;
	private TextFormatter formatter;

	public void setContent(String content) {
		this.content = content;
	}

	public void setFormatter(TextFormatter formatter) {
		this.formatter = formatter;
	}

	public void display() {
		// TODO: Print the formatted content using the chosen formatter.
		System.out.println(formatter.format(content));
	}
}
