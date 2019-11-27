package com.epam.automation.slutski.university.logic;

import com.epam.automation.slutski.university.exceptions.NoAnyCourseException;
import com.epam.automation.slutski.university.exceptions.NoAnyUnityException;
import com.epam.automation.slutski.university.structure.Student;
import com.epam.automation.slutski.university.types.Courses;
import com.epam.automation.slutski.university.types.Faculties;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UniversityLogic {

    static Logger logger = Logger.getLogger(UniversityLogic.class);

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
                    .filter(a -> a.getCourses().containsKey(course))
                    .toArray().length;

            int totalNotes = students.stream()
                    .filter(a -> a.getCourses().containsKey(course))
                    .map(a -> a.getCourses().get(course))
                    .reduce(0, (a, b) -> a + b);

            return (double) totalNotes / studentsNumber;
        } else {

            logger.error("No any course");
            throw new NoAnyCourseException();
        }
    }

    public double getAverageFacultyGroupCourseNote(Faculties facultyName, int groupNumber, Courses course)
            throws NoAnyUnityException, NoAnyCourseException {

        if (getFacultyGroupCourseStudents(facultyName, groupNumber, course).size() > 0) {

            int studentsNumber = students.stream()
                    .filter(a -> a.getFacultyName() == facultyName)
                    .filter(a -> a.getGroupNumber() == groupNumber)
                    .filter(a -> a.getCourses().containsKey(course))
                    .toArray().length;

            int totalNotes = students.stream()
                    .filter(a -> a.getFacultyName() == facultyName)
                    .filter(a -> a.getGroupNumber() == groupNumber)
                    .filter(a -> a.getCourses().containsKey(course))
                    .map(a -> a.getCourses().get(course))
                    .reduce(0, (a, b) -> a + b);

            return (double) totalNotes / studentsNumber;

        } else if (getFacultyGroupStudents(facultyName, groupNumber).size() > 0) {

            logger.error("No any course");
            throw new NoAnyCourseException();
        } else {

            logger.error("No any faculty or group");
            throw new NoAnyUnityException();
        }
    }

    public List<Student> getFacultyGroupCourseStudents(Faculties facultyName, int groupNumber, Courses course) {

        return students.stream()
                .filter(a -> a.getFacultyName() == facultyName)
                .filter(a -> a.getGroupNumber() == groupNumber)
                .filter(a -> a.getCourses().containsKey(course))
                .collect(Collectors.toList());
    }

    public List<Student> getFacultyGroupStudents(Faculties facultyName, int groupNumber) {

        return students.stream()
                .filter(a -> a.getFacultyName() == facultyName)
                .filter(a -> a.getGroupNumber() == groupNumber)
                .collect(Collectors.toList());
    }

    public List<Student> getUniversityCourseStudents(Courses course) {

        return students.stream()
                .filter(a -> a.getCourses().containsKey(course))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "University{" +
                "students=" + students +
                "}";
    }
}
