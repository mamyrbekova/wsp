package entities;

import java.io.*;
import java.util.Vector;
import containers.Course;


public class Faculty  implements Serializable {
    private FacultyName name;
    private Vector<Course> mandatoryCourses;
    private Vector<Course> availableMajorElectives;
    private Vector<Course> availableMinorElectives;
    

    public Faculty (FacultyName name){
        this.name = name;
    }

    public FacultyName getName() {
        return name;
    }

    public void setName(FacultyName name) {
        this.name = name;
    }

	public Vector<Course> getMandatoryCourses() {
		return mandatoryCourses;
	}

	public void setMandatoryCourses(Vector<Course> mandatoryCourses) {
		this.mandatoryCourses = mandatoryCourses;
	}

	public Vector<Course> getAvailableMajorElectives() {
		return availableMajorElectives;
	}

	public void setAvailableMajorElectives(Vector<Course> availableMajorElectives) {
		this.availableMajorElectives = availableMajorElectives;
	}

	public Vector<Course> getAvailableMinorElectives() {
		return availableMinorElectives;
	}

	public void setAvailableMinorElectives(Vector<Course> availableMinorElectives) {
		this.availableMinorElectives = availableMinorElectives;
	}
    
    
}
