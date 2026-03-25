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
@Table(name = "staff")
@Data
public class Staff {

	@Id
    @GeneratedValue(generator = "staff-id-gen")
    @GenericGenerator(
        name = "staff-id-gen",
        strategy = "com.example.generator.StaffIdGenerator"
    )
    private Long id;

    @Column(nullable = false)
    private String staffName;

    private LocalDate dob;
    private String gender;

    @Column(name = "staff_class")
    private String staffClass;

    @Column(nullable = false)
    private String password;

    @Column(unique = true)
    private String email;

    @Column(unique = true, length = 10)
    private String phoneNo;

    private String address;

    @Column(unique = true, length = 12)
    private String aadharNo;
    
    @Column(nullable = false)
    private Double salary;


}