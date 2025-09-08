package design_patterns.structural.facade.solution;

// Microservice for Order Management
class OrderService {
    public String getOrderDetails(String orderId) {
        // Simulate fetching order details
        return "Order details for orderId: " + orderId;
    }
}