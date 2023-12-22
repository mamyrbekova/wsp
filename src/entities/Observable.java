package entities;

import java.util.Vector;

import messages.Notification;

public class Observable {
	private Vector<Observer> subscribers;
	{
		subscribers = new Vector<Observer>();
	}
	
	public void addSubscriber(Observer subscriber) {
		subscribers.add(subscriber);
	}
	
	public void removeSubscriber(Observer subscriber) {
		subscribers.remove(subscriber);
	}
	
	public void notifySubscribers(Notification notification) {
		for(Observer subscribers : subscribers) {
			subscribers.notifyNewPaper(notification);
			System.out.println("+1 new notification");
		}
	}

	public Vector<Observer> getSubscribers() {
		return subscribers;
	}

	public void setSubscribers(Vector<Observer> subscribers) {
		this.subscribers = subscribers;
	}
}
