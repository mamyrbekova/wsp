package messages;

import java.io.Serializable;
import java.util.Objects;

public class Comment extends TextContainer implements Serializable {

	public Comment() {}
	
	public Comment(String title, String message) {
		super(title, message);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode());
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
