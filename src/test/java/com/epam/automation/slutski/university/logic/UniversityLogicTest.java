package com.epam.automation.slutski.university.logic;

import com.epam.automation.slutski.university.exceptions.IncorrectNoteException;
import com.epam.automation.slutski.university.exceptions.NoAnyCourseException;
import com.epam.automation.slutski.university.exceptions.NoAnyUnityException;
import com.epam.automation.slutski.university.structure.Faculty;
import com.epam.automation.slutski.university.structure.Group;
import com.epam.automation.slutski.university.structure.Student;
import com.epam.automation.slutski.university.students.StudentsList;
import com.epam.automation.slutski.university.types.Courses;
import com.epam.automation.slutski.university.types.Faculties;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UniversityLogicTest {

    private List<? extends Student> students = StudentsList.getStudentList();

    public UniversityLogicTest() throws IncorrectNoteException, NoAnyCourseException, NoAnyUnityException {
    }

    @Test(expected = NoAnyUnityException.class)
    public void noAnyFacultyAtUniversityFromFaculty() throws NoAnyUnityException {
        Faculty faculty = new Faculty();
    }

    @Test(expected = NoAnyUnityException.class)
    public void noAnyFacultyAtUniversityFromGroup() throws NoAnyUnityException {
        Group group = new Group();
    }

    @Test(expected = NoAnyUnityException.class)
    public void noAnyFacultyAtUniversityFromStudent() throws NoAnyUnityException {
        Student student = new Student();
    }

    @Test(expected = NoAnyUnityException.class)
    public void noAnyGroupAtFacultyFromGroup() throws NoAnyUnityException {
        Group group = new Group(Faculties.FRENCH);
    }

    @Test(expected = NoAnyUnityException.class)
    public void noAnyGroupAtFacultyFromStudent() throws NoAnyUnityException {
        Student student = new Student(Faculties.FRENCH);
    }

    @Test(expected = NoAnyUnityException.class)
    public void noAnyStudentAtGroup() throws NoAnyUnityException {
        Student student = new Student(Faculties.FRENCH, 110);
    }

    @Test(expected = NoAnyCourseException.class)
    public void studentHasNotAnyCourseAtAll() throws NoAnyCourseException {
        Student student = new Student(Faculties.FRENCH, 110, "Jeanne");
    }

    @Test(expected = NoAnyCourseException.class)
    public void studentHasNotAnyCourse() throws NoAnyCourseException, IncorrectNoteException {
        Student student = new Student(Faculties.FRENCH, 110, "Jeanne", new HashMap<>());
    }

    @Test(expected = IncorrectNoteException.class)
    public void studentHasIncorrectCourseNote() throws NoAnyCourseException, IncorrectNoteException {
        Student student = new Student(Faculties.FRENCH, 111, "Oleg",
                new HashMap<Courses, Integer>() {
                    {
                        put(Courses.FRENCH, 8);
                        put(Courses.CULTUROLOGY, 11);
                        put(Courses.LINGUISTICS, 10);
                        put(Courses.PHONETICS_FRENCH, 9);
                        put(Courses.GRAMMAR_FRENCH, 8);
                    }
                });
    }

    @Test(expected = NoAnyUnityException.class)
    public void averageFacultyGroupCourseNoteExceptionOfFaculty() throws NoAnyCourseException, NoAnyUnityException {

        UniversityLogic university = new UniversityLogic(students);

        university.getAverageFacultyGroupCourseNote(Faculties.ITALIAN, 110, Courses.FRENCH);
    }

    @Test(expected = NoAnyUnityException.class)
    public void averageFacultyGroupCourseNoteExceptionOfGroup() throws NoAnyCourseException, NoAnyUnityException {

        UniversityLogic university = new UniversityLogic(students);

        university.getAverageFacultyGroupCourseNote(Faculties.FRENCH, 8110, Courses.FRENCH);
    }

    @Test(expected = NoAnyCourseException.class)
    public void averageFacultyGroupCourseNoteExceptionOfCourse() throws NoAnyCourseException, NoAnyUnityException {

        UniversityLogic university = new UniversityLogic(students);

        university.getAverageFacultyGroupCourseNote(Faculties.FRENCH, 110, Courses.MATH);
    }

    @Test(expected = NoAnyCourseException.class)
    public void averageUniversityCourseNoteException() throws NoAnyCourseException {

        UniversityLogic university = new UniversityLogic(students);

        university.getAverageUniversityCourseNote(Courses.MATH);
    }

    @Test
    public void averageStudentCourseNote() throws NoAnyCourseException, IncorrectNoteException {
        Student student = new Student(Faculties.FRENCH, 111, "Oleg",
                new HashMap<Courses, Integer>() {
                    {
                        put(Courses.FRENCH, 10);
                        put(Courses.CULTUROLOGY, 10);
                        put(Courses.LINGUISTICS, 10);
                        put(Courses.PHONETICS_FRENCH, 10);
                        put(Courses.GRAMMAR_FRENCH, 10);
                    }
                });
        assertEquals(10, (int) student.getStudentAverageNote());
    }

    @Test
    public void averageFacultyGroupCourseNote() throws NoAnyCourseException, NoAnyUnityException {
        UniversityLogic university = new UniversityLogic(students);

        double average = university.getAverageFacultyGroupCourseNote(Faculties.FRENCH, 110, Courses.FRENCH);

        assertEquals(7, (int) average);
    }

    @Test
    public void averageUniversityCourseNote() throws NoAnyCourseException {
        UniversityLogic university = new UniversityLogic(students);

        double average = university.getAverageUniversityCourseNote(Courses.FRENCH);

        assertEquals(7, (int) average);
    }
}
