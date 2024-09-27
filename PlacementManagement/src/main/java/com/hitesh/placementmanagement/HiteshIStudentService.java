//package com.hitesh.placementmanagement;
//
//import java.util.List;
//
//public interface HiteshIStudentService {
//	List<HiteshStudent> getAllStudents();
//
//	void addStudent(HiteshStudent s);
//
//	HiteshStudent getStudentById(Long id);
//	void searchStudentById(long id);
//	void searchStudentByHallTicket(long ticketNo);
//	void deleteStudent(Long id);
//	
//
//	void updateStudent(Long id, HiteshStudent s);
//
//}
package com.hitesh.placementmanagement;

import java.util.List;

public interface HiteshIStudentService {

    List<HiteshStudent> getAllStudents();

    void addStudent(HiteshStudent s);

    HiteshStudent getStudentById(Long id);

    HiteshStudent searchStudentById(long id); // Assuming you return a single student here

    void searchStudentByHallTicket(long hallTicketNo); // Return a student by hall ticket

    void deleteStudent(Long id);

    void updateStudent(Long id, HiteshStudent s);

}
