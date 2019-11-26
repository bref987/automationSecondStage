package com.epam.automation.slutski.university.logic;

import com.epam.automation.slutski.university.exceptions.NoAnyCourseException;
import com.epam.automation.slutski.university.exceptions.NoAnyUnityException;
import com.epam.automation.slutski.university.structure.Student;
import com.epam.automation.slutski.university.types.Courses;
import com.epam.automation.slutski.university.types.Faculties;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UniversityLogic {

    List<? extends Student> students = new ArrayList<>();

    public UniversityLogic(List<? extends Student> students) {
        this.students = students;
    }

    public List<? extends Student> getStudents() {
        return students;
    }

    public double getAverageUniversityCourseNote(Courses course) throws NoAnyCourseException {
        if (getUniversityCourseStudents(course).size() > 0) {

            int studentsNumber = students.stream()
                    .filter(a -> ((Student) a).getCourses().containsKey(course))
                    .toArray().length;

            int totalNotes = students.stream()
                    .filter(a -> ((Student) a).getCourses().containsKey(course))
                    .map(a -> ((Student) a).getCourses().get(course))
                    .reduce(0, (a, b) -> a + b);

            return (double) totalNotes / studentsNumber;
        } else {

            throw new NoAnyCourseException();
        }
    }

    public double getAverageFacultyGroupCourseNote(Faculties facultyName, int groupNumber, Courses course)
            throws NoAnyUnityException, NoAnyCourseException {

        if (getFacultyGroupCourseStudents(facultyName, groupNumber, course).size() > 0) {

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

        } else if (getFacultyGroupStudents(facultyName, groupNumber).size() > 0) {

            throw new NoAnyCourseException();
        } else {

            throw new NoAnyUnityException();
        }
    }

    public List<Student> getFacultyGroupCourseStudents(Faculties facultyName, int groupNumber, Courses course) {

        return students.stream()
                .filter(a -> ((Student) a).getFacultyName() == facultyName)
                .filter(a -> ((Student) a).getGroupNumber() == groupNumber)
                .filter(a -> ((Student) a).getCourses().containsKey(course))
                .collect(Collectors.toList());
    }

    public List<Student> getFacultyGroupStudents(Faculties facultyName, int groupNumber) {

        return students.stream()
                .filter(a -> ((Student) a).getFacultyName() == facultyName)
                .filter(a -> ((Student) a).getGroupNumber() == groupNumber)
                .collect(Collectors.toList());
    }

    public List<Student> getUniversityCourseStudents(Courses course) {

        return students.stream()
                .filter(a -> ((Student) a).getCourses().containsKey(course))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "University{" +
                "students=" + students +
                "}";
    }
}
