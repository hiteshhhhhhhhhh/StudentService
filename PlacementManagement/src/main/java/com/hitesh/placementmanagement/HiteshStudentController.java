package com.hitesh.placementmanagement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hitesh_student")
public class HiteshStudentController {

    @Autowired
    private HiteshStudentService service;

    /**
     * Fetches all students.
     *
     * @return a ResponseEntity containing a list of HiteshStudent and HttpStatus OK.
     */
    @GetMapping
    public ResponseEntity<List<HiteshStudent>> getAllStudents() {
        try {
            List<HiteshStudent> students = service.getAllStudents();
            return new ResponseEntity<>(students, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Fetches a student by ID.
     *
     * @param id the ID of the student.
     * @return a ResponseEntity containing the found student and HttpStatus OK, or HttpStatus NOT_FOUND.
     */
    @GetMapping("/{id}")
    public ResponseEntity<HiteshStudent> getStudent(@PathVariable Long id) {
        try {
            HiteshStudent student = service.getStudentById(id);
            return student != null
                ? new ResponseEntity<>(student, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Adds a new student.
     *
     * @param student the student to be added.
     * @return a ResponseEntity with a success message and HttpStatus CREATED.
     */
    @PostMapping
    public ResponseEntity<String> addStudent(@RequestBody HiteshStudent student) {
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
    public ResponseEntity<String> updateStudent(@PathVariable Long id, @RequestBody HiteshStudent updatedStudent) {
        try {
            HiteshStudent existingStudent = service.getStudentById(id);
            if (existingStudent != null) {
                service.updateStudent(id, updatedStudent);
                return new ResponseEntity<>("Student updated successfully!", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
            }
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
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        try {
            HiteshStudent existingStudent = service.getStudentById(id);
            if (existingStudent != null) {
                service.deleteStudent(id);
                return new ResponseEntity<>("Student deleted successfully!", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete student", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
