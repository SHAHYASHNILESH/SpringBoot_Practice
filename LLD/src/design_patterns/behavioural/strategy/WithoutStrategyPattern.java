package design_patterns.behavioural.strategy;

class PaymentServiceWithoutStrategy {
	public void processPayment(String paymentMethod) {
		if (paymentMethod.equals("Credit Card")) {
			System.out.println("Making payment via credit card");
		} else if (paymentMethod.equals("Debit Card")) {
			System.out.println("Making payment via debit card");
		} else if (paymentMethod.equals("UPI")) {
			// huge algorithm
			System.out.println("Making payment via UPI");
		} else {
			System.out.println("Unsupported Payment method");
		}
	}
}

public class WithoutStrategyPattern {
	public static void main(String[] args) {
		PaymentServiceWithoutStrategy paymentService = new PaymentServiceWithoutStrategy();
		paymentService.processPayment("UPI");
	}
}