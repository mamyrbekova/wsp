package data;

import messages.Comment;

import java.io.Serializable;
import java.util.*;

public class News implements Serializable {
    private Topic topic;
    private String content;
    private Boolean pinned;
    private Vector<Comment> comments;

    public News() {

    }
    
    public News(Topic topic, String content, Boolean pinned, Vector<Comment> comments) {
        this.topic = topic;
        this.content = content;
        this.pinned = pinned;
        this.comments = comments;
    }

    public void addComment(Comment comment){
        comments.add(comment);
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getPinned() {
        return pinned;
    }

    public void setPinned(Boolean pinned) {
        this.pinned = pinned;
    }

    public Vector<Comment> getComments() {
        return comments;
    }

    public void setComments(Vector<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return topic == news.topic && Objects.equals(content, news.content) && Objects.equals(pinned, news.pinned) && Objects.equals(comments, news.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topic, content, pinned, comments);
    }

    @Override
    public String toString() {
        return "News{" +
                "topic=" + topic +
                ", content='" + content + '\'' +
                ", pinned=" + pinned +
                ", comments=" + comments +
                '}';
    }
}
