package messages;

import java.io.Serializable;
import java.util.Objects;

import entities.Employee;

public class Complaint extends Message implements Acceptable, Comparable<Complaint>, Serializable {
	private Priority priority;
	private int accepted;
	
	{
		accepted = 0;
	}
	
	public Complaint() {
	}
	
	public Complaint(String title, String message, Employee recipient, Employee sender, Priority priority) {
		super(title, message, recipient, sender);
		this.priority = priority;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public int isAccepted() {
		return accepted;
	}


	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), priority, accepted);
	}

	@Override
	public boolean equals(Object obj) {
		if(!super.equals(obj)){
			return false;
		};
		Complaint d = (Complaint)obj;
		return d.priority == this.priority && d.accepted == this.accepted;
	}

	@Override
	public String toString() {
		return super.toString() + "\nPriority of complaint: " + getPriority() + (isAccepted()==1 ? "Accepted" : "Rejected");
	}

	@Override
	public int compareTo(Complaint o) {
		return priority.compareTo(o.priority);
	}

	@Override
	public int makeAccepted(int accepted) {
		return this.accepted = accepted;
	}

}
