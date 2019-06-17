package com.example.demo.venues;


import com.example.demo.domain.model.BurgerPhoto;
import com.example.demo.domain.model.CityType;
import com.example.demo.venues.form.VenueFormType;
import com.example.foursquareapi.model.venue.Venue;
import com.example.demo.ControllerIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class VenueControllerIntegrationTest extends ControllerIntegrationTest {

    @Test
    void getVenues() throws Exception {
        this.mockMvc.perform(
                get("/venues")
        )
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("venues"))
                .andExpect(model().attribute("venues", notNullValue()))
                .andExpect(model().attribute("venues", instanceOf(List.class)))
                .andExpect(model().attribute("venues", hasSize(greaterThan(1))))
                .andExpect(model().attributeExists("cities"))
                .andExpect(model().attribute("cities", notNullValue()))
                .andExpect(model().attribute("cities", instanceOf(CityType[].class)))
                .andExpect(model().attributeExists("cityForm"))
                .andExpect(model().attribute("cityForm", instanceOf(VenueFormType.class)))
                .andExpect(model().attribute("cityForm", notNullValue()))
                .andExpect(view().name("venues/index"));
    }

    @Test
    void filterVenuesByCity() throws Exception {
        this.mockMvc.perform(
                post("/venues/city")
                        .param("cityName", "TALLINN")
        )
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("venues"))
                .andExpect(model().attribute("venues", notNullValue()))
                .andExpect(model().attribute("venues", instanceOf(List.class)))
                .andExpect(model().attribute("venues", hasSize(greaterThan(1))))
                .andExpect(model().attributeExists("cities"))
                .andExpect(model().attribute("cities", notNullValue()))
                .andExpect(model().attribute("cities", instanceOf(CityType[].class)))
                .andExpect(model().attributeExists("cityForm"))
                .andExpect(model().attribute("cityForm", instanceOf(VenueFormType.class)))
                .andExpect(model().attribute("cityForm", notNullValue()))
                .andExpect(view().name("venues/index"));
    }

    @Test
    void getVenueById() throws Exception {
        MvcResult venuesResult = this.mockMvc.perform(
                get("/venues")
        ).andReturn();

        Map<String, Object> model = venuesResult.getModelAndView().getModel();
        List<Venue> venues = (List) model.get("venues");

        Venue venue = venues.get(0);

        this.mockMvc.perform(
                get("/venues/" + venue.getId())
        )
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("venue"))
                .andExpect(model().attribute("venue", notNullValue()))
                .andExpect(model().attribute("venue", instanceOf(Venue.class)))
                .andExpect(model().attributeExists("photo"))
                .andExpect(model().attribute("photo", notNullValue()))
                .andExpect(model().attribute("photo", instanceOf(BurgerPhoto.class)))
                .andExpect(view().name("venues/venueDetails"));
    }
}