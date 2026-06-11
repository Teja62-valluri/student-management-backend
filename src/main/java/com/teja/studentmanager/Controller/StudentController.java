package com.teja.studentmanager.Controller;

import com.teja.studentmanager.DTO.StudentRequestDto;
import com.teja.studentmanager.Entity.StudentEntity;
import com.teja.studentmanager.Service.StudentService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<StudentEntity> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public String addStudent(@Valid @RequestBody StudentRequestDto dto) {
        studentService.addStudent(dto);
        return "Student added successfully";
    }

    @GetMapping("/{id}")
    public StudentEntity getStudent(@PathVariable int id) {
        return studentService.getStudent(id);
    }

    @PutMapping("/{id}")
    public String updateStudent(@PathVariable int id,
                                @Valid @RequestBody StudentRequestDto dto) {
        studentService.updateStudent(id, dto);
        return "Student " + id + " updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return "Student " + id + " deleted successfully";
    }
}