package oops_recap;

public class UPIPayment implements PaymentMethod {

	private String upiId;

	public UPIPayment() {
		super();
	}

	public UPIPayment(String upiId) {
		super();
		this.upiId = upiId;
	}

	@Override
	public void pay() {
		System.out.println("Making Payment via UPI:" + upiId);
	}

	public String getUpiId() {
		return upiId;
	}

	public void setUpiId(String upiId) {
		this.upiId = upiId;
	}

	@Override
	public String toString() {
		return "UPIPayment [upiId=" + upiId + "]";
	}

}
