package com.epam.automation.slutski.university;

import com.epam.automation.slutski.university.exceptions.IncorrectNoteException;
import com.epam.automation.slutski.university.exceptions.NoAnyCourseException;
import com.epam.automation.slutski.university.exceptions.NoAnyUnityException;
import com.epam.automation.slutski.university.logic.UniversityLogic;
import com.epam.automation.slutski.university.structure.Faculty;
import com.epam.automation.slutski.university.structure.Group;
import com.epam.automation.slutski.university.structure.Student;
import com.epam.automation.slutski.university.students.StudentsList;
import com.epam.automation.slutski.university.types.Faculties;

import java.util.HashMap;
import java.util.List;

public class UniversityController{

    public static void main(String[] args) throws NoAnyCourseException, IncorrectNoteException, NoAnyUnityException {

        try{
            List<? extends Student> students = StudentsList.getStudentList();

            UniversityLogic university = new UniversityLogic(students);

            Student student = new Student();


        } catch (NoAnyCourseException | IncorrectNoteException | NoAnyUnityException e) {
            System.out.println(e);
        }
    }
}
