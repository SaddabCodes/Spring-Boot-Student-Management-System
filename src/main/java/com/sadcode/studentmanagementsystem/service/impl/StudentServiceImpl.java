package com.sadcode.studentmanagementsystem.service.impl;

import com.sadcode.studentmanagementsystem.dto.StudentDto;
import com.sadcode.studentmanagementsystem.entity.Student;
import com.sadcode.studentmanagementsystem.mapper.StudentMapper;
import com.sadcode.studentmanagementsystem.repository.StudentRepository;
import com.sadcode.studentmanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtos = students.stream().map((student) -> StudentMapper.mapToStudentDto(student))
                .collect(Collectors.toList());
        return studentDtos;
    }
}
