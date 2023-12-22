package entities;

import data.DataBase;
import messages.Inbox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import containers.Course;
import containers.CourseNotRegisteredException;
import containers.Lesson;
import containers.OverlappingLessonException;

public class ManagerOR extends Manager{
	
	public ManagerOR(String userId, Login login, String email, String name, String surname, Inbox inbox) {
		super(userId, login, email, name, surname, inbox);
	}
	
	
	DataBase database = DataBase.getInstance();
	
//	public void addCourse(Course course) {
//		database.getCourses().add(course);
//	}
	
	
	public void addCoursesForRegistration(Faculty faculty, Coursetype coursetype, Course course) {
		switch (coursetype) {
        case MANDATORY:
            faculty.getMandatoryCourses().add(course);
            break;
        case MAJOR:
            faculty.getAvailableMajorElectives().add(course);
            break;
        case MINOR:
            faculty.getAvailableMinorElectives().add(course);
            break;
        default:
            System.out.println("No such coursetype");
            break;
		}
	}

	
	
	public void assignCourseToTeacher(Teacher teacher, Course course, Lesson lesson) throws OverlappingLessonException, CourseNotRegisteredException {
		if(!course.getAvailableTeachers().contains(teacher)) {
			course.addAvailableTeacher(teacher);
			teacher.getSchedule().addLesson(lesson);
		}else {
			System.out.println("Teacher already assigned! ");
		}
	}
	
	
	public void assignLesson(Teacher teacher, Course course) throws OverlappingLessonException, CourseNotRegisteredException {
		Lesson lesson = new Lesson();
		teacher.getSchedule().addLesson(lesson);
		course.addLesson(lesson);	
	}
	

	
	public void startSession() throws IOException {
		try {
			System.out.println("Welcome!");
			menu: while(true) {
				System.out.println("What do you want to do?\n 1)add courses for registration \n 2)assign course to teacher \n 3)assign lesson");
				int choice = Integer.parseInt(getReader().readLine());
				if(choice == 1) {
					addCoursesForRegistration: while(true) {
						System.out.println("Enter faculty name:");
                        String facultyName = getReader().readLine();
                        FacultyName faculty = FacultyName.valueOf(getReader().readLine());

                        if (faculty != null) {
                            System.out.println("Enter course type (MANDATORY, MAJOR, MINOR):");
                            Coursetype coursetype = Coursetype.valueOf(reader.readLine());

                            System.out.println("Enter course details:");
                            Course course = createCourse(); // Implement a method to create a course

                            addCoursesForRegistration(faculty, coursetype, course);
					}
				}
			}
		}
	}
	
}
