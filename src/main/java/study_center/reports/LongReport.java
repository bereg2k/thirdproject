package study_center.reports;

import study_center.Program;
import study_center.persons.Student;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LongReport implements Report {
    SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy HH:mm");

    public void showReportForStudent(Student currentStudent) {
        format.setLenient(false);
        Program program = currentStudent.getStudentsProgram();
        Date programStartDate = program.getProgramStartDate();
        Date programStopDate = program.getProgramEndDate();
        StringBuilder longInfo = new StringBuilder();
        longInfo.append("STUDENT: " + currentStudent.getName() + " " + currentStudent.getSurName() + "\n");
        longInfo.append("STUDENT'S PROGRAM: " + program.getProgramName() + "\n");
        longInfo.append("START: " + format.format(programStartDate) + "\n");
        longInfo.append("PROGRAM'S DURATION: " + program.countProgramDuration() + " hours\n");
        if (program.getCourses() != null) {
            longInfo.append(program.showProgramCourses());
        } else {
            longInfo.append("No assigned courses for this student \n");
        }
        System.out.println(longInfo.toString());
    }
}
