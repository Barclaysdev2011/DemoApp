package com.example.demoApp.service;

import com.example.demoApp.repository.StudentRepo;
import com.example.demoApp.entity.Student;
import com.example.demoApp.request.CreateStudentRequest;
import com.example.demoApp.request.UpdateStudent;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class StudentService {
    private StudentRepo studentRepo;


    public List<Student> getAllStudents(){
       return studentRepo.findAll();
    }

    public Student createStudent(CreateStudentRequest createStudentRequest){
        Student student = new Student(createStudentRequest);
        studentRepo.save(student);
        return student;
    }
    public Student updateStudent(UpdateStudent updateStudent){
       Student st=  studentRepo.findById(updateStudent.getId()).get();

       if(updateStudent.getFirstName() !=null && !updateStudent.getFirstName().isEmpty()){
           st.setFirstName(updateStudent.getFirstName());
       }
      st =  studentRepo.save(st);
       return st;
    }
    public String deleteStudent(UUID id){
        studentRepo.deleteById(id);
        return "Student has been deleted";
    }
}
