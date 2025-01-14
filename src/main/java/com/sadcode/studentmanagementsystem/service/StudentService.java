package com.sadcode.studentmanagementsystem.service;

import com.sadcode.studentmanagementsystem.dto.StudentDto;
import jakarta.validation.Valid;

import java.util.List;

public interface StudentService {
    List<StudentDto>getAllStudents();

    void createStudent(StudentDto studentDto);
    StudentDto getStudentById(Long id);

    void updateStudent(@Valid StudentDto studentDto);

    void deleteStudent(Long id);
}
