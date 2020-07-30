package com.codeclan.example.BookingSystem.repositories;

import com.codeclan.example.BookingSystem.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByBookingsCourseId(Long id);
    List<Customer> findByTownAndBookingsCourseIdAllIgnoreCase(String town, Long id);
    List<Customer> findByTownAndBookingsCourseIdAndAgeGreaterThanAllIgnoreCase(String town, Long id, int age);
}
