package entities;

import containers.*;
import data.DataBase;
import messages.Inbox;
import java.io.Serializable;

import java.util.Map;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.List;

public abstract class Manager extends Employee implements Serializable{
	
	public Manager(String userId, Login login, String email, String name, String surname, Inbox inbox) {
        super(userId, login, email, name, surname, inbox);
    }

// hz kakoi budet right
	
//	public void viewStudentInfo(SortType sorttype) {
//		switch(sorttype) {
//		case ALPHABETICALLY:
//			List<Student> sortedStudents = DataBase.getInstance().getUsers().stream()
//            .filter(user -> user instanceof Student)
//            .map(user -> (Student) user)
//            .sorted(Comparator.comparing(Student::getName))
//            .collect(Collectors.toList());
//
//			System.out.println("All Students Information (Sorted Alphabetically by Name):");
//
//			for (Student student : sortedStudents) {
//				printStudentInfo(student);
//			}		
//			break;
//		case GPA:
//			List<Student> students = DataBase.getInstance().getUsers().stream()
//            .filter(user -> user instanceof Student)
//            .map(user -> (Student) user)
//            .sorted(Comparator.comparingDouble(this::calculateTotalGPA).reversed())     //calculateTotalGpa should be in student class
//            .collect(Collectors.toList());
//
//			System.out.println("Students Information Sorted by Total GPA:");
//
//			for (Student student : students) {
//				printStudentInfo(student);
//			}
//			break;
//		}
//	}
	
	public void viewAllStudentsInfoAlphabetically() {
        List<Student> sortedStudents = DataBase.getInstance().getUsers().stream()
                .filter(user -> user instanceof Student)
                .map(user -> (Student) user)
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());

        System.out.println("All Students Information (Sorted Alphabetically by Name):");

        for (Student student : sortedStudents) {
            printStudentInfo(student);
        }
    }
	
	
	public void viewStudentsInfoByTotalGPA() {
        List<Student> students = DataBase.getInstance().getUsers().stream()
                .filter(user -> user instanceof Student)
                .map(user -> (Student) user)
                .sorted(Comparator.comparingDouble(this::calculateTotalGPA).reversed())     //calculateTotalGpa should be in student class
                .collect(Collectors.toList());

        System.out.println("Students Information Sorted by Total GPA:");

        for (Student student : students) {
            printStudentInfo(student);
        }
    }
	
	

	
	private void printStudentInfo(Student student) {
		System.out.println("\nStudent ID: " + student.getUserId());
	    System.out.println("Name: " + student.getName());
	    System.out.println("Surname: " + student.getSurname());
	    System.out.println("Email: " + student.getEmail());
	    System.out.println("Faculty: " + student.getFaculty());

	    System.out.println("\nCourses and Corresponding GPAs:");
	    for (Map.Entry<Course, Mark> entry : student.getGradeBook().entrySet()) {
	        Course course = entry.getKey();
	        Mark mark = entry.getValue();

	        System.out.println("- Course: " + course.getCourseName());
	        System.out.println("  - GPA: " + mark.getGPA());
	    }	    
	    
	    System.out.println("\nTranscripts:");
	    for (Transcript transcript : student.getTranscripts()) {
	        System.out.println(transcript);
	    }

    }
	

	
	
	public void viewTeacherInfo(Course course) {
		Vector<Teacher> teachers = course.getAvailableTeachers();
		
		if(!teachers.isEmpty()) {
			System.out.println("Teachers for the course " + course.getCourseName() + ":");
            for (Teacher teacher : teachers) {
                System.out.println("Name: " + teacher.getName());
                System.out.println("Surname: " + teacher.getSurname());
                System.out.println("Title: " + teacher.getTitle());
                System.out.println("Email: " + teacher.getEmail());
                System.out.println("Ratings: " + teacher.getRatings());  
            }
		} else {
			System.out.println("No teachers are associated with this course");
		}
	}
 	       
}
