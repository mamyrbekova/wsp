package messages;

import java.io.Serializable;
import java.util.Objects;

import entities.Employee;

public class Order extends Message implements Comparable<Order>, Serializable {
	private State state;
	
	{
		state = State.NEW;
	}

	public Order() {
	}
	
	public Order(String title, String message, Employee recipient, Employee sender) {
		super(title, message, recipient, sender);
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), state);
	}

	@Override
	public boolean equals(Object obj) {
		if(!super.equals(obj)) return false;
		Order other = (Order) obj;
		return this.state == other.state;
	}

	@Override
	public String toString() {
		return super.toString() + "State of order: " + getState();
	}

	@Override
	public int compareTo(Order o) {
		return state.compareTo(o.state);
	}

}
