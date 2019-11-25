package com.epam.automation.slutski.university.logic;

import com.epam.automation.slutski.university.structure.Faculty;
import com.epam.automation.slutski.university.structure.Student;
import com.epam.automation.slutski.university.types.Courses;
import com.epam.automation.slutski.university.types.Faculties;

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

    public double getAverageUniversityCourseNote(Courses course) {

        int studentsNumber = students.stream()
                .filter(a -> ((Student) a).getCourses().containsKey(course))
                .toArray().length;

        int totalNotes = students.stream()
                .filter(a -> ((Student) a).getCourses().containsKey(course))
                .map(a -> ((Student) a).getCourses().get(course))
                .reduce(0, (a, b) -> a + b);

        return (double) totalNotes / studentsNumber;
    }

    public double getAverageFacultyGroupCourseNote(Faculties facultyName, int groupNumber, Courses course) {

        int studentsNumber = students.stream()
                .filter(a -> ((Student) a).getFacultyName() == facultyName)
                .filter(a -> ((Student) a).getGroupNumber() == groupNumber)
                .filter(a -> ((Student) a).getCourses().containsKey(course))
                .toArray().length;

        int totalNotes = students.stream()
                .filter(a -> ((Student) a).getFacultyName() == facultyName)
                .filter(a -> ((Student) a).getGroupNumber() == groupNumber)
                .filter(a -> ((Student) a).getCourses().containsKey(course))
                .map(a -> ((Student) a).getCourses().get(course))
                .reduce(0, (a, b) -> a + b);

        return (double) totalNotes / studentsNumber;
    }


    @Override
    public String toString() {
        return "University{" +
                "students=" + students +
                "}";
    }
}
