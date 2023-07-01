package com.example.UniversityEventManagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Student")
public class Student {

    @Id
    private Integer studentId;
    @Pattern(regexp ="^[A-Z][a-zA-Z]*$")
    private String firstName;
    private String lastName;
    @Min(value = 18, message = "Age should be at least 18")
    @Max(value = 25, message = "Age should not exceed 25")
    private Integer age;

    @Enumerated(EnumType.STRING)
    private Type department;

}
