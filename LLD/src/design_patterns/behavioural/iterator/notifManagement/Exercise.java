package design_patterns.behavioural.iterator.notifManagement;

import java.util.Scanner;

public class Exercise {

	// Do not modify the run method. It is designed to handle user input and manage
	// the notification workflow.
	public void run() {

		Scanner sc = new Scanner(System.in);
		NotificationManager notificationManager = new NotificationManager();

		// Add Notifications
		for (int i = 0; i < 2; i++) {
			String emailNotification = sc.nextLine();
			String smsNotification = sc.nextLine();
			String pushNotification = sc.nextLine();

			notificationManager.addEmailNotification(emailNotification);
			notificationManager.addSMSNotification(smsNotification);
			notificationManager.addPushNotification(pushNotification);
		}

		// Print all notifications
		// TODO: Use notificationManager to display all the added notifications by
		// invoking the method that prints them.
		notificationManager.printAllNotifications();

		sc.close();
	}
}
