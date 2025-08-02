package solid.principles.srp.goodcode;

public class InvoiceWithSRP {
	private double amount;

	public InvoiceWithSRP(double amount) {
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void generateInvoice() {
		System.out.println("Invoice generated for amount: " + amount);
	}
}
