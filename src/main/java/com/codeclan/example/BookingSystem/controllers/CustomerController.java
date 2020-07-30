package com.codeclan.example.BookingSystem.controllers;

import com.codeclan.example.BookingSystem.models.Customer;
import com.codeclan.example.BookingSystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;
    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(
            @RequestParam(name = "courseId", required = false) Long courseId,
            @RequestParam(name = "town", required = false) String town,
            @RequestParam(name="age", required = false) Integer age
    ){
        if( age != null && town != null && courseId != null){
            return new ResponseEntity<>(customerRepository.findByTownAndBookingsCourseIdAndAgeGreaterThanAllIgnoreCase(town, courseId, age), HttpStatus.OK);
        }
        if(town != null && courseId != null){
            return new ResponseEntity<>(customerRepository.findByTownAndBookingsCourseIdAllIgnoreCase(town, courseId), HttpStatus.OK);
        }
        if(courseId != null){
            return new ResponseEntity<>(customerRepository.findByBookingsCourseId(courseId), HttpStatus.OK);
        }
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }
}
