package com.kholo.FlyAway.controllers;
import com.kholo.FlyAway.models.Flight;
import com.kholo.FlyAway.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@Controller
public class FlightController {
    @Autowired
    private FlightService flightService;

    @GetMapping("/flights/all")
    public String getAllFlights(Model model) {
        List<Flight> flights = flightService.getAllFlights();
        model.addAttribute("flights", flights);
        return "flights";
    }