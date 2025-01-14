package com.sadcode.studentmanagementsystem.controller;

import com.sadcode.studentmanagementsystem.dto.StudentDto;
import com.sadcode.studentmanagementsystem.entity.Student;
import com.sadcode.studentmanagementsystem.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    /* handler method to handle list students request */
    @GetMapping("/students")
    public String listStudent(Model model) {
        List<StudentDto> students = studentService.getAllStudents();
        model.addAttribute("student", students);
        return "students";
    }

    /* handler method to handle new students request */
    @GetMapping("students/new")
    public String newStudent(Model model) {
        /* student model object to store student from data */
        StudentDto studentDto = new StudentDto();
        model.addAttribute("student", studentDto);
        return "create_student";
    }

    /* handle method to handle save student form submit reques */
    @PostMapping("/students")
    public String saveStudent(@Valid @ModelAttribute("student") StudentDto studentDto, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("student",studentDto);
            return "create_student";
        }
        studentService.createStudent(studentDto);
        return "redirect:/students";
    }

    /* handler method to handle edit student request */
    @GetMapping("/students/{studentId}/edit")
    public String editStudent(@PathVariable("studentId")Long studentId,Model model){
        StudentDto student = studentService.getStudentById(studentId);
        model.addAttribute("student",student);
        return "edit_student";
    }

    /* handler method to handle edit student form submit request */
    @PostMapping("/students/{studentId}")
    public String updateStudent(@PathVariable("studentId") Long studentId, @Valid @ModelAttribute("student")StudentDto studentDto,
                                BindingResult result,Model model
                                ){
        if (result.hasErrors()){
            model.addAttribute("student",studentDto);
            return "edit_student";
        }
        studentDto.setId(studentId);
        studentService.updateStudent(studentDto);
        return "redirect:/students";

    }

    /* handler method to handle delete student request */

    @GetMapping("/students/{id}/delete")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

    /* handler method to handle view student request */
    @GetMapping("/students/{id}/view")
    public String viewStudent(@PathVariable Long id, Model model){
        StudentDto studentDto = studentService.getStudentById(id);
        model.addAttribute("student",studentDto);
        return "view_student";

    }


}
