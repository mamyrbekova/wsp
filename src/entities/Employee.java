package entities;

import java.util.Objects;

import messages.Inbox;
import messages.Message;
import messages.Order;
import messages.Priority;
import messages.Request;

public abstract class Employee extends User {
	private Inbox inbox;
	
	public Employee() {
		
	}
	
	public Employee(String userId, Login login, String email, String name, String surname, Inbox inbox) {
		super(userId, login, email, name, surname);
        this.inbox = inbox;
    }
	
	public Inbox getInbox() {
        return inbox;
    }
	
	public void sendMessages(String title, String message, Employee recipient) {
		Message newMessage = new Message(title, message, recipient, this);
		recipient.getInbox().getReceivedMessages().add(newMessage);
        this.inbox.getSentMessages().add(newMessage);
	}
	
	public void sendRequest(String title, String message, Dean dean, Employee sender, Priority priority) {
		Request request = new Request(title, message, dean, sender, priority);
		dean.getRequests().add(request);
	}
	
	
	
	public void sendOrder(String title, String message, TechSupport techSupport) {
		Order order = new Order(title, message, techSupport, this);
        techSupport.addOrder(order);
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(inbox);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(inbox, other.inbox);
	}

	public void setInbox(Inbox inbox) {
		this.inbox = inbox;
	}

	@Override
	public String toString() {
		return "Employee [inbox=" + inbox + "]";
	}
}

