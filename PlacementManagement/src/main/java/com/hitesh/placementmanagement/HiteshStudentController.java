package com.hitesh.placementmanagement;

import com.hitesh.placement.exceptions.StudentNotFoundException;
import com.hitesh.placement.exceptions.StudentServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Allow CORS for this controller
@RequestMapping("/api/hitesh_student")
public class HiteshStudentController {

    @Autowired
    private HiteshIStudentService service;

    /**
     * Fetches all students.
     *
     * @return a ResponseEntity containing a list of HiteshStudent and HttpStatus OK.
     */
    @GetMapping
    public ResponseEntity<?> getAllStudents() {
        try {
            List<HiteshStudent> students = service.getAllStudents();
            return new ResponseEntity<>(students, HttpStatus.OK);
        } catch (StudentServiceException e) {
            return new ResponseEntity<>("Failed to retrieve students", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Fetches a student by ID.
     *
     * @param id the ID of the student.
     * @return a ResponseEntity containing the found student and HttpStatus OK, or HttpStatus NOT_FOUND.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Long id) {
        try {
            HiteshStudent student = service.getStudentById(id);
            return new ResponseEntity<>(student, HttpStatus.OK);
        } catch (StudentNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (StudentServiceException e) {
            return new ResponseEntity<>("Service error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Adds a new student.
     *
     * @param student the student to be added.
     * @return a ResponseEntity with a success message and HttpStatus CREATED.
     */
    @PostMapping
    public ResponseEntity<?> addStudent(@RequestBody HiteshStudent student) {
        try {
            service.addStudent(student);
            return new ResponseEntity<>("Student added successfully!", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to add student", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Updates a student by ID.
     *
     * @param id the ID of the student to be updated.
     * @param updatedStudent the updated student details.
     * @return a ResponseEntity with a success message and HttpStatus OK, or HttpStatus NOT_FOUND if student is not found.
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody HiteshStudent updatedStudent) {
        try {
            HiteshStudent existingStudent = service.getStudentById(id);
            if (existingStudent != null) {
                service.updateStudent(id, updatedStudent);
                return new ResponseEntity<>("Student updated successfully!", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
            }
        } catch (StudentNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to update student", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Deletes a student by ID.
     *
     * @param id the ID of the student to be deleted.
     * @return a ResponseEntity with a success message and HttpStatus OK, or HttpStatus NOT_FOUND if student is not found.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        try {
            HiteshStudent existingStudent = service.getStudentById(id);
            if (existingStudent != null) {
                service.deleteStudent(id);
                return new ResponseEntity<>("Student deleted successfully!", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
            }
        } catch (StudentNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete student", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
