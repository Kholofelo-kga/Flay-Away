package com.kholo.FlyAway.controllers;
import com.kholo.FlyAway.models.Place;
import com.kholo.FlyAway.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@Controller
public class PlaceController {
    @Autowired
    private PlaceService placeService;

    @GetMapping("/places/all")
    public String getAllPlaces(Model model) {
        List<Place> places = placeService.getAllPlaces();
        model.addAttribute("places", places);
        return "places";
    }

   

}