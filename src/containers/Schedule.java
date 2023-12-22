package containers;
import java.util.TreeSet;

/*
* This schedule is used to represent list of lessons
* That teachers and students have
* It doesn't allow overlapping lessons and checks if
* The course is registered for this student or teacher
* */

public class Schedule {

    private TreeSet<Lesson> lessons;

    {
        // sorts by week and start time of lesson
        lessons = new TreeSet<Lesson>(Lesson.getLessonComparator());
    }
    public Schedule() {}

    /**
     * @param lesson The lesson that you want to add to the Schedule
     * @throws OverlappingLessonException Is thrown if time of this lesson overlaps with any currently existing lesson
     * @throws CourseNotRegisteredException Is thrown if schedule of object to which schedule belongs doesn't have the lesson registered for them
     */
    public void addLesson(Lesson lesson) throws OverlappingLessonException, CourseNotRegisteredException {
        if(!isOverlap(lesson)){
                lessons.add(lesson);
        }
        else throw new OverlappingLessonException("Lessons overlap. Didn't add");
    }

    // checks the lesson for overlap in time with any other lesson in the Schedule
    private boolean isOverlap(Lesson lesson){ // TO DO
        for (Lesson existingLesson : lessons) {
            if (lesson.getWeekDay() == existingLesson.getWeekDay()) {
                if(lesson.getStartTime().compareTo(existingLesson.getEndTime()) <= 0
                        && lesson.getEndTime().compareTo(existingLesson.getStartTime()) >= 0){
                    return true;
                }
            }

            // If the existing lesson's week is greater than the given lesson's week,
            // we can stop searching because the lessons are sorted.
            if (existingLesson.getWeekDay().compareTo(lesson.getWeekDay()) > 0) {
                break;
            }
        }
        return false;
    }

    public TreeSet<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(TreeSet<Lesson> lessons) {
        this.lessons = lessons;
    }
}
