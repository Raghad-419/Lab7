package com.example.lms.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Student {
    @NotEmpty(message = "Empty ID")
    @Size(min=10,max =10,message = "ID length must be 10")
    @Pattern(regexp = "^\\d{10}$",message = "ID must contain digits only")
    private String ID ;
    @NotEmpty(message = "Empty name")
    @Size(min=4,message = "Name at least 4 characters")
    @Size(max =10,message = "The name must be at most 10 characters.")
    @Pattern(regexp = "^[a-zA-Z ]{4,10}$",message = "Name must contain characters only")
    private String name;
    @NotNull(message = "Empty age")
    @Min(value = 18,message = "Age must be 18 at least")
    @Positive(message = "Age must be positive")
    private int age;
    @PositiveOrZero(message = "GPA must be Positive or zero")
    @NotNull(message = "Empty GPA")
    @Max(value = 5,message = "GPA does not exceed 5")
    private double GPA ;
    @NotNull(message = "Empty joining year")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "joining year should be Past or Present")
    private LocalDate joining_year;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Empty graduation year")
    private LocalDate graduation_year;
    @NotEmpty(message = "Empty specialization")
    @Size(min = 4,max = 20,message = "specialization must be at least 4 character and at most 20 character ")
    @Pattern(regexp = "^[a-zA-Z ]{4,20}$",message = "specialization must contain characters only")
    private String specialization;
    private boolean eligible=false;
}
