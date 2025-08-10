package design_patterns.behavioural.template;

abstract class DataParser {
	public void parse() {
		openFile();
		parseFile();
		closeFile();
	}

	protected void openFile() {
		System.out.println("Opening File");
	}

	protected void closeFile() {
		System.out.println("Closing File");
	}

	abstract void parseFile();
}

class CSVParser extends DataParser {

	@Override
	void parseFile() {
		// TODO Auto-generated method stub
		System.out.println("Parsing CSV File");
	}

}

class JsonParser extends DataParser {

	@Override
	void parseFile() {
		// TODO Auto-generated method stub
		System.out.println("Parsing JSON File");
	}

}

public class WithTemplatePattern {
	public static void main(String[] args) {
		DataParser csvParser = new CSVParser();
		csvParser.parse();

		DataParser jsonParser = new JsonParser();
		jsonParser.parse();
	}
}
