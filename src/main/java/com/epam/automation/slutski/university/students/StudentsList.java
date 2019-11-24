package com.epam.automation.slutski.university.students;

import com.epam.automation.slutski.university.exceptions.IncorrectNoteException;
import com.epam.automation.slutski.university.exceptions.NoAnyCourseException;
import com.epam.automation.slutski.university.exceptions.NoAnyUnityException;
import com.epam.automation.slutski.university.structure.Student;
import com.epam.automation.slutski.university.types.Courses;
import com.epam.automation.slutski.university.types.Faculties;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class StudentsList {

    public static List<? extends Student> getStudentList()
            throws NoAnyUnityException, NoAnyCourseException, IncorrectNoteException {

        List<? extends Student> students = Arrays.asList(

                new Student(Faculties.FRENCH, 110, "Make",
                        new HashMap<Courses, Integer>() {
                            {
                                put(Courses.FRENCH, 10);
                                put(Courses.CULTUROLOGY, 5);
                                put(Courses.LINGUISTICS, 8);
                                put(Courses.PHONETICS_FRENCH, 2);
                                put(Courses.GRAMMAR_FRENCH, 4);
                            }
                        }),

                new Student(Faculties.FRENCH, 110, "Helene",
                        new HashMap<Courses, Integer>() {
                            {
                                put(Courses.FRENCH, 3);
                                put(Courses.CULTUROLOGY, 4);
                                put(Courses.LINGUISTICS, 5);
                                put(Courses.PHONETICS_FRENCH, 6);
                                put(Courses.GRAMMAR_FRENCH, 7);
                            }
                        }),

                new Student(Faculties.FRENCH, 111, "Oleg",
                        new HashMap<Courses, Integer>() {
                            {
                                put(Courses.FRENCH, 8);
                                put(Courses.CULTUROLOGY, 9);
                                put(Courses.LINGUISTICS, 10);
                                put(Courses.PHONETICS_FRENCH, 9);
                                put(Courses.GRAMMAR_FRENCH, 8);
                            }
                        }),

                new Student(Faculties.FRENCH, 111, "Marina",
                        new HashMap<Courses, Integer>() {
                            {
                                put(Courses.FRENCH, 7);
                                put(Courses.CULTUROLOGY, 6);
                                put(Courses.LINGUISTICS, 5);
                                put(Courses.PHONETICS_FRENCH, 4);
                                put(Courses.GRAMMAR_FRENCH, 3);
                            }
                        }),

                new Student(Faculties.ENGLISH, 112, "Mila",
                        new HashMap<Courses, Integer>() {
                            {
                                put(Courses.ENGLISH, 2);
                                put(Courses.CULTUROLOGY, 1);
                                put(Courses.LINGUISTICS, 0);
                                put(Courses.PHONETICS_ENGLISH, 1);
                                put(Courses.GRAMMAR_ENGLISH, 2);
                            }
                        }),

                new Student(Faculties.ENGLISH, 112, "Andrey",
                        new HashMap<Courses, Integer>() {
                            {
                                put(Courses.ENGLISH, 3);
                                put(Courses.CULTUROLOGY, 4);
                                put(Courses.LINGUISTICS, 5);
                                put(Courses.PHONETICS_ENGLISH, 6);
                                put(Courses.GRAMMAR_ENGLISH, 7);
                            }
                        }),

                new Student(Faculties.ENGLISH, 113, "Anne",
                        new HashMap<Courses, Integer>() {
                            {
                                put(Courses.ENGLISH, 8);
                                put(Courses.CULTUROLOGY, 9);
                                put(Courses.LINGUISTICS, 10);
                                put(Courses.PHONETICS_ENGLISH, 9);
                                put(Courses.GRAMMAR_ENGLISH, 8);
                            }
                        }),

                new Student(Faculties.ENGLISH, 113, "Peter",
                        new HashMap<Courses, Integer>() {
                            {
                                put(Courses.ENGLISH, 7);
                                put(Courses.CULTUROLOGY, 6);
                                put(Courses.LINGUISTICS, 5);
                                put(Courses.PHONETICS_ENGLISH, 4);
                                put(Courses.GRAMMAR_ENGLISH, 3);
                            }
                        }),

                new Student(Faculties.GERMAN, 114, "Victor",
                        new HashMap<Courses, Integer>() {
                            {
                                put(Courses.FRENCH, 2);
                                put(Courses.CULTUROLOGY, 1);
                                put(Courses.LINGUISTICS, 0);
                                put(Courses.PHONETICS_GERMAN, 1);
                                put(Courses.GRAMMAR_GERMAN, 2);
                            }
                        }),

                new Student(Faculties.GERMAN, 114, "Dacha",
                        new HashMap<Courses, Integer>() {
                            {
                                put(Courses.GERMAN, 3);
                                put(Courses.CULTUROLOGY, 4);
                                put(Courses.LINGUISTICS, 5);
                                put(Courses.PHONETICS_GERMAN, 6);
                                put(Courses.GRAMMAR_GERMAN, 7);
                            }
                        }),

                new Student(Faculties.GERMAN, 115, "Micha",
                        new HashMap<Courses, Integer>() {
                            {
                                put(Courses.GERMAN, 8);
                                put(Courses.CULTUROLOGY, 9);
                                put(Courses.LINGUISTICS, 10);
                                put(Courses.PHONETICS_GERMAN, 9);
                                put(Courses.GRAMMAR_GERMAN, 8);
                            }
                        }),

                new Student(Faculties.GERMAN, 115, "Macha",
                        new HashMap<Courses, Integer>() {
                            {
                                put(Courses.GERMAN, 7);
                                put(Courses.CULTUROLOGY, 6);
                                put(Courses.LINGUISTICS, 5);
                                put(Courses.PHONETICS_GERMAN, 4);
                                put(Courses.GRAMMAR_GERMAN, 3);
                            }
                        }),

                new Student(Faculties.SPANISH, 116, "Vlad",
                        new HashMap<Courses, Integer>() {
                            {
                                put(Courses.SPANISH, 2);
                                put(Courses.CULTUROLOGY, 1);
                                put(Courses.LINGUISTICS, 0);
                                put(Courses.PHONETICS_SPANISH, 1);
                                put(Courses.GRAMMAR_SPANISH, 2);
                            }
                        }),

                new Student(Faculties.SPANISH, 116, "Alena",
                        new HashMap<Courses, Integer>() {
                            {
                                put(Courses.SPANISH, 3);
                                put(Courses.CULTUROLOGY, 4);
                                put(Courses.LINGUISTICS, 5);
                                put(Courses.PHONETICS_SPANISH, 6);
                                put(Courses.GRAMMAR_SPANISH, 7);
                            }
                        }),

                new Student(Faculties.SPANISH, 117, "Alex",
                        new HashMap<Courses, Integer>() {
                            {
                                put(Courses.SPANISH, 8);
                                put(Courses.CULTUROLOGY, 9);
                                put(Courses.LINGUISTICS, 10);
                                put(Courses.PHONETICS_SPANISH, 9);
                                put(Courses.GRAMMAR_SPANISH, 8);
                            }
                        }),

                new Student(Faculties.SPANISH, 117, "Sveta",
                        new HashMap<Courses, Integer>() {
                            {
                                put(Courses.SPANISH, 7);
                                put(Courses.CULTUROLOGY, 6);
                                put(Courses.LINGUISTICS, 5);
                                put(Courses.PHONETICS_SPANISH, 4);
                                put(Courses.GRAMMAR_SPANISH, 3);
                            }
                        })
        );

        return students;
    }
}
