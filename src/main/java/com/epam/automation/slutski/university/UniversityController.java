package com.epam.automation.slutski.university;

import com.epam.automation.slutski.university.exceptions.IncorrectNoteException;
import com.epam.automation.slutski.university.exceptions.NoAnyCourseException;
import com.epam.automation.slutski.university.exceptions.NoAnyUnityException;
import com.epam.automation.slutski.university.logic.UniversityLogic;
import com.epam.automation.slutski.university.structure.Student;
import com.epam.automation.slutski.university.students.StudentsList;
import com.epam.automation.slutski.university.types.Courses;
import com.epam.automation.slutski.university.types.Faculties;
import com.epam.automation.slutski.university.view.Printer;

import java.util.List;

public class UniversityController {

    public static void main(String[] args) throws NoAnyCourseException, IncorrectNoteException, NoAnyUnityException {

        try {
            List<? extends Student> students = StudentsList.getStudentList();

            UniversityLogic university = new UniversityLogic(students);

            Printer.print(university.getAverageUniversityCourseNote(Courses.CULTUROLOGY));

            Printer.print(university.getAverageFacultyGroupCourseNote(Faculties.FRENCH, 110, Courses.LINGUISTICS));

            Printer.print(students.get(0).getStudentAverageNote());

        } catch (NoAnyCourseException | IncorrectNoteException | NoAnyUnityException e) {
            e.printStackTrace();
        }
    }
}
