package study_center.reports;

import study_center.Program;
import study_center.persons.Student;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ShortReport implements Report {
    SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    public void showReportForStudent(Student currentStudent) {
        format.setLenient(false);
        StringBuilder shortInfo = new StringBuilder();
        Program program = currentStudent.getStudentsProgram();

        shortInfo.append("STUDENT: " + currentStudent.getName() + " " + currentStudent.getSurName() + "\n");

        if (program != null) {
            Date programStartDate = program.getProgramStartDate();
            Date programStopDate = program.getProgramEndDate();
            shortInfo.append("STUDENT'S PROGRAM: " + program.getProgramName() + "\n");
            if (programStopDate != null) {
                shortInfo.append("START: " + format.format(programStartDate) + "\n");
                shortInfo.append("PROGRAM'S DURATION: " + program.countProgramDuration() + " hours\n");
                shortInfo.append("THE PROGRAM ENDS ON " + format.format(programStopDate) + " (in "
                        + program.countProgramDuration() / 8 + " days and " + program.countProgramDuration() % 8 + " hours)\n");
                shortInfo.append(program.showProgramProgress(programStartDate, programStopDate));
            } else {
                shortInfo.append("Student's program is empty now (no courses assigned to it) \n");
            }
        } else {
            shortInfo.append("No assigned programs for this student yet \n");
        }
        System.out.println(shortInfo.toString());
    }
}
