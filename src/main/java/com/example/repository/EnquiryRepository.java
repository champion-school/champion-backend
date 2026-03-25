package com.example.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import com.example.entity.Enquiry;

public interface EnquiryRepository extends JpaRepository<Enquiry, Long> {
}