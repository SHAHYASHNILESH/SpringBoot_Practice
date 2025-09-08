package oops_recap;

import java.util.HashMap;
import java.util.Map;

public class PaymentService {

	Map<String, PaymentMethod> paymentMethods;

	public PaymentService() {
		this.paymentMethods = new HashMap<String, PaymentMethod>();
	}

	public void addPaymentMethod(String name, PaymentMethod pm) {
		paymentMethods.put(name, pm);
	}

	public void makePayment(String name) {
		// Runtime Polymorphism -> at runtime, pay() method of specific payment method
		// is called
		System.out.println(paymentMethods.get(name));
		paymentMethods.get(name).pay();
	}
}
