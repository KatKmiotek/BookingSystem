package com.codeclan.example.BookingSystem.repositories;

import com.codeclan.example.BookingSystem.models.Course;
import com.codeclan.example.BookingSystem.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByStarRating(int starRating);
    List<Course> findByBookingsCustomerId(Long id);
    @Query(value = "SELECT * FROM courses INNER JOIN bookings ON courses.id = bookings.course_id WHERE bookings.date = ?1 ORDER BY courses.name DESC", nativeQuery = true)
    List<Course> foundCourses(String date);
}
