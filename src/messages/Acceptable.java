package messages;

import java.io.Serializable;

public interface Acceptable  extends Serializable {
	int makeAccepted(int accepted);
	int isAccepted();
}
