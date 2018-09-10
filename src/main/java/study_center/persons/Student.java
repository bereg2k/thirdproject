package study_center.persons;

import study_center.Program;

public class Student extends study_center.persons.Person {
    private Program studentsProgram;

    public Student(String name, String surName) {
        super(name, surName);
    }

    public Program getStudentsProgram() {
        return studentsProgram;
    }

    public void setStudentsProgram(Program studentsProgram) {
        this.studentsProgram = studentsProgram;
    }
}
