package entities;


import java.io.*;
import java.util.*;
import java.lang.System;
import java.util.stream.Collectors;

import messages.Inbox;
import messages.Order;
import messages.State;

public class TechSupport extends Employee implements Serializable {
	private Vector<Order> techSupportOrders;;
	
	{
		techSupportOrders = new Vector<Order>();
	}
	
	public TechSupport() {}
	
	public TechSupport(String userId, Login login, String email, String name, String surname, Inbox inbox) {
		super(userId, login, email, name, surname, inbox);
	}
	
	private void viewOrders(State state) {
		for(Order i: techSupportOrders) {
			if (i.getState() == state) {
				System.out.println(i.toString());
			}
		}
	}
	
	public void viewNewOrders() {
		viewOrders(State.NEW);
	}
	
	public void viewAcceptedOrders() {
		viewOrders(State.ACCEPTED);
	}
	
	public void viewDoneOrders() {
		viewOrders(State.DONE);
	}
	
	public void viewRejectedOrders() {
		viewOrders(State.REJECTED);
	}
	
	public void addOrders(Order o) {
		techSupportOrders.add(o);
	}
	
	public void setOrderAsDone(Order o) {
		o.setState(State.DONE);
	}
	
	public Vector<Order> filterOrderByState(State state) {
        return techSupportOrders.stream()
                .filter(order -> order.getState() == state)
                .collect(Collectors.toCollection(Vector::new));
    }

	public void addOrder(Order order){
		techSupportOrders.add(order);
	}
	
	public void acceptOrder() {
		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), techSupportOrders);
	}

	@Override
	public boolean equals(Object obj) {
		if(!super.equals(obj)) {
            return false;
        }
		TechSupport d = (TechSupport)obj;
		return d.techSupportOrders.equals(this.techSupportOrders);
	}

	@Override
	public String toString() {
		return super.toString();
	}

	public Vector<Order> getTechSupportOrders() {
		return techSupportOrders;
	}

	public void setTechSupportOrders(Vector<Order> techSupportOrders) {
		this.techSupportOrders = techSupportOrders;
	}
}
