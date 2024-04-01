package com.example.demoApp.controller;

import com.example.demoApp.request.CreateStudentRequest;
import com.example.demoApp.request.InQueryRequest;
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

   @GetMapping("getByName/{firstName}")
    public List<StudentResponse> getByName(@PathVariable("firstName") String firstName){

      List<Student> list=  studentService.getByName(firstName);
       List<StudentResponse> response= new ArrayList<StudentResponse>();
       list.stream().forEach(student ->
               response.add(new StudentResponse(student)));
       return response;
   }

   @GetMapping("getByFirstAndLastname/{firstName}/{lastName}")
    public List<StudentResponse> getByFirstAndLastname(@PathVariable String firstName, @PathVariable String lastName){
       List<Student> list=  studentService.getByFirstNameAndLast(firstName,lastName);
       List<StudentResponse> response= new ArrayList<StudentResponse>();
       list.stream().forEach(student ->
               response.add(new StudentResponse(student)));
       return response;
   }

   @GetMapping("getByEmail/{email}")
    public List<StudentResponse> getByEmail(@PathVariable String email){
        List<Student> listOfEmails = studentService.getByEmail(email);
        List<StudentResponse> response = new ArrayList<>();
        listOfEmails.stream().forEach(e->{
            response.add(new StudentResponse(e));
        });

        return response;
   }

    @GetMapping("getByNameIn")
    public List<StudentResponse> getByNameIn(@RequestBody InQueryRequest inQueryReqest){
        List<Student> list=  studentService.getByNameIn(inQueryReqest);
        List<StudentResponse> response= new ArrayList<StudentResponse>();
        list.stream().forEach(student ->
                response.add(new StudentResponse(student)));
        return response;
    }

}
