package messages;

import java.util.Comparator;

class CompareByDate implements Comparator<Message>{

	@Override
	public int compare(Message o1, Message o2) {
		return o1.getTime().compareTo(o2.getTime());
	}
	
}
