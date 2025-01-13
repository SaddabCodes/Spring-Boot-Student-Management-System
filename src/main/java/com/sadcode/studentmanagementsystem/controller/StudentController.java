package com.sadcode.studentmanagementsystem.controller;

import com.sadcode.studentmanagementsystem.dto.StudentDto;
import com.sadcode.studentmanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /* handler method to handle list students request */
    @GetMapping("/get")
   public String listStudent(Model model){
       List<StudentDto> students = studentService.getAllStudents();
       model.addAttribute("student",students);
       return "students";
   }

    /* handler method to handle new students request */

}
