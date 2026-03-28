package com.example.controller;
import com.example.entity.Enquiry;
import com.example.repository.EnquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enquiry")

public class EnquiryController {

    @Autowired
    private EnquiryRepository enquiryRepository;

    @PostMapping
    public Enquiry saveEnquiry(@RequestBody Enquiry enquiry) {
        return enquiryRepository.save(enquiry);
    }
}
