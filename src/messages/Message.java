package messages;

import java.io.Serializable;
import java.util.Objects;

import entities.Employee;

public class Message extends TextContainer implements Serializable {
	private Employee recipient;
	private Employee sender;

	public Message() {}
	
	public Message(String title, String message, Employee recipient, Employee sender) {
		super(title, message);
		this.recipient = recipient;
		this.sender = sender;
	}

	public Employee getRecipient() {
		return recipient;
	}

	public void setRecipient(Employee recipient) {
		this.recipient = recipient;
	}

	public Employee getSender() {
		return sender;
	}

	public void setSender(Employee sender) {
		this.sender = sender;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), recipient, sender);
	}

	@Override
	public boolean equals(Object obj) {
		if(!super.equals(obj)) return false;
		Message d = (Message)obj;
		return d.recipient.equals(this.recipient) && d.sender.equals(this.sender);
	}

	@Override
	public String toString() {
		return "Recipient: " + getRecipient() + "\nSender=" + getSender() + "\n" + super.toString();
	}
	

}
