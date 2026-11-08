package com.Example.controller;

import com.Example.entity.Booking;
import com.Example.service.BookingService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    // CREATE BOOKING
    @PostMapping("/{roomId}")
    public Booking createBooking(
            @PathVariable Long roomId,
            @RequestBody Booking booking) {

        return bookingService.createBooking(booking, roomId);
    }

    // READ BOOKING BY ID
    @GetMapping("/{id}")
    public Booking getBooking(@PathVariable Long id) {

        return bookingService.getBooking(id);
    }

    // GET ALL BOOKINGS
    @GetMapping
    public List<Booking> getAllBookings() {

        return bookingService.getAllBookings();
    }

    // UPDATE BOOKING
    @PutMapping("/{id}")
    public Booking updateBooking(
            @PathVariable Long id,
            @RequestBody Booking booking) {

        return bookingService.updateBooking(id, booking);
    }

    // DELETE BOOKING
    @DeleteMapping("/{id}")
    public String deleteBooking(@PathVariable Long id) {

        return bookingService.deleteBooking(id);
    }

    // CONDITIONAL SELECT
    @GetMapping("/deluxe")
    public List<Booking> getDeluxeBookings() {

        return bookingService.getDeluxeBookings();
    }
}