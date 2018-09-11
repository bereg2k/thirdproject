package study_center;

import study_center.persons.Student;
import study_center.reports.LongReport;
import study_center.reports.Report;
import study_center.reports.ShortReport;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class StudyCenter {
    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        Calendar calendar = Calendar.getInstance();
        String tz = Calendar.getInstance().getTimeZone().getID();
        Date currentDate = calendar.getTime();

        Student ivan = new Student("Ivan", "Petrov");
        Student petr = new Student("Petr", "Ivanov");
        Course java = new Course("Java 2.0", 20);
        Course js = new Course("JavaScript", 16);
        Course javaTest = new Course("Java for testing", 42);
        Program programTotalJava = new Program("02.09.2018 16:17", "Total Java");
        Program programCPP = new Program("12.09.2018 10:17", "C++");


        Course coursesJava[] = new Course[]{java, js, javaTest};
        programTotalJava.addCoursesToProgram(coursesJava);
        programTotalJava.calculateProgramEndDate();

        ivan.setStudentsProgram(programTotalJava);
        petr.setStudentsProgram(programCPP);

        System.out.println("CURRENT DATE: " + format.format(currentDate) + "  " + tz);
        boolean isInvalidInput;
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.print("Enter '1' for Short Report on Student or '2' for Long Report on Student: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("-----------------------Short Report---------------------");
                    Report shortReport = new ShortReport();
                    shortReport.showReportForStudent(ivan);
                    System.out.println("--------------------------------------------------------");
                    shortReport.showReportForStudent(petr);
                    isInvalidInput = false;
                    break;
                case 2:
                    System.out.println("-----------------------Long Report---------------------");
                    Report longReport = new LongReport();
                    longReport.showReportForStudent(ivan);
                    System.out.println("--------------------------------------------------------");
                    longReport.showReportForStudent(petr);
                    isInvalidInput = false;
                    break;
                default:
                    System.out.println("Invalid input! Please try again!");
                    isInvalidInput = true;
                    break;
            }
        } while (isInvalidInput);
    }
}


