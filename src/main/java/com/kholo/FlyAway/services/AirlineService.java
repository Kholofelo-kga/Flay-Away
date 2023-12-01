package com.kholo.FlyAway.services;
import com.kholo.FlyAway.models.Airline;
import com.kholo.FlyAway.repositories.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirlineService {

    private final AirlineRepository airlineRepository;

    @Autowired
    public AirlineService(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }

    // Get all airlines
    public List<Airline> getAllAirlines() {
        return airlineRepository.findAll();
    }

    // Get airline by ID
    public Optional<Airline> getAirlineById(Long airlineId) {
        return airlineRepository.findById(airlineId);
    }

    // Add a new airline
    public Airline addAirline(Airline airline) {
        return airlineRepository.save(airline);
    }

    // Update an existing airline
    public Airline updateAirline(Long airlineId, Airline updatedAirline) {
        // Check if the airline with the given ID exists
        Optional<Airline> existingAirline = airlineRepository.findById(airlineId);

        if (existingAirline.isPresent()) {
            // Update the existing airline with the new information
            updatedAirline.setAirlineId(airlineId);
            return airlineRepository.save(updatedAirline);
        } else {
            // Handle the case where the airline with the given ID is not found
            throw new IllegalArgumentException("Airline with ID " + airlineId + " not found.");
        }
    }

    // Delete an airline by ID
    public void deleteAirline(Long airlineId) {
        // Check if the airline with the given ID exists
        Optional<Airline> existingAirline = airlineRepository.findById(airlineId);

        if (existingAirline.isPresent()) {
            // Delete the existing airline
            airlineRepository.deleteById(airlineId);
        } else {
            // Handle the case where the airline with the given ID is not found
            throw new IllegalArgumentException("Airline with ID " + airlineId + " not found.");
        }
    }
}
