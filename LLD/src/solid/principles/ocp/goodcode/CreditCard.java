package solid.principles.ocp.goodcode;

public class CreditCard implements PaymentMethod {

	@Override
	public void pay(double amount) {
		System.out.println("Making Payment via Credit Card: " + amount);
	}
}
