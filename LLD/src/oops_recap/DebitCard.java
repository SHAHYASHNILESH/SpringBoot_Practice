package oops_recap;

public class DebitCard extends Card {

	public DebitCard(String cardNo, String userName) {
		super(cardNo, userName);
	}

	@Override
	public void pay() {
		System.out.println("Making Payment via Debit Card.....");
	}

}
