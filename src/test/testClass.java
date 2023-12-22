package test;

import messages.*;
import data.*;
import containers.*;
import entities.*;

public class testClass {
	public static void main(String[] args) {
        // Create a Manager
        Manager manager = new Manager("M001", new Login("manager", "password"), "manager@example.com", "John", "Doe", new Inbox());

        // Create two teachers
        Teacher teacher1 = new Teacher();
        teacher1.setName("Alice");
        teacher1.setSurname("Smith");
        teacher1.setTitle(TeacherTitle.PROFESSOR);

        Teacher teacher2 = new Teacher();
        teacher2.setName("Bob");
        teacher2.setSurname("Johnson");
        teacher2.setTitle(TeacherTitle.PROFESSOR);

        // Create a Course
        Course course = new Course("C001", "Programming 101", 3);

        // Add teachers to the available teachers for the course
        course.addAvailableTeacher(teacher1);
        course.addAvailableTeacher(teacher2);

        // Manager views teacher information for the specified course
        manager.viewTeacherInfo(course);
    }
}
