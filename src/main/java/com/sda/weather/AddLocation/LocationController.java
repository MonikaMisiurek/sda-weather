package com.sda.weather.AddLocation;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LocationController {


    private final ObjectMapper objectMapper;
    private final LocationService locationService;


    public LocationController(ObjectMapper objectMapper, LocationService locationService ) {
        this.objectMapper = objectMapper;
        this.locationService = locationService;
    }
}
