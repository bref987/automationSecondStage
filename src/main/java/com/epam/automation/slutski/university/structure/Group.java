package com.epam.automation.slutski.university.structure;

import com.epam.automation.slutski.university.exceptions.NoAnyUnityException;
import com.epam.automation.slutski.university.types.Faculties;

public class Group extends Faculty {

    private int groupNumber;

    public Group() throws NoAnyUnityException {
        super();
    }

    public Group(Faculties facultyName) throws NoAnyUnityException {
        super(facultyName);

        System.out.println("No any group at the university");
        throw new NoAnyUnityException();
    }

    public Group(Faculties facultyName, int groupNumber) {
        super(facultyName);
        this.groupNumber = groupNumber;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", groupNumber=" + groupNumber +
                        "}");
    }
}
