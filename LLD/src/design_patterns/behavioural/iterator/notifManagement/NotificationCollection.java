package design_patterns.behavioural.iterator.notifManagement;

import java.util.Iterator;

public interface NotificationCollection {
	public Iterator<Notification> createIterator();
}
