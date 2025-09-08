package design_patterns.structural.facade.problem;

// Microservice for Payment Processing
class PaymentService {
    public String processPayment(String paymentId) {
        // Simulate payment processing
        return "Processing payment with paymentId: " + paymentId;
    }
}