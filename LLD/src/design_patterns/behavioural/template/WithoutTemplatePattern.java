package design_patterns.behavioural.template;

//CSV Parser
class CSVParser1 {
	public void parse() {
		openFile();
		// CSV Specific Parsing Logic
		System.out.println("Parsing a CSV File");
		closeFile();
	}

	private void openFile() {
		System.out.println("Opening File");
	}

	private void closeFile() {
		System.out.println("Closing File");
	}
}

class JSONParser {
	public void parse() {
		openFile();
		// CSV Specific Parsing Logic
		System.out.println("Parsing a JSON File");
		closeFile();
	}

	private void openFile() {
		System.out.println("Opening File");
	}

	private void closeFile() {
		System.out.println("Closing File");
	}
}

public class WithoutTemplatePattern {
	public static void main(String[] args) {
		CSVParser1 csvParser = new CSVParser1();
		csvParser.parse();
		JSONParser jsonParser = new JSONParser();
		jsonParser.parse();
	}
}
