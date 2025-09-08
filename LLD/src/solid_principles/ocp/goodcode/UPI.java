package solid_principles.ocp.goodcode;

public class UPI implements PaymentMethod {

	@Override
	public void pay(double amount) {
		System.out.println("Making payment via UPI: " + amount);
	}
}