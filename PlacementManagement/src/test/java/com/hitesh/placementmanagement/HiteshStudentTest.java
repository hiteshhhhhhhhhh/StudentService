package com.hitesh.placementmanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HiteshStudentTest {

    private HiteshStudent student;
    

    @BeforeEach
    public void setUp() {
        // Creating dummy college and certificate objects
        //college = new College(101, "XYZ College", "Location1", null);
        
        // Adjusting to match the actual Certificate constructor
        //certificate = new Certificate(1001, 2023, college);

       // company = new Company(1001, "TechCorp", 5.5f);

        student = new HiteshStudent();
       // student.setCollege(college);
        //student.setCertificate(certificate);
       // student.setCompany(company);
    }

    @Test
    public void testStudentName() {
        assertEquals("John Doe", student.getName(), "Student name should be John Doe");
    }

    @Test
    public void testStudentRoll() {
        assertEquals(123456789L, student.getRoll_no(), "Student roll number should be 123456789");
    }

    @Test
    public void testStudentQualification() {
        assertEquals("B.Tech", student.getQualification(), "Student qualification should be B.Tech");
    }

	/*
	 * @Test public void testStudentCollege() { assertNotNull(student.getCollege(),
	 * "College should not be null"); assertEquals("XYZ College",
	 * student.getCollege().getCollegeName(), "College name should be XYZ College");
	 * }
	 */

	/*
	 * @Test public void testStudentCertificate() {
	 * assertNotNull(student.getCertificate(), "Certificate should not be null");
	 * assertEquals(2023, student.getCertificate().getYear(),
	 * "Certificate year should be 2023"); }
	 */

    // Two failing test cases for demonstration (in comments)

    /*
    @Test
    public void testFailingStudentName() {
        // This will fail because the name is "John Doe", not "Jane Doe"
        assertEquals("Jane Doe", student.getName(), "This test should fail");
    }

    @Test
    public void testFailingStudentRoll() {
        // This will fail because the roll number is 123456789, not 987654321
        assertEquals(987654321L, student.getRoll(), "This test should fail");
    }
    */
}