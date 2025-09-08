package solid_principles.dip.goodcode;

public class SMSService implements NotificationChannel {
	@Override
	public void send(String msg) {
		System.out.println("Sending SMS " + msg);
	}
}
