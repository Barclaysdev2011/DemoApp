package com.example.demoApp.repository;

import com.example.demoApp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentRepo extends JpaRepository<Student, UUID> {
}
