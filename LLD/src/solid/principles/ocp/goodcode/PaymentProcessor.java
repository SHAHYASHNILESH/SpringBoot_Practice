package solid.principles.ocp.goodcode;

public class PaymentProcessor {
	public void processPayment(PaymentMethod paymentMethod, double amount) {
		paymentMethod.pay(amount);
	}
}
