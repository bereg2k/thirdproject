package study_center;

import study_center.persons.Student;
import study_center.reports.LongReport;
import study_center.reports.Report;
import study_center.reports.ShortReport;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class StudyCenter {
    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        Calendar calendar = Calendar.getInstance();
        String tz = Calendar.getInstance().getTimeZone().getID();
        Date currentDate = calendar.getTime();

        Student ivan = new Student("Ivan", "Petrov");
        Course java = new Course("Java 2.0", 20);
        Course js = new Course("JavaScript", 16);
        Course javaTest = new Course("Java for testing", 42);
        Program programTotalJava = new Program("01/09/2018 14:17", "Total Java");

        Course coursesJava[] = new Course[]{java, js, javaTest};
        programTotalJava.addCoursesToProgram(coursesJava);
        ivan.setStudentsProgram(programTotalJava);
        programTotalJava.calculateProgramEndDate();

        System.out.println("CURRENT DATE: " + format.format(currentDate) + "  " + tz);
        System.out.println("-----------------------Short Report---------------------");
        Report shortReport = new ShortReport();
        shortReport.showReportForStudent(ivan);
        System.out.println("-----------------------Long Report---------------------");
        Report longReport = new LongReport();
        longReport.showReportForStudent(ivan);
    }
}


