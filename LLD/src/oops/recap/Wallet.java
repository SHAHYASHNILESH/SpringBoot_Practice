package oops.recap;

public class Wallet implements PaymentMethod {

	private String walletId;

	public Wallet(String walletId) {
		super();
		this.walletId = walletId;
	}

	public Wallet() {
		super();
	}

	@Override
	public void pay() {
		System.out.println("Making Payment via Wallet: " + walletId);
	}

	@Override
	public String toString() {
		return "Wallet [walletId=" + walletId + "]";
	}

	public String getWalletId() {
		return walletId;
	}

	public void setWalletId(String walletId) {
		this.walletId = walletId;
	}

}
