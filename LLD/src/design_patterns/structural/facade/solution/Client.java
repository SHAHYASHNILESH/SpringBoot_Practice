package design_patterns.structural.facade.solution;

public class Client {
    public static void main(String[] args) {
        // Client code interacting with API Gateway (Facade)
        APIGateway apiGateway = new APIGateway();
        //Task
        System.out.println(apiGateway.getFullOrderDetails("123", "456", "789"));
    }
}