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
//    @Query(value = "SELECT * FROM customers(day,-1,pxd_upd_date)," +
//            "pbd_prod_code," +
//            "psd_stk_qty+psd_booked_qty, " +
//            "IFNULL(CONCAT(CONCAT(TRIM(TRAILING ' ' FROM P.course_name)," +
//            "CASE LENGTH(CONVERT(VARCHAR(6), P.customer_booking_id))" +
//            "WHEN '5' THEN" +
//            "CASE" +
//            "WHEN CONVERT(SQL_INTEGER,SUBSTRING(CONVERT(VARCHAR(6),P.customer_booking_id),3)) <= 700" +
//            "THEN" +
//            "(SELECT TRIM(TRAILING ' ' FROM A.aca_cu_name)" +
//            "FROM admin.sffaca_details A" +
//            "WHERE A.aca_cu_no=CONCAT('PTX0', SUBSTRING(CONVERT(VARCHAR(6), P.customer),1,2))" +
//            "AND A.aca_addr_no=CONVERT(SQL_INTEGER,SUBSTRING(CONVERT(VARCHAR(6), P.customer_booking_id),3)))" +
//            "ELSE" +
//            "(SELECT TRIM(TRAILING ' ' FROM aca_txt_l1))";"FROM booking.id_other C WHERE C.aca_cu_no=CONCAT('PTX0', SUBSTRING(CONVERT(VARCHAR(6), P.booking),1,2))", nativeQuery = true)
//    List<Course> foundShoe(String date);
}
