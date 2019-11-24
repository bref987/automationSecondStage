package com.epam.automation.slutski.university.structure;

import com.epam.automation.slutski.university.exceptions.IncorrectNoteException;
import com.epam.automation.slutski.university.exceptions.NoAnyCourseException;
import com.epam.automation.slutski.university.exceptions.NoAnyUnityException;
import com.epam.automation.slutski.university.types.Courses;
import com.epam.automation.slutski.university.types.Faculties;

import javax.xml.ws.FaultAction;
import java.util.Map;
import java.util.Objects;

public class Student extends Group {

    private String name;
    private Map<Courses, Integer> courses;

    public Student() throws NoAnyUnityException {
    }

    public Student(Faculties facultyName) throws NoAnyUnityException {
        super(facultyName);
    }

    public Student(Faculties facultyName, Integer groupNumber) throws NoAnyUnityException {
        super(facultyName, groupNumber);

        System.out.println("No any student in group");
        throw new NoAnyUnityException();
    }

    public Student(Faculties facultyName, int groupNumber, String name) throws NoAnyCourseException {
        super(facultyName, groupNumber);
        this.name = name;

        System.out.println("No any course");
        throw new NoAnyCourseException();
    }

    public Student(Faculties facultyName, int groupNumber, String name, Map<Courses, Integer> courses)
            throws NoAnyCourseException, IncorrectNoteException {
        super(facultyName, groupNumber);
        this.name = name;
        this.courses = courses;

        if (courses.size() == 0) {

            System.out.println("No any course");
            throw new NoAnyCourseException();
        } else if (courses.values().stream()
                .filter(a -> a >= 0 && a <= 10)
                .toArray().length != courses.size()) {

            System.out.println("Incorrect note");
            throw new IncorrectNoteException();
        }
    }

    public double getStudentAverageNote() {
        double coursesQuantity = courses.size();
        double totalNotes = 0;
        for (int value : courses.values()) {
            totalNotes += value;
        }

        return totalNotes / coursesQuantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Courses, Integer> getCourses() {
        return courses;
    }

    public void setCourses(Map<Courses, Integer> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", name='" + name + '\'' +
                        ", courses=" + courses +
                        "}");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getName().equals(student.getName()) &&
                getCourses().equals(student.getCourses());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCourses());
    }
}
