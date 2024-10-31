package com.hitesh.placementmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hitesh.placement.exceptions.StudentNotFoundException;
import com.hitesh.placement.exceptions.StudentServiceException;

import jakarta.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class HiteshStudentService implements HiteshIStudentService {

    @Autowired
    private HiteshIStudentRepository repo;

    @Override
    public List<HiteshStudent> getAllStudents() {
        try {
            return repo.findAll();
        } catch (Exception e) {
            throw new StudentServiceException("Failed to retrieve students");
        }
    }

    @Override
    public HiteshStudent getStudentById(Long id) {
        return repo.findById(id).orElseThrow(() -> 
            new StudentNotFoundException("Student with ID " + id + " not found"));
    }

    @Override
    public void deleteStudent(Long id) {
        if (!repo.existsById(id)) {
            throw new StudentNotFoundException("Student with ID " + id + " not found");
        }
        try {
            repo.deleteById(id);
        } catch (Exception e) {
            throw new StudentServiceException("Failed to delete student");
        }
    }

    @Override
    public void addStudent(HiteshStudent student) {
        try {
            repo.save(student);
        } catch (Exception e) {
            throw new StudentServiceException("Failed to add student");
        }
    }

    @Override
    public HiteshStudent searchStudentById(long id) {
        return repo.findById(id).orElseThrow(() -> 
            new StudentNotFoundException("Student with ID " + id + " not found"));
    }

    @Override
    public HiteshStudent searchStudentByHallTicket(long hallTicketNo) {
        return repo.findByHallTicketNo(hallTicketNo).orElseThrow(() -> 
            new StudentNotFoundException("Student with Hall Ticket No " + hallTicketNo + " not found"));
    }

    @Override
    public void updateStudent(Long id, HiteshStudent updatedStudent) {
        HiteshStudent existingStudent = getStudentById(id); // This will throw if not found
        try {
            updatedStudent.setStudent_name(existingStudent.getStudent_name()); // Retain the same ID
            repo.save(updatedStudent); // Save the updated student
        } catch (Exception e) {
            throw new StudentServiceException("Failed to update student");
        }
    }

    // Other methods here...
}
