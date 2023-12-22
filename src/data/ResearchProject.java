package data;

import entities.Researcher;

import java.io.*;
import java.util.*;

public class ResearchProject extends Project implements Serializable {
    public ResearchProject() {
    }

    public ResearchProject(String topic, Vector<ResearchPaper> publishedPapers, Vector<Researcher> participants) {
        super(topic, publishedPapers, participants);
    }
}
