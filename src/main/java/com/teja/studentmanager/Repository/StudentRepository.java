package com.teja.studentmanager.Repository;

import com.teja.studentmanager.Entity.StudentEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

}