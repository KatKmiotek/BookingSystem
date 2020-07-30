package com.codeclan.example.BookingSystem.components;

import com.codeclan.example.BookingSystem.models.Booking;
import com.codeclan.example.BookingSystem.models.Course;
import com.codeclan.example.BookingSystem.models.Customer;
import com.codeclan.example.BookingSystem.repositories.BookingRepository;
import com.codeclan.example.BookingSystem.repositories.CourseRepository;
import com.codeclan.example.BookingSystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    CourseRepository courseRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Course course1 = new Course("Intro to Python", "Glasgow", 5);
        Course course2 = new Course("Advanced Python", "Edinburgh", 7);
        courseRepository.save(course1);
        courseRepository.save(course2);
        Customer customer1 = new Customer("Nikita", "Glasgow", 23);
        Customer customer2 = new Customer("Kat", "Glasgow", 33);
        Customer customer3 = new Customer("Tom", "Glasgow", 35);
        Customer customer4 = new Customer("Alan", "Glasgow", 35);
        Customer customer5 = new Customer("Josh", "Brisbane", 26);
        Customer customer6 = new Customer("Gosia", "Krakow", 31);
        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);
        customerRepository.save(customer4);
        customerRepository.save(customer5);
        customerRepository.save(customer6);
        Booking booking1 = new Booking("30-08-20", course1, customer2);
        Booking booking2 = new Booking("30-09-20", course2, customer1);
        Booking booking3 = new Booking("30-10-20", course2, customer2);
        Booking booking4 = new Booking("30-07-20", course1, customer1);
        bookingRepository.save(booking1);
        bookingRepository.save(booking2);
        bookingRepository.save(booking3);
        bookingRepository.save(booking4);


    }
}
