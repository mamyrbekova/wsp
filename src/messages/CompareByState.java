package messages;

import java.util.Comparator;

public class CompareByState implements Comparator<Order>{

	@Override
	public int compare(Order o1, Order o2) {
		return o1.compareTo(o2);
	}

}
