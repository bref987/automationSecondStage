package com.epam.automation.slutski.university.logic;

import com.epam.automation.slutski.university.structure.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UniversityLogic {

    List<? extends Student> students = new ArrayList<>();

    public UniversityLogic(List<? extends Student> students) {
        this.students = students;
    }

    public List<? extends Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "University{" +
                "students=" + students +
                "}";
    }
}
