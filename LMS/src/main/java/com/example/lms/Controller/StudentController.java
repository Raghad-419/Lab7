package com.example.lms.Controller;

import com.example.lms.ApiResponse.ApiResponse;
import com.example.lms.Model.Student;
import com.example.lms.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    StudentService studentService =new StudentService();


    @GetMapping("/get")
    public ResponseEntity getStudents(){
        return ResponseEntity.status(200).body(studentService.getStudents());
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody @Valid Student student, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new ApiResponse("Student added"));


    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable String id,@RequestBody Student student,Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        if(studentService.updateStudent(id,student)){
            return ResponseEntity.status(200).body(new ApiResponse("Student updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("ID not found"));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable String id){
        if(studentService.deleteStudent(id)){
            return ResponseEntity.status(200).body(new ApiResponse("Student deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("ID not found"));
    }

    @GetMapping("/getGpa")
public ResponseEntity getGpa(){
      return ResponseEntity.status(200).body(studentService.getGpa());
}

@GetMapping("/calculate")
public ResponseEntity calculateAvg(){
        return ResponseEntity.status(200).body(new ApiResponse("Average of all GPA = "+studentService.calculateAvg()));
}

@PutMapping("/isEligible/{id}")
public ResponseEntity isEligible(@PathVariable String id){
        if(studentService.isEligible(id)){
            return ResponseEntity.status(200).body(new ApiResponse("Student Eligible for a scholarship"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Student Not Eligible"));
}



}
