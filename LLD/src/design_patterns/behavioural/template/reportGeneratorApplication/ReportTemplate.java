package design_patterns.behavioural.template.reportGeneratorApplication;

public abstract class ReportTemplate {

	// Template method defining the skeleton of the report generation
	public final void generateReport() {
		gatherData(); // Specific to each report
		processData(); // Specific to each report
		formatReport(); // Common across all reports
		printReport(); // Common across all reports
	}

	// Steps to be implemented by subclasses
	protected abstract void gatherData();

	protected abstract void processData();

	// Default methods that can be common across all reports
	protected void formatReport() {
		System.out.println("Formatting the report with appropriate layout and style.");
	}

	protected void printReport() {
		System.out.println("Printing the report for final review and distribution.");
	}
}