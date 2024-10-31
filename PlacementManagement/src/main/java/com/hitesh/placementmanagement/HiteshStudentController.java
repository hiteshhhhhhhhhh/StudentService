package com.hitesh.placementmanagement;

import com.hitesh.placement.exceptions.StudentNotFoundException;
import com.hitesh.placement.exceptions.StudentServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/hitesh_student")
public class HiteshStudentController {

    @Autowired
    private HiteshIStudentService service;

    @GetMapping
    public ResponseEntity<?> getAllStudents() {
        try {
            List<HiteshStudent> students = service.getAllStudents();
            return ResponseEntity.ok(students);
        } catch (StudentServiceException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Failed to retrieve students");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Long id) {
        try {
            HiteshStudent student = service.getStudentById(id);
            return ResponseEntity.ok(student);
        } catch (StudentNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body(e.getMessage());
        } catch (StudentServiceException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Service error occurred");
        }
    }

    @PostMapping
    public ResponseEntity<String> addStudent(@RequestBody HiteshStudent student) {
        try {
            service.addStudent(student);
            return ResponseEntity.status(HttpStatus.CREATED)
                                 .body("Student added successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Failed to add student");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable Long id, @RequestBody HiteshStudent updatedStudent) {
        try {
            service.updateStudent(id, updatedStudent);
            return ResponseEntity.ok("Student updated successfully!");
        } catch (StudentNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Failed to update student");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        try {
            service.deleteStudent(id);
            return ResponseEntity.ok("Student deleted successfully!");
        } catch (StudentNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Failed to delete student");
        }
    }
}
