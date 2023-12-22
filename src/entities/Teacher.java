package entities;

import java.io.*;
import java.util.*;
import messages.*;
import data.*;
import containers.*;

public class Teacher extends Employee implements Serializable {
    private Schedule schedule;
    private Vector<Complaint> sentComplaints;
    private TeacherTitle title;
    private HashMap<Student, Integer> ratings;

    public Teacher() {
    }

    public Teacher(Schedule schedule, Vector<Complaint> sentComplaints, TeacherTitle title, HashMap<Student, Integer> ratings) {
        this.schedule = schedule;
        this.sentComplaints = sentComplaints;
        this.title = title;
        this.ratings = ratings;
    }

    public void putMark(Student s, Course c, Point p){
        s.setGradeBook(s.getGradeBook().get(c).putMark(p));
    }

    public void sendComplaint(Complaint c){
        // TODO nado sdelat, poka hz kak
    }

    public void addRating(Student student, Integer rating){
        ratings.put(student, rating);
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Vector<Complaint> getSentComplaints() {
        return sentComplaints;
    }

    public void setSentComplaints(Vector<Complaint> sentComplaints) {
        this.sentComplaints = sentComplaints;
    }

    public TeacherTitle getTitle() {
        return title;
    }

    public void setTitle(TeacherTitle title) {
        this.title = title;
    }

    public HashMap<Student, Integer> getRatings() {
        return ratings;
    }

    public void setRatings(HashMap<Student, Integer> ratings) {
        this.ratings = ratings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(schedule, teacher.schedule) && Objects.equals(sentComplaints, teacher.sentComplaints) && title == teacher.title && Objects.equals(ratings, teacher.ratings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schedule, sentComplaints, title, ratings);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "schedule=" + schedule +
                ", sentComplaints=" + sentComplaints +
                ", title=" + title +
                ", ratings=" + ratings +
                '}';
    }
}