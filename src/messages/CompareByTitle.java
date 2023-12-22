package messages;

import java.util.Comparator;

public class CompareByTitle implements Comparator<Message>{

	@Override
	public int compare(Message o1, Message o2) {
		return o1.getTitle().compareTo(o2.getTitle());
	}

}
