package com.Example.repository;

import com.Example.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query("SELECT b FROM Booking b " +
            "WHERE b.room.roomType = 'Deluxe' " +
            "AND b.room.pricePerNight < 4000 " +
            "AND b.checkInDate BETWEEN :startDate AND :endDate")
    List<Booking> findDeluxeBookings(
            LocalDate startDate,
            LocalDate endDate
    );
}