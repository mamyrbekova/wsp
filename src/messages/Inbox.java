package messages;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import java.util.Vector;

public class Inbox  implements Serializable {
	private Vector<Message> receivedMessages;
	private Vector<Message> sentMessages;

	{
		receivedMessages = new Vector<Message>();
		sentMessages = new Vector<Message>();
	}

	public Inbox() {}

	public String viewReceivedMessages(Comparator<Message> c) {
		receivedMessages.sort(c);
		String result = "Received messages: ";
		for (Message m: receivedMessages) {
			result += "\n" + m;
		}
		return result;
	}

	public String viewReceivedMessages() {
		return viewReceivedMessages(new CompareByDate());
	}


	public String viewSentMessages(Comparator<Message> c) {
		sentMessages.sort(c);
		String result = "Sent messages: ";
		for (Message m: sentMessages) {
			result += "\n" + m;
		}
		return result;
	}

	public String viewSentMessages() {
		return viewSentMessages(new CompareByDate());
	}


	@Override
	public int hashCode() {
		return Objects.hash(receivedMessages, sentMessages);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inbox other = (Inbox) obj;
		return Objects.equals(receivedMessages, other.receivedMessages)
				&& Objects.equals(sentMessages, other.sentMessages);
	}

	public String toString() {
		return viewReceivedMessages() + "\n" + viewSentMessages();
	}

	public Vector<Message> getReceivedMessages() {
		return receivedMessages;
	}

	public Vector<Message> getSentMessages() {
		return sentMessages;
	}

	public void setReceivedMessages(Vector<Message> receivedMessages) {
		this.receivedMessages = receivedMessages;
	}
	public void setSentMessages(Vector<Message> sentMessages) {
		this.sentMessages = sentMessages;
	}

}
