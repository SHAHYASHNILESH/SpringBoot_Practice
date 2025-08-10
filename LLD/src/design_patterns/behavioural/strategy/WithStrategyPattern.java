package design_patterns.behavioural.strategy;

interface PaymentMethod {
	void processPay();
}

class CreditCard implements PaymentMethod {

	@Override
	public void processPay() {
		// TODO Auto-generated method stub
		System.out.println("Making Payment via Credit Card");
	}

}

class DebitCard implements PaymentMethod {

	@Override
	public void processPay() {
		// TODO Auto-generated method stub
		System.out.println("Making Payment via Debit Card");
	}

}

class UPI implements PaymentMethod {

	@Override
	public void processPay() {
		// TODO Auto-generated method stub
		System.out.println("Making Payment via UPI");
	}

}

class PaymentService {
	private PaymentMethod strategy;

	public void setStrategy(PaymentMethod s) {
		this.strategy = s;
	}

	public void pay() {
		strategy.processPay();
	}
}

public class WithStrategyPattern {
	public static void main(String[] args) {
		PaymentService paymentService = new PaymentService();
		paymentService.setStrategy(new CreditCard());
		paymentService.pay();

		paymentService.setStrategy(new UPI());
		paymentService.pay();
	}
}
