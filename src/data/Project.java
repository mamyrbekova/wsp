package data;

import entities.Researcher;

import java.io.*;
import java.util.*;

public abstract class Project implements Serializable {
    private String topic;
    private Vector<ResearchPaper> publishedPapers;
    private Vector<Researcher> participants;

    public Project() {
    }

    public Project(String topic, Vector<ResearchPaper> publishedPapers, Vector<Researcher> participants) {
        this.topic = topic;
        this.publishedPapers = publishedPapers;
        this.participants = participants;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Vector<ResearchPaper> getPublishedPapers() {
        return publishedPapers;
    }

    public void setPublishedPapers(Vector<ResearchPaper> publishedPapers) {
        this.publishedPapers = publishedPapers;
    }

    public Vector<Researcher> getParticipants() {
        return participants;
    }

    public void setParticipants(Vector<Researcher> participants) {
        this.participants = participants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(topic, project.topic) && Objects.equals(publishedPapers, project.publishedPapers) && Objects.equals(participants, project.participants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topic, publishedPapers, participants);
    }

    @Override
    public String toString() {
        return "Project{" +
                "topic='" + topic + '\'' +
                ", publishedPapers=" + publishedPapers +
                ", participants=" + participants +
                '}';
    }
}
