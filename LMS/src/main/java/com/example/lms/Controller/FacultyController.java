package com.example.lms.Controller;

import com.example.lms.ApiResponse.ApiResponse;
import com.example.lms.Model.Faculty;
import com.example.lms.Service.FacultyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/faculty")
@RequiredArgsConstructor
public class FacultyController {

    FacultyService facultyService =new FacultyService();

    @GetMapping("/get")
    public ResponseEntity getFaculties(){
        return ResponseEntity.status(200).body(facultyService.getFaculties());
    }

    @PostMapping("/add")
    public ResponseEntity addFaculty(@RequestBody @Valid Faculty faculty, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        facultyService.addFaculty(faculty);
        return ResponseEntity.status(200).body(new ApiResponse("Faculty added"));

    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateFaculty(@PathVariable String id,@RequestBody @Valid Faculty faculty,Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        if(facultyService.updateFaculty(id,faculty)){
            return ResponseEntity.status(200).body(new ApiResponse("Faculty updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("ID not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteFaculty(@PathVariable String id){
        if(facultyService.deleteFaculty(id)){
            return ResponseEntity.status(200).body(new ApiResponse("Faculty deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("ID not found"));
    }

    @PutMapping("/promote/{id_super}/{id_sub}")
    public ResponseEntity promotion(@PathVariable String id_super ,@PathVariable String id_sub){

        if(facultyService.promotion(id_super,id_sub)){
            return ResponseEntity.status(200).body(new ApiResponse("Faculty promoted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("ID not found"));
    }

@GetMapping("/getAvgSalary")
    public ResponseEntity getAvgSalary(){
        return ResponseEntity.status(200).body(new ApiResponse("Calculates the average salary of all faculty members= "+facultyService.getAvgSalary()));
    }

    @PutMapping("/updateSalary/{id}/{percent}")
    public ResponseEntity updateSalary(@PathVariable String id,@PathVariable double percent){
      if(facultyService.updateSalary(id,percent)){
          return ResponseEntity.status(200).body(new ApiResponse("Faculty salary updated "));
      }
      return ResponseEntity.status(400).body(new ApiResponse("ID not found"));
    }



}
