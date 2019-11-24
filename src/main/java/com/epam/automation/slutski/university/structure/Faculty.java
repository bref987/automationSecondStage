package com.epam.automation.slutski.university.structure;

import com.epam.automation.slutski.university.exceptions.NoAnyUnityException;
import com.epam.automation.slutski.university.types.Faculties;

public class Faculty {

    private Faculties facultyName;

    public Faculty() throws NoAnyUnityException {
        super();

        System.out.println("No any faculty at the university");
        throw new NoAnyUnityException();
    }

    public Faculty(Faculties facultyName) {
        this.facultyName = facultyName;
    }

    public Faculties getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(Faculties facultyName) {
        this.facultyName = facultyName;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyName=" + facultyName +
                "}";
    }
}
