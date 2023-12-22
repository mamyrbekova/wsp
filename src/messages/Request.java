package messages;

import java.io.Serializable;
import java.util.Objects;

import entities.Employee;

public class Request extends Message implements Acceptable, Serializable {
	private int accepted;
	
	{
		accepted = 0;
	}

	public Request() {}
	
	public Request(String title, String message, Employee recipient, Employee sender, Priority priority) {
		super(title, message, recipient, sender);
	}

	public int makeAccepted(int accepted) {
		return this.accepted = accepted;
	}

	@Override
	public int isAccepted() {
		return accepted;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), accepted);
	}

	@Override
	public boolean equals(Object obj) {
		if(!super.equals(obj)) return false;
		Request d = (Request)obj;
		return d.accepted == this.accepted;
	}

	@Override
	public String toString() {
		return super.toString() + (isAccepted()==1 ? "Accepted" : "Rejected");
	}
}
