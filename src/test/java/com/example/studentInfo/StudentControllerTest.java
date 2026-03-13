package com.example.studentInfo;

import com.example.studentInfo.bean.StudentRank;
import com.example.studentInfo.bean.Students;
import com.example.studentInfo.controller.StudentController;
import com.example.studentInfo.service.StudentInfoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class StudentControllerTest {

    @Mock
    private StudentInfoService studentInfoService;

    @InjectMocks
    private StudentController studentController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void addStudentSavesStudentSuccessfully() {
        Students student = new Students(1, "John Doe", "10A", 85);

        studentController.addStudent(student);

        verify(studentInfoService, times(1)).saveDetails(student);
    }

    @Test
    public void addStudentWithValidData() {
        Students student = new Students(2, "Jane Smith", "10B", 92);

        studentController.addStudent(student);

        verify(studentInfoService).saveDetails(argThat(s ->
                s.getId() == 2 &&
                s.getName().equals("Jane Smith") &&
                s.getStandard().equals("10B") &&
                s.getMarks() == 92
        ));
    }

    @Test
    public void getStudentReturnsListOfStudents() {
        Students student1 = new Students(1, "John Doe", "10A", 85);
        Students student2 = new Students(2, "Jane Smith", "10B", 92);
        List<Students> studentList = Arrays.asList(student1, student2);

        when(studentInfoService.getStudents()).thenReturn(studentList);

        List<Students> result = studentController.getStudent();

        assertEquals(2, result.size());
        assertEquals("John Doe", result.get(0).getName());
        assertEquals("Jane Smith", result.get(1).getName());
    }

    @Test
    public void getStudentReturnsEmptyListWhenNoStudentsExist() {
        List<Students> emptyList = new ArrayList<>();

        when(studentInfoService.getStudents()).thenReturn(emptyList);

        List<Students> result = studentController.getStudent();

        assertTrue(result.isEmpty());
        assertEquals(0, result.size());
    }

    @Test
    public void getStudentReturnsEmptyListWhenServiceThrowsException() {
        when(studentInfoService.getStudents()).thenThrow(new RuntimeException("Database error"));

        List<Students> result = studentController.getStudent();

        assertTrue(result.isEmpty());
    }

    @Test
    public void getStudentHandlesExceptionGracefully() {
        when(studentInfoService.getStudents()).thenThrow(new RuntimeException("Connection failed"));

        List<Students> result = studentController.getStudent();

        assertNotNull(result);
        assertTrue(result instanceof List);
    }

    @Test
    public void getStudentRankReturnsListOfStudentRanks() {
        StudentRank rank1 = new StudentRank(1, "John Doe", "10A", 85);
        StudentRank rank2 = new StudentRank(2, "Jane Smith", "10B", 92);
        List<StudentRank> rankList = Arrays.asList(rank1, rank2);

        when(studentInfoService.getRankStandardwise()).thenReturn(rankList);

        List<StudentRank> result = studentController.getStudentRank();

        assertEquals(2, result.size());
        assertEquals("John Doe", result.get(0).getName());
        assertEquals(92, result.get(1).getMarks());
    }

    @Test
    public void getStudentRankReturnsEmptyListWhenNoRanksAvailable() {
        List<StudentRank> emptyList = new ArrayList<>();

        when(studentInfoService.getRankStandardwise()).thenReturn(emptyList);

        List<StudentRank> result = studentController.getStudentRank();

        assertTrue(result.isEmpty());
    }

    @Test
    public void getStudentRankWithHighMarksReturned() {
        StudentRank topStudent = new StudentRank(1, "Excellent Student", "12A", 99);
        List<StudentRank> rankList = Arrays.asList(topStudent);

        when(studentInfoService.getRankStandardwise()).thenReturn(rankList);

        List<StudentRank> result = studentController.getStudentRank();

        assertEquals(99, result.get(0).getMarks());
        assertEquals("12A", result.get(0).getStandard());
    }

    @Test
    public void addStudentWithMinimumMarks() {
        Students student = new Students(3, "Test Student", "9A", 0);

        studentController.addStudent(student);

        verify(studentInfoService).saveDetails(any(Students.class));
    }

    @Test
    public void addStudentWithMaximumMarks() {
        Students student = new Students(4, "Top Student", "12A", 100);

        studentController.addStudent(student);

        verify(studentInfoService).saveDetails(any(Students.class));
    }

    @Test
    public void getStudentReturnsStudentWithHighestMarks() {
        Students topStudent = new Students(1, "Topper", "10A", 99);
        List<Students> studentList = Arrays.asList(topStudent);

        when(studentInfoService.getStudents()).thenReturn(studentList);

        List<Students> result = studentController.getStudent();

        assertEquals(99, result.get(0).getMarks());
        assertEquals("Topper", result.get(0).getName());
    }

    @Test
    public void getStudentRankReturnMultipleStudentsFromSameClass() {
        StudentRank student1 = new StudentRank(1, "Student A", "10A", 85);
        StudentRank student2 = new StudentRank(2, "Student B", "10A", 88);
        StudentRank student3 = new StudentRank(3, "Student C", "10B", 90);
        List<StudentRank> rankList = Arrays.asList(student1, student2, student3);

        when(studentInfoService.getRankStandardwise()).thenReturn(rankList);

        List<StudentRank> result = studentController.getStudentRank();

        assertEquals(3, result.size());
        assertEquals("10A", result.get(0).getStandard());
        assertEquals("10B", result.get(2).getStandard());
    }

    @Test
    public void getStudentVerifyServiceIsCalledOnce() {
        when(studentInfoService.getStudents()).thenReturn(new ArrayList<>());

        studentController.getStudent();

        verify(studentInfoService, times(1)).getStudents();
    }

    @Test
    public void getStudentRankVerifyServiceIsCalledOnce() {
        when(studentInfoService.getRankStandardwise()).thenReturn(new ArrayList<>());

        studentController.getStudentRank();

        verify(studentInfoService, times(1)).getRankStandardwise();
    }

    private void assertNotNull(Object object) {
        org.junit.jupiter.api.Assertions.assertNotNull(object);
    }
}
