package com.epam.automation.slutski.university;

import com.epam.automation.slutski.university.exceptions.IncorrectNoteException;
import com.epam.automation.slutski.university.exceptions.NoAnyCourseException;
import com.epam.automation.slutski.university.exceptions.NoAnyUnityException;
import com.epam.automation.slutski.university.logic.UniversityLogic;
import com.epam.automation.slutski.university.structure.Faculty;
import com.epam.automation.slutski.university.structure.Student;
import com.epam.automation.slutski.university.students.StudentsList;
import com.epam.automation.slutski.university.types.Courses;
import com.epam.automation.slutski.university.types.Faculties;
import org.apache.log4j.Logger;

import java.util.List;

public class UniversityController {

    static Logger logger = Logger.getLogger(UniversityController.class);

    public static void main(String[] args) throws NoAnyCourseException, IncorrectNoteException, NoAnyUnityException {

        try {
            List<? extends Student> students = StudentsList.getStudentList();

            UniversityLogic university = new UniversityLogic(students);

            logger.info(university.getAverageUniversityCourseNote(Courses.CULTUROLOGY));

            logger.info(university.getAverageFacultyGroupCourseNote(Faculties.FRENCH, 110, Courses.LINGUISTICS));

            logger.info(students.get(0).getStudentAverageNote());

        } catch (NoAnyCourseException | IncorrectNoteException | NoAnyUnityException e) {
            e.printStackTrace();
        }
    }
}
