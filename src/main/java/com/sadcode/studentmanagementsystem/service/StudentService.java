package com.sadcode.studentmanagementsystem.service;

import com.sadcode.studentmanagementsystem.dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto>getAllStudents();

    void createStudent(StudentDto studentDto);
}
