package com.codeclan.example.BookingSystem.repositories;

import com.codeclan.example.BookingSystem.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByBookingsCourseId(Long id);
    List<Customer> findByTownAndBookingsCourseIdAllIgnoreCase(String town, Long id);
    List<Customer> findByTownAndBookingsCourseIdAndAgeGreaterThanAllIgnoreCase(String town, Long id, int age);
    List<Customer> findAllByOrderByNameAsc();
    List<Customer> findByNameLikeAllIgnoreCase(String name);
    List<Customer> findByNameStartingWithAllIgnoreCase(String name);
    @Query(value = "SELECT * FROM customers WHERE id = ?1", nativeQuery = true)
    List<Customer> foundCustomer(Long id);
}
