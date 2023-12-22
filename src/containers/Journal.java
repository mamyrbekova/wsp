package containers;

import java.util.Objects;
import java.util.Vector;
import entities.Observable;
import messages.Notification;
import data.ResearchPaper;

public class Journal extends Observable {
    private String name;
    private Vector<ResearchPaper> papers;

    {
        papers = new Vector<ResearchPaper>();
    }
    public Journal() {}

    public Journal(String name) {
        this.name = name;
    }

    /**
     * @param paper A research paper that is going to be published to the Journal
     */
    public void publishNewPaper(ResearchPaper paper){
        papers.add(paper);
        Notification notification = new Notification("New Paper Published", "A new paper titled '" + paper.getTitle() + "' has been published in " + getName());
        notifySubscribers(notification);
    }
    
    

    @Override
    public String toString() {
        String result = "";
        for(ResearchPaper p : papers){
            result += p.getTitle() + "\n";
        }
        return "This is a " + name + "Journal with papers:\n" +
                result;
    }

    @Override
    public boolean equals(Object o) { // need to add super()
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Journal journal = (Journal) o;
        return Objects.equals(name, journal.name) && Objects.equals(papers, journal.papers);
    }

    @Override
    public int hashCode() { // need to add super()
        return Objects.hash(name, papers);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vector<ResearchPaper> getPapers() {
        return papers;
    }

    public void setPapers(Vector<ResearchPaper> papers) {
        this.papers = papers;
    }
}
