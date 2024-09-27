/*
 * package com.hitesh.placementmanagement;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.DeleteMapping; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.PutMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * @RestController
 * 
 * public class HiteshStudentController {
 * 
 * @Autowired HiteshStudentService service;
 * 
 * @GetMapping("/Students") public List<HiteshStudent> getAllStudents() {
 * 
 * return service.getAllStudents(); }
 * 
 * @GetMapping("/Student/{id}") public ResponseEntity<HiteshStudent>
 * getStudent(@PathVariable Long id) {
 * 
 * return new ResponseEntity<HiteshStudent>(service.getStudentById(id),
 * HttpStatus.OK); }
 * 
 * @PostMapping("/Students") public void add(@RequestBody HiteshStudent p) {
 * 
 * service.addStudent(p); }
 * 
 * @PutMapping("/Student/{id}") public void update(@PathVariable Long
 * id, @RequestBody HiteshStudent p) {
 * 
 * service.updateStudent(id, p); }
 * 
 * @DeleteMapping("/Student/{id}") public void delete(@PathVariable Long id) {
 * 
 * service.deleteStudent(id); }
 * 
 * 
 * }
 */
package com.hitesh.placementmanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiteshStudentController {
    
    @Autowired
    HiteshStudentService service;
    
    // Fetch all students
    @GetMapping("/hitesh_student")
    public ResponseEntity<List<HiteshStudent>> getAllStudents() {
        List<HiteshStudent> students = service.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    
    // Fetch a student by ID
    @GetMapping("/hitesh_student/{id}")
    public ResponseEntity<HiteshStudent> getStudent(@PathVariable Long id) {
        HiteshStudent student = service.getStudentById(id);
        if (student != null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    // Add a new student
    @PostMapping("/hitesh_student")
    public ResponseEntity<String> addStudent(@RequestBody HiteshStudent student) {
        service.addStudent(student);
        return new ResponseEntity<>("Student added successfully!", HttpStatus.CREATED);
    }
    
    // Update a student by ID
    @PutMapping("/hitesh_student/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable Long id, @RequestBody HiteshStudent updatedStudent) {
        HiteshStudent existingStudent = service.getStudentById(id);
        if (existingStudent != null) {
            service.updateStudent(id, updatedStudent);
            return new ResponseEntity<>("Student updated successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
        }
    }
    
    // Delete a student by ID
    @DeleteMapping("/hitesh_student{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        HiteshStudent existingStudent = service.getStudentById(id);
        if (existingStudent != null) {
            service.deleteStudent(id);
            return new ResponseEntity<>("Student deleted successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
        }
    }
}
