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
        StringBuilder longInfo = new StringBuilder();

        longInfo.append("STUDENT: " + currentStudent.getName() + " " + currentStudent.getSurName() + "\n");

        if (program != null) {
            Date programStartDate = program.getProgramStartDate();
            Date programStopDate = program.getProgramEndDate();
            longInfo.append("STUDENT'S PROGRAM: " + program.getProgramName() + "\n");
            if (programStopDate != null) {
                longInfo.append("START: " + format.format(programStartDate) + "\n");
                longInfo.append("PROGRAM'S DURATION: " + program.countProgramDuration() + " hours\n");
                longInfo.append(program.showProgramCourses());
            } else {
                longInfo.append("Student's program is empty now (no courses assigned to it) \n");
            }
        } else {
            longInfo.append("No assigned programs for this student yet \n");
        }
        System.out.println(longInfo.toString());
    }
}
