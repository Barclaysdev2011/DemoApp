package com.example.demoApp.controller;

import com.example.demoApp.request.CreateStudentRequest;
import com.example.demoApp.request.UpdateStudent;
import com.example.demoApp.response.StudentResponse;
import com.example.demoApp.entity.Student;
import com.example.demoApp.service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/student")
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;

    @GetMapping("/all")
    public List<StudentResponse> getAllStudents(){
        List<Student> students= studentService.getAllStudents();
        List<StudentResponse> response= new ArrayList<StudentResponse>();
        students.stream().forEach(student ->
                response.add(new StudentResponse(student)));
        return response;
    }

    @PostMapping("/create")
    public StudentResponse createStudent(@Valid @RequestBody CreateStudentRequest createStudentRequest){
       Student student = studentService.createStudent(createStudentRequest);

       return new StudentResponse(student);
    }

    @PutMapping("/update")
    public StudentResponse updateStudent(@RequestBody UpdateStudent updateStudent){
        Student student = studentService.updateStudent(updateStudent);
        return new StudentResponse(student);
    }

//    @DeleteMapping("/delete")
//    public String deleteStudent(@RequestParam UUID id){
//       return studentService.deleteStudent(id);
//
//    }


 @DeleteMapping("/delete/{id}")
   public String deleteStudent(@PathVariable UUID id){
      return studentService.deleteStudent(id);

   }

}
