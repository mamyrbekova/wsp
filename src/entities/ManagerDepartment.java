package entities;

import data.DataBase;
import data.News;
import data.ResearchPaper;
import messages.Acceptable;
import messages.Inbox;
import java.util.HashMap;


import containers.*;


public class ManagerDepartment extends Manager{
	
	private Vector<Acceptable> accepted;
	
	
	public ManagerDepartment(String userId, Login login, String email, String name, String surname, Inbox inbox) {
		super(userId, login, email, name, surname, inbox);
		// TODO Auto-generated constructor stub
	}
	
	
	public void puplishNews(News news) {
		DataBase.getInstance().getNews().add(news);
	}
	
	public void removeNews(News news) {
		DataBase.getInstance().getNews().remove(news);
	}
	
	public void addAccepted(Acceptable a) {
		accepted.add(a);
	}
	
	public Vector<Acceptable> viewRequestsAndComplaints() {
		return accepted;
	}
	
	
	
	public void coursePerformanceReport(Course course) {
        Vector<Student> registeredStudents = course.getRegisteredStudents();

        Map<String, Integer> gradeHistogram = new HashMap<>();

        
        for (Student student : registeredStudents) {
            Map<Course, Mark> gradeBook = student.getGradeBook();
            if (gradeBook.containsKey(course)) {
                Mark mark = gradeBook.get(course);
                String grade = mark.getGrade();


                gradeHistogram.put(grade, gradeHistogram.getOrDefault(grade, 0) + 1);
            }
        }

   
        System.out.println("Statistical Report for Course: " + course.getCourseName());
        System.out.println("-----------------------------------------------------");
        System.out.println("Grade \t\t Number of Students");
        System.out.println("-----------------------------------------------------");

  
        for (Map.Entry<String, Integer> entry : gradeHistogram.entrySet()) {
            System.out.println(entry.getKey() + "\t\t\t" + entry.getValue());
        }
    }
	
	
	
	public void publishInJournal(ResearchPaper paper, Journal journal) {
		journal.publishNewPaper(paper);
	}
	 
}
