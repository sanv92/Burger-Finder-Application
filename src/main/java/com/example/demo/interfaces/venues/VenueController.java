package com.example.demo.interfaces.venues;

import com.example.demo.domain.model.CityType;
import com.example.demo.application.VenuePhotoService;
import com.example.demo.application.VenueService;
import com.example.demo.interfaces.venues.form.VenueFormType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/venues")
@Controller
public class VenueController {

    private final VenueService venueService;

    private final VenuePhotoService venuePhotoService;

    @Autowired
    public VenueController(
            VenueService venueService,
            VenuePhotoService venuePhotoService
    ) {
        this.venueService = venueService;
        this.venuePhotoService = venuePhotoService;
    }

    @RequestMapping({"", "/", "index", "index.html"})
    public String getVenues(Model model) {
        model.addAttribute("venues", venueService.getAllByCity(
                CityType.TARTU.getName()
        ));
        model.addAttribute("cities", CityType.values());
        model.addAttribute("cityForm", new VenueFormType(
                CityType.TARTU
        ));

        return "venues/index";
    }

    @PostMapping({"/city"})
    public String filterVenuesByCity(@ModelAttribute("cityForm") VenueFormType venueCityForm, Model model) {
        model.addAttribute("venues", venueService.getAllByCity(
                venueCityForm.getCityName().getName()
        ));
        model.addAttribute("cities", CityType.values());

        return "venues/index";
    }

    @GetMapping({"/{venueId}"})
    public String getVenueById(@PathVariable("venueId") String venueId, Model model) {
        model.addAttribute("venue", venueService.getById(venueId));
        model.addAttribute("photo", venuePhotoService.getLastPhoto(venueId));

        return "venues/venueDetails";
    }
}
