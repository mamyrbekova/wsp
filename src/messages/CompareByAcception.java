package messages;

import java.util.Comparator;

public class CompareByAcception implements Comparator<Acceptable>{

	@Override
	public int compare(Acceptable o1, Acceptable o2) {
		return Integer.compare(o1.isAccepted(), o2.isAccepted());
	}

}
