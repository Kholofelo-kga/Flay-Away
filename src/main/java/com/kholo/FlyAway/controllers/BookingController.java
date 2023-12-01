package com.kholo.FlyAway.controllers;
import com.kholo.FlyAway.models.Booking;
import com.kholo.FlyAway.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@Controller
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping("/bookings/all")
    public String getAllBookings(Model model) {
        List<Booking> bookings = bookingService.getAllBookings();
        model.addAttribute("bookings", bookings);
        return "bookings";
    }


}