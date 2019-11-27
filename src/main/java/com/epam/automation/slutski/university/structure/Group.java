package com.epam.automation.slutski.university.structure;

import com.epam.automation.slutski.university.exceptions.NoAnyUnityException;
import com.epam.automation.slutski.university.types.Faculties;
import org.apache.log4j.Logger;

public class Group extends Faculty {

    static Logger logger = Logger.getLogger(Group.class);

    private int groupNumber;

    public Group() throws NoAnyUnityException {
        super();
    }

    public Group(Faculties facultyName) throws NoAnyUnityException {
        super(facultyName);

        logger.error("No any group at the university");
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
