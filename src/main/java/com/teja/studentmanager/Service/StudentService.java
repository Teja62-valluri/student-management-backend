package com.teja.studentmanager.Service;


import com.teja.studentmanager.DTO.StudentRequestDto;
import com.teja.studentmanager.Entity.StudentEntity;
import com.teja.studentmanager.Repository.StudentRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void addStudent(StudentRequestDto dto){
        if (studentRepository.existsById(dto.getId())) {
            throw new IllegalArgumentException("Student already exists with this ID");
        }
        StudentEntity entity = convertToEntity(dto);

        studentRepository.save(entity);
    }

    //DTO object----> entity conversion
    private StudentEntity convertToEntity(StudentRequestDto dto){
        StudentEntity entity = new StudentEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setDepartment(dto.getDepartment());
        entity.setPhone(dto.getPhone());
        return entity;
    }

    // reads aa students by (repository)
    public List<StudentEntity> getStudents() {

        return studentRepository.findAll();
    }

    // read student by id
    public StudentEntity getStudent(int id){
        if(!studentRepository.existsById(id)){
            throw new IllegalArgumentException("Student not found by this ID");
        }
        return studentRepository.findById(id).get();
    }


    // delete student by id
    public void deleteStudent(int id) {
        if(!studentRepository.existsById(id)){
            throw new IllegalArgumentException("Student not found by this ID");
        }
        studentRepository.deleteById(id);
    }

    // update
    public void updateStudent(int id,StudentRequestDto dto){
        if(!studentRepository.existsById(id)){
            throw new IllegalArgumentException("Student not found by this ID");
        }
        StudentEntity entity = studentRepository.findById(id).get();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setDepartment(dto.getDepartment());
        entity.setPhone(dto.getPhone());
        studentRepository.save(entity);
    }
}
