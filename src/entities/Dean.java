package entities;

import java.io.*;
import java.util.*;
import messages.*;

public class Dean extends Employee implements Serializable {
	private Vector<Request> requests;
	private TreeSet<Complaint> complaints;
	{
		requests = new Vector<Request>();
		complaints = new TreeSet<Complaint>(new CompareByPriority());
	}
	public Dean() {
	}
	
	public Dean(String userId, Login login, String email, String name, String surname, Inbox inbox) {
		super(userId, login, email, name, surname, inbox);
	}
	
	public void accepting (Acceptable a) {
		a.makeAccepted(1);
	}
	
	public void rejecting(Acceptable a) {
		a.makeAccepted(-1);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), requests, complaints);
	}

	@Override
	public boolean equals(Object obj) {
		if(!super.equals(obj)) return false;
		Dean d = (Dean)obj;
		return d.requests.equals(this.requests) && d.complaints.equals(this.complaints);
	}

	@Override
	public String toString() {
		String result = "Accepted requests:\n";
		for (Acceptable i: requests) {
			result += i + "\n";
		}
		result += "Accepted complaints: \n";
		for (Acceptable i: complaints) {
			result += i + "\n";
		}
		return super.toString() + result;
	}

	public Vector<Request> getRequests() {
		return requests;
	}

	public void setRequests(Vector<Request> requests) {
		this.requests = requests;
	}

	public TreeSet<Complaint> getComplaints() {
		return complaints;
	}

	public void setComplaints(TreeSet<Complaint> complaints) {
		this.complaints = complaints;
	}
}
