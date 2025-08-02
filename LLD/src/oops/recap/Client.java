package oops.recap;

public class Client {

	public static void main(String[] args) {
		
		PaymentService ps = new PaymentService();
		ps.addPaymentMethod("YashShahDebitCard", new DebitCard("2345-5556-3333-0488", "Yash Shah"));
		ps.addPaymentMethod("YashShahCreditCard", new CreditCard("5555-6566-7777-0488", "Yash Shah"));
		ps.addPaymentMethod("YashShahUPI", new UPIPayment("yashshah@axiabank"));
		ps.addPaymentMethod("YashShahWallet", new Wallet("1234"));

		ps.makePayment("YashShahUPI");
		ps.makePayment("YashShahWallet");
		ps.makePayment("YashShahCreditCard");
	}
}
