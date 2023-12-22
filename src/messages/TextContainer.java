package messages;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class TextContainer implements Serializable {
	private String title;
	private String message;
	private final LocalDateTime time;
	{
		time = LocalDateTime.now();
	}

	public TextContainer() {
	}
	
	public TextContainer(String title, String message) {
		this.title = title;
		this.message = message;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getTime() {
		return time;
	}

	@Override
	public int hashCode() {
		return Objects.hash(message, time, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TextContainer other = (TextContainer) obj;
		return Objects.equals(message, other.message) && Objects.equals(time, other.time)
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Title: " + getTitle() + "\nTime: " + getTime() + "\nMessage: " + getMessage();
	}

}
