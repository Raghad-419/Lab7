package com.example.lms.Controller;

import com.example.lms.ApiResponse.ApiResponse;
import com.example.lms.Model.Administrator;
import com.example.lms.Service.AdministratorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/administrator")
@RequiredArgsConstructor
public class AdministratorController {

    AdministratorService administratorService =new AdministratorService();

    @GetMapping("/get")
    public ResponseEntity getAdministrator(){
        return ResponseEntity.status(200).body(administratorService.getAdministrators());
    }

    @PostMapping("/add")
    public ResponseEntity addAdministrator(@RequestBody @Valid Administrator administrator, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        administratorService.addAdministrator(administrator);
        return ResponseEntity.status(200).body(new ApiResponse("Administrator added"));
    }

    @PutMapping("/update/{id}")
public ResponseEntity updateAdministrator(@PathVariable String id,@RequestBody @Valid Administrator administrator, Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        if(administratorService.updateAdministrator(id,administrator)){
            return ResponseEntity.status(200).body(new ApiResponse("Administrator updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("ID not found"));
}

@DeleteMapping("/delete/{id}")
public ResponseEntity deleteAdministrator(@PathVariable String id){
        if(administratorService.deleteAdministrator(id)){
            return ResponseEntity.status(200).body(new ApiResponse("Administrator deleted"));
        }
    return ResponseEntity.status(400).body(new ApiResponse("ID not found"));

}

@PutMapping("/Deactivate/{id}")
public ResponseEntity deactivate(@PathVariable String id){
        if(administratorService.Deactivate(id)){
            return ResponseEntity.status(200).body(new ApiResponse("Administrator Deactivated"));
        }
    return ResponseEntity.status(400).body(new ApiResponse("ID not found"));
}

@GetMapping("/get-hiredAfter")
public ResponseEntity hiredAfter(@RequestBody @Valid LocalDate localDate,Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        if(administratorService.hiredAfter(localDate)==null){
            return ResponseEntity.status(400).body(new ApiResponse("No Administrator hired after "+localDate));
        }
        return ResponseEntity.status(200).body(administratorService.hiredAfter(localDate));
}

@GetMapping("/yearsOfService/{id}")
public ResponseEntity yearsOfService(@PathVariable String id){
        if(administratorService.yearsOfService(id)==0){
            return ResponseEntity.status(400).body(new ApiResponse("ID not found"));
        }
        return ResponseEntity.status(200).body(new ApiResponse("Years of Service: "+administratorService.yearsOfService(id)));
}


}

