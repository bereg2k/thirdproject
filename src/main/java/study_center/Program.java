package study_center;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Program {
    private Date programStartDate;
    private Date programEndDate;
    private String programName;
    private List<Course> courses = new ArrayList<Course>();
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public Program(String programStartDate, String programName) {
        format.setLenient(false);
        try {
            this.programStartDate = format.parse(programStartDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.programName = programName;
    }

    public Date getProgramStartDate() {
        return programStartDate;
    }

    public String getProgramName() {
        return programName;
    }

    public void addCoursesToProgram(Course[] currentCourses) {
        for (Course course : currentCourses) {
            courses.add(course);
        }
    }

    public List<Course> getCourses() {
        return courses;
    }

    public int countProgramDuration() {
        int programDurationInHours = 0;
        for (Course course : courses
        ) {
            programDurationInHours += course.getCourseDuration();
        }
        return programDurationInHours;
    }

    public void calculateProgramEndDate() {
        Calendar calendar = Calendar.getInstance();
        int programDurationInHours = countProgramDuration();
        calendar.setTime(this.programStartDate);
        calendar.add(Calendar.DAY_OF_MONTH, programDurationInHours / 8);
        calendar.add(Calendar.HOUR_OF_DAY, programDurationInHours % 8);
        programEndDate = calendar.getTime();
    }

    public Date getProgramEndDate() {
        return programEndDate;
    }

    public String showProgramProgress(Date startDate, Date endDate) {
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();
        if (currentDate.before(startDate)) {
            return "The program has not been started yet \n";
        } else if (currentDate.after(endDate)) {
            return "The program has already been finished \n";
        } else {
            return "The program is in progress now \n";
        }
    }

    public String showProgramCourses() {
        String coursesLine = "";
        for (Course course : courses) {
            coursesLine += "COURSE: " + course.getCourseName() + "; DURATION: " + course.getCourseDuration() + " hours \n";
        }
        return coursesLine;
    }
}
