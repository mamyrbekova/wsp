package messages;

import java.util.Comparator;

public class CompareByPriority implements Comparator<Complaint>{

	@Override
	public int compare(Complaint o1, Complaint o2) {
		return o1.compareTo(o2);
	}
	
}
