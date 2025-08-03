package solid.principles.dip.goodcode;

public class NotificationService {
	private NotificationChannel notificationChannel;

	public NotificationService(NotificationChannel channel) {
		this.notificationChannel = channel;
	}

	public void notify(String msg) {
		notificationChannel.send(msg);
	}
}