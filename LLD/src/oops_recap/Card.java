package oops_recap;

abstract public class Card implements PaymentMethod {

	private String cardNumber;
	private String userName;

	public Card() {
		super();
	}

	public Card(String cardNumber, String userName) {
		super();
		this.cardNumber = cardNumber;
		this.userName = userName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "Card [cardNumber=" + cardNumber + ", userName=" + userName + "]";
	}

}
