package com.example.entity;

import java.time.LocalDate;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "student")
@Data
public class Student {

	 @Id
	    @GeneratedValue(generator = "student-id-gen")
	    @GenericGenerator(
	        name = "student-id-gen",
	        strategy = "com.example.generator.StudentIdGenerator"
    )
    private Long id;

    @Column(nullable = false)
    private String studentName;

    private LocalDate dob;
    private String gender;

    @Column(name = "student_class")
    private String studentClass;

    @Column(nullable = false)
    private String password;

    @Column(unique = true)
    private String email;

    @Column(unique = true, length = 10)
    private String phoneNo;

    private String address;

    @Column(unique = true, length = 12)
    private String aadharNo;

    private String fatherName;
    private String motherName;

}
