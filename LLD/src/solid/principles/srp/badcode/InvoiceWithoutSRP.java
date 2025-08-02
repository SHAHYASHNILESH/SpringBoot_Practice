package solid.principles.srp.badcode;

public class InvoiceWithoutSRP {

	private double amount;

	public InvoiceWithoutSRP(double amount) {
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

	public void saveInvoiceToDB() {
		System.out.println("Saving invoice to DB for amount: " + amount);
	}

	public void sendEmailInvoiceToCustomer() {
		System.out.println("Sending invoice to customer for amount: " + amount);
	}
}
