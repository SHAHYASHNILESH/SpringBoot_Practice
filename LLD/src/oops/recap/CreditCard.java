package oops.recap;

public class CreditCard extends Card {

	public CreditCard(String cardNo, String userName) {
		super(cardNo, userName);
	}

	@Override
	public void pay() {
		System.out.println("Making Payment via Credit Card: " + getCardNumber());
	}

}
