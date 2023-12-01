package com.kholo.FlyAway.services;
import com.kholo.FlyAway.models.Flight;
import com.kholo.FlyAway.models.Place;
import com.kholo.FlyAway.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }
    // Get all flights
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }
    // Get flight by ID
    public Optional<Flight> getFlightById(Long flightId) {
        return flightRepository.findById(flightId);
    }
    // Get flights by source and destination
    public List<Flight> getFlightsBySourceAndDestination(Place source, Place destination) {
        return flightRepository.findBySourceAndDestination(source, destination);
    }
    // Add a new flight
    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }
    // Update an existing flight
    public Flight updateFlight(Long flightId, Flight updatedFlight) {
        // Check if the flight with the given ID exists
        Optional<Flight> existingFlight = flightRepository.findById(flightId);

        if (existingFlight.isPresent()) {
            // Update the existing flight with the new information
            updatedFlight.setFlightId(flightId);
            return flightRepository.save(updatedFlight);
        } else {
            // Handle the case where the flight with the given ID is not found
            throw new IllegalArgumentException("Flight with ID " + flightId + " not found.");
        }
    }
    // Delete a flight by ID
    public void deleteFlight(Long flightId) {
        // Check if the flight with the given ID exists
        Optional<Flight> existingFlight = flightRepository.findById(flightId);

        if (existingFlight.isPresent()) {
            // Delete the existing flight
            flightRepository.deleteById(flightId);
        } else {
            // Handle the case where the flight with the given ID is not found
            throw new IllegalArgumentException("Flight with ID " + flightId + " not found.");
        }
    }
}
