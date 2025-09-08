package solid_principles.ocp.goodcode;

public class PayPal implements PaymentMethod {

	@Override
	public void pay(double amount) {
		System.out.println("Making Payment via PayPal");
	}
}
