package design_patterns.behavioural.template.reportGeneratorApplication;

import java.util.Scanner;

public class Exercise {

	// Do not modify the run method. It manages the report generation process for
	// various report types.
	public void run() {

		Scanner sc = new Scanner(System.in);

		// Generate Sales Report
		ReportTemplate salesReport = new SalesReport(sc);
		System.out.println("Generating Sales Report:");

		// TODO: Generate the Sales Report by calling the generateReport() method.
		salesReport.generateReport();

		// Generate Employee Report
		ReportTemplate employeeReport = new EmployeeReport(sc);
		System.out.println("Generating Employee Report:");

		// TODO: Generate the Employee Report by calling the generateReport() method.
		employeeReport.generateReport();

		// Generate Inventory Report
		ReportTemplate inventoryReport = new InventoryReport(sc);
		System.out.println("Generating Inventory Report:");

		// TODO: Generate the Inventory Report by calling the generateReport() method.
		inventoryReport.generateReport();

	}
}