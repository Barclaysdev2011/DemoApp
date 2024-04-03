package com.example.demoApp.repository;

import com.example.demoApp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface StudentRepo extends JpaRepository<Student, UUID> {
  List<Student> findByFirstName(String name);
  List<Student> findByFirstNameAndLastName(String first, String last);

  List<Student> findByEmail(String email);

  List<Student> findByFirstNameOrLastName(String first, String last);

//  List<Student> findByFirstNameInLastName(String first, String last);

  List<Student> findByFirstNameIn(List<String> firstNames);
}
