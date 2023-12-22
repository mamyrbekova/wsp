package entities;

import data.*;
import messages.*;
import containers.*;

import java.io.*;
import java.lang.System;
import java.util.*;

public class Student extends User implements Serializable {
    private FacultyName faculty;
    private Vector<Organization> organizations;
    private Schedule schedule;
    private Vector<Course> doneCourses;
    private Boolean isExpelled;
    private Map<Course, Mark> gradeBook;
    private Set<Transcript> transcripts;

    {
            organizations = new Vector<Organization>();
            doneCourses = new Vector<Course>();
            gradeBook = new HashMap<Course, Mark>();
            transcripts = new HashSet<>();
            isExpelled = false;
    }

    public Student() {
    }

    public Student(String userId, Login login, String email, String name, String surname, FacultyName faculty, Schedule schedule) {
        super(userId, login, email, name, surname);
        this.faculty = faculty;

        this.schedule = schedule;
    }

    public void viewTransript(Transcript transcript){
        System.out.println(transcript);
    }
    public void viewTeacherInfo(Teacher teacher){
        System.out.println(teacher);
    }
    public void joinStudentOrganization(Organization organizaiton){
        this.organizations.add(organizaiton);
    }
    public void rateTeacher(Teacher teacher, Integer rating){
        teacher.setRatings(teacher.addRating(this, rating));
    }
    public void viewMarks(){
        System.out.println(gradeBook);
    }

    public void registerCourse(Course c){
        List<Course> availableCourses =  DataBase.getInstance().
                getFaculties().
                stream().
                filter(n -> n.getName() == faculty).
                getAvailableMajorElectives();
        if(availableCourses.contains(c)){
            c.getRegisteredStudents().add(this);
            System.out.println("You are registered to "+ c.getCourseName() + " course.");
        }else{
            System.out.println("This course is not meant to be in your schedule.");
        }
    }


    public Vector<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(Vector<Organization> organizations) {
        this.organizations = organizations;
    }

    public Set<Transcript> getTranscripts() {
        return transcripts;
    }

    public void setTranscripts(Set<Transcript> transcripts) {
        this.transcripts = transcripts;
    }

    public FacultyName getFaculty() {
        return faculty;
    }

    public void setFaculty(FacultyName faculty) {
        this.faculty = faculty;
    }

    public Vector<Organization> getOrganization() {
        return organizations;
    }

    public void setOrganization(Vector<Organization> organizations) {
        this.organizations = organizations;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Vector<Course> getDoneCourses() {
        return doneCourses;
    }

    public void setDoneCourses(Vector<Course> doneCourses) {
        this.doneCourses = doneCourses;
    }

    public Boolean getExpelled() {
        return isExpelled;
    }

    public void setExpelled(Boolean expelled) {
        isExpelled = expelled;
    }

    public Map<Course, Mark> getGradeBook() {
        return gradeBook;
    }

    public void setGradeBook(Map<Course, Mark> gradeBook) {
        this.gradeBook = gradeBook;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(faculty, student.faculty) && Objects.equals(organizations, student.organizations) && Objects.equals(schedule, student.schedule) && Objects.equals(doneCourses, student.doneCourses) && Objects.equals(isExpelled, student.isExpelled) && Objects.equals(gradeBook, student.gradeBook);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), faculty, organizations, schedule, doneCourses, isExpelled, gradeBook);
    }

    @Override
    public String toString() {
        return "Student{" +
                "faculty=" + faculty +
                ", organization=" + organizations +
                ", schedule=" + schedule +
                ", doneCourses=" + doneCourses +
                ", isExpelled=" + isExpelled +
                ", gradeBook=" + gradeBook +
                '}';
    }
}
