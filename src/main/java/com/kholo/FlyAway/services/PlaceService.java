package com.kholo.FlyAway.services;
import com.kholo.FlyAway.models.Place;
import com.kholo.FlyAway.repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceService {

    private final PlaceRepository placeRepository;

    @Autowired
    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    // Get all places
    public List<Place> getAllPlaces() {
        return placeRepository.findAll();
    }

    // Get place by ID
    public Optional<Place> getPlaceById(Long placeId) {
        return placeRepository.findById(placeId);
    }

    // Add a new place
    public Place addPlace(Place place) {
        return placeRepository.save(place);
    }

    // Update an existing place
    public Place updatePlace(Long placeId, Place updatedPlace) {
        // Check if the place with the given ID exists
        Optional<Place> existingPlace = placeRepository.findById(placeId);

        if (existingPlace.isPresent()) {
            // Update the existing place with the new information
            updatedPlace.setPlaceId(placeId);
            return placeRepository.save(updatedPlace);
        } else {
            // Handle the case where the place with the given ID is not found
            throw new IllegalArgumentException("Place with ID " + placeId + " not found.");
        }
    }

    // Delete a place by ID
    public void deletePlace(Long placeId) {
        // Check if the place with the given ID exists
        Optional<Place> existingPlace = placeRepository.findById(placeId);

        if (existingPlace.isPresent()) {
            // Delete the existing place
            placeRepository.deleteById(placeId);
        } else {
            // Handle the case where the place with the given ID is not found
            throw new IllegalArgumentException("Place with ID " + placeId + " not found.");
        }
    }
}
