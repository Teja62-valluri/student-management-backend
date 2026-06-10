package com.teja.studentmanager.Controller;

import com.teja.studentmanager.DTO.StudentRequestDto;
import com.teja.studentmanager.Entity.StudentEntity;
import com.teja.studentmanager.Service.StudentService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// FIXED: Added http://localhost:5174 and http://127.0.0.1:5174 to resolve your active browser block
@CrossOrigin(origins = {
        "http://localhost:5173",
        "http://127.0.0.1:5173",
        "https://student-management-frontend-lac.vercel.app"
})
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Read all students
    @GetMapping
    public List<StudentEntity> getStudents() {
        return studentService.getStudents();
    }

    // Add student
    @PostMapping
    public String addStudent(@Valid @RequestBody StudentRequestDto dto) {
        studentService.addStudent(dto);
        return "Student added successfully";
    }

    // Read single student
    @GetMapping("/{id}")
    public StudentEntity getStudent(@PathVariable int id) {
        return studentService.getStudent(id);
    }

    // Update student
    @PutMapping("/{id}")
    public String updateStudent(@PathVariable int id, @Valid @RequestBody StudentRequestDto dto) {
        studentService.updateStudent(id, dto);
        return "Student " + id + " updated successfully";
    }

    // Delete student
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return "Student " + id + " deleted successfully";
    }
}