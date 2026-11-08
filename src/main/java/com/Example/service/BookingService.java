package com.Example.service;

import com.Example.entity.Booking;
import com.Example.entity.Room;
import com.Example.repository.BookingRepository;
import com.Example.repository.RoomRepository;

import java.time.LocalDate;
import java.util.List;

@org.springframework.stereotype.Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;

    public BookingService(
            BookingRepository bookingRepository,
            RoomRepository roomRepository) {

        this.bookingRepository = bookingRepository;
        this.roomRepository = roomRepository;
    }

    // CREATE
    public Booking createBooking(Booking booking, Long roomId) {

        Room room = roomRepository.findById(roomId)
                .orElseThrow(() ->
                        new RuntimeException("Room not found"));

        booking.setRoom(room);

        return bookingRepository.save(booking);
    }

    // READ
    public Booking getBooking(Long id) {

        return bookingRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Booking not found"));
    }

    // GET ALL BOOKINGS
    public List<Booking> getAllBookings() {

        return bookingRepository.findAll();
    }

    // UPDATE
    public Booking updateBooking(Long id, Booking newBooking) {

        Booking oldBooking = getBooking(id);

        oldBooking.setGuestName(newBooking.getGuestName());
        oldBooking.setCheckInDate(newBooking.getCheckInDate());
        oldBooking.setCheckOutDate(newBooking.getCheckOutDate());

        return bookingRepository.save(oldBooking);
    }

    // DELETE
    public String deleteBooking(Long id) {

        Booking booking = getBooking(id);

        bookingRepository.delete(booking);

        return "Booking deleted successfully";
    }

    // CONDITIONAL SELECT
    public List<Booking> getDeluxeBookings() {

        return bookingRepository.findDeluxeBookings(
                LocalDate.of(2026, 11, 1),
                LocalDate.of(2026, 11, 30)
        );
    }
}