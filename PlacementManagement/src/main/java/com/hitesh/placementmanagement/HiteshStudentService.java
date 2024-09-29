package com.hitesh.placementmanagement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

/**
 * Service class implementing student management operations.
 */
@Transactional
@Service
public class HiteshStudentService implements HiteshIStudentService {

    @Autowired
    HiteshIStudentRepository repo;

    /**
     * Retrieves all students from the repository.
     *
     * @return list of all students
     */
    @Override
    public List<HiteshStudent> getAllStudents() {
        return repo.findAll();
    }

    /**
     * Adds a new student to the repository.
     *
     * @param student the student object to be added
     */
    @Override
    public void addStudent(HiteshStudent student) {
        repo.save(student);
    }

    /**
     * Retrieves a student by their unique ID.
     *
     * @param id the student ID
     * @return the student object if found, otherwise null
     */
    @Override
    public HiteshStudent getStudentById(Long id) {
        Optional<HiteshStudent> student = repo.findById(id);
        return student.orElse(null); // Returns null if student is not found
    }

    /**
     * Updates the student details for the given student ID.
     *
     * @param id the ID of the student to update
     * @param student the updated student object
     */
    @Override
    public void updateStudent(Long id, HiteshStudent student) {
        Optional<HiteshStudent> existingStudent = repo.findById(id);
        if (existingStudent.isPresent()) {
            student.setId(id); // Ensures the ID remains the same
            repo.save(student);
        } else {
            System.out.println("Student record not found for ID: " + id);
        }
    }

    /**
     * Deletes the student with the given ID.
     *
     * @param id the student ID
     */
    @Override
    public void deleteStudent(Long id) {
        if (repo.findById(id).isPresent()) {
            repo.deleteById(id);
        } else {
            System.out.println("Student record not found for ID: " + id);
        }
    }

    /**
     * Searches for a student by their unique ID.
     *
     * @param id the student ID
     * @return the student object if found, otherwise null
     */
    @Override
    public HiteshStudent searchStudentById(long id) {
        Optional<HiteshStudent> student = repo.findById(id);
        return student.orElse(null); // Handle null in the controller if needed
    }

    /**
     * Searches for a student by their hall ticket number.
     *
     * @param hallTicketNo the hall ticket number
     * @return the student with the given hall ticket number, if found
     */
    @Override
    public HiteshStudent searchStudentByHallTicket(long hallTicketNo) {
        Optional<HiteshStudent> student = repo.findByHallTicketNo(hallTicketNo);
        return student.orElse(null); // Assuming `findByHallTicketNo` exists in the repository
    }
}
