package com.example.lms.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Administrator {

    @NotEmpty(message = "Empty ID")
    @Pattern(regexp = "^\\d{10}$",message = "ID must contain digits only")
    @Size(min = 10,max = 10,message ="ID must contain 10 digits" )
    private String ID ;
    @NotEmpty(message = "Empty name")
    @Size(min = 4,max=10,message = "Name length at least 4 characters and at most 10 characters")
    @Pattern(regexp = "^[a-zA-Z]{4,10}",message = "Name must contain characters only")
    private String name ;
    @NotNull(message = "Empty age")
    @Positive(message = "Age must be Positive")
    @Min(value = 30,message = "Age should be at least 30 years")
    private int age;
    @NotEmpty(message = "Empty email")
    @Email(message = "Enter Valid email")
    private String email;
    @NotEmpty(message = "Empty Department")
    @Pattern(regexp = "HR|IT|Finance",message = "Department must be HR, IT, or Finance ")
    private String department;
    @NotEmpty(message = "Empty position")
    @Pattern(regexp = "Office Manager|System Administrator",message = "Position must be Office Manager,or System Administrator")
    private String position;
    @NotNull(message = "Empty hire Date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate hireDate;
    @NotNull(message = "is Active Empty")
    private boolean isActive;
}
