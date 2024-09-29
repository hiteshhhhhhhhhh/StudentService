package com.hitesh.placementmanagement;

import java.util.List;

/**
 * Interface for managing student operations in the placement management system.
 */
public interface HiteshIStudentService {

    /**
     * Retrieves all students from the system.
     *
     * @return a list of all students
     */
    List<HiteshStudent> getAllStudents();

    /**
     * Adds a new student to the system.
     *
     * @param student the student object to be added
     */
    void addStudent(HiteshStudent student);

    /**
     * Retrieves a student by their unique ID.
     *
     * @param id the unique ID of the student
     * @return the student with the specified ID, or null if not found
     */
    HiteshStudent getStudentById(Long id);

    /**
     * Searches for a student by their unique ID.
     *
     * @param id the unique ID of the student
     * @return the student with the specified ID, or null if not found
     */
    HiteshStudent searchStudentById(long id);

    /**
     * Searches for a student by their hall ticket number.
     *
     * @param hallTicketNo the hall ticket number of the student
     * @return the student with the specified hall ticket number, or null if not found
     */
    HiteshStudent searchStudentByHallTicket(long hallTicketNo);

    /**
     * Deletes a student by their unique ID.
     *
     * @param id the unique ID of the student to be deleted
     */
    void deleteStudent(Long id);

    /**
     * Updates an existing student with new details.
     *
     * @param id the unique ID of the student to be updated
     * @param student the student object containing updated details
     */
    void updateStudent(Long id, HiteshStudent student);
}
