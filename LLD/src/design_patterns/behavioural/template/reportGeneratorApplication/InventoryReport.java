package design_patterns.behavioural.template.reportGeneratorApplication;

import java.util.Scanner;

public class InventoryReport extends ReportTemplate {
    
    private Scanner sc;

    public InventoryReport(Scanner sc) {
        this.sc = sc;
    }
    
    @Override
    protected void gatherData() {
        String gatherData = sc.nextLine();
        System.out.println(gatherData);
    }

    @Override
    protected void processData() {
        String processData = sc.nextLine();
        System.out.println(processData);
    }
}