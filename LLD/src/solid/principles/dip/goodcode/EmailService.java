package solid.principles.dip.goodcode;

public class EmailService implements NotificationChannel {
	@Override
	public void send(String msg) {
		System.out.println("Sending Email " + msg);
	}
}
