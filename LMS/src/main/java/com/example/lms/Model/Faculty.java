package com.example.lms.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Faculty {
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
    @Pattern(regexp = "^05\\d{8}",message = "Phone number should start with 05 and contain 10 digits")
    @Size(min = 10,max = 10,message = "Phone number should be 10 digits")
    @NotEmpty(message = "Empty phone number")
    private String phoneNumber;
    @NotNull(message = "Empty salary")
    @Positive(message = "Salary should be positive")
    @Min(value = 2001,message = "Salary should be more than 2000 ")
    private double salary ;
    @NotEmpty(message = "Empty department")
    @Size(min=5,max = 12,message = "Department length at least 5 characters and at most 12 characters ")
    @Pattern(regexp = "^[a-zA-Z ]{5,12}",message = "Department must contain characters only")
    private String department ;
    @NotNull(message = "Empty classes")
    @Min(value = 3,message = "Faculty should have at least 3 classes")
    @Max(value = 5,message = "Faculty should have at most 5 classes")
    private int numOfClasses;
    @Pattern(regexp="Male|Female",message = "Gender must be Male or Female")
    @NotEmpty(message = "Empty gender")
    private String gender;
    @NotEmpty(message = "Empty nationality")
    @Pattern(regexp = "^[a-zA-Z ]{4,10}",message = "Nationality must contain characters only")
    private String nationality ;
    @NotEmpty(message = "Empty position")
    @Pattern(regexp = "Professor|Lecturer|Assistant",message = "Position must be  Professor, Lecturer,or Assistant ")
    private String position;
}
