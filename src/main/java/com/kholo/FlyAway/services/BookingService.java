package com.kholo.FlyAway.services;
import com.kholo.FlyAway.models.Booking;
import com.kholo.FlyAway.models.User;
import com.kholo.FlyAway.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    // Get all bookings
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // Get booking by ID
    public Optional<Booking> getBookingById(Long bookingId) {
        return bookingRepository.findById(bookingId);
    }

    // Get bookings by user
    public List<Booking> getBookingsByUser(User user) {
        return bookingRepository.findByUser(user);
    }

    // Add a new booking
    public Booking addBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    // Update an existing booking
    public Booking updateBooking(Long bookingId, Booking updatedBooking) {
        // Check if the booking with the given ID exists
        Optional<Booking> existingBooking = bookingRepository.findById(bookingId);

        if (existingBooking.isPresent()) {
            // Update the existing booking with the new information
            updatedBooking.setBookingId(bookingId);
            return bookingRepository.save(updatedBooking);
        } else {
            // Handle the case where the booking with the given ID is not found
            throw new IllegalArgumentException("Booking with ID " + bookingId + " not found.");
        }
    }

    // Delete a booking by ID
    public void deleteBooking(Long bookingId) {
        // Check if the booking with the given ID exists
        Optional<Booking> existingBooking = bookingRepository.findById(bookingId);

        if (existingBooking.isPresent()) {
            // Delete the existing booking
            bookingRepository.deleteById(bookingId);
        } else {
            // Handle the case where the booking with the given ID is not found
            throw new IllegalArgumentException("Booking with ID " + bookingId + " not found.");
        }
    }
}
