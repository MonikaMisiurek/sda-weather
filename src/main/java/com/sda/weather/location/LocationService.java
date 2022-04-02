package com.sda.weather.location;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class LocationService {

    private final LocationRepository locationRepository;
    private final ObjectMapper objectMapper;

    public LocationService(LocationRepository locationRepository, ObjectMapper objectMapper) {
        this.locationRepository = locationRepository;
        this.objectMapper = objectMapper;
    }

    Location cerateLocation(String city, Long longitude, Long latitude, String region, String country) {
        if (city == null || city.isBlank()) {
            throw new IllegalArgumentException("Podaj prawidłową nazwę miasta.");
        }
        if (country == null || country.isBlank()) {
            throw new IllegalArgumentException("Podaj prawidłową nazwę kraju.");
        }
        if (longitude < -180 || longitude > 180) {
            throw new IllegalArgumentException("Podaj prawidłową długość geograficzną.");
        }
        if (latitude < -90 || latitude > 90) {
            throw new IllegalArgumentException("Podaj prawidłową szerość geograficzną.");
        }

        Location location = new Location(city, longitude, latitude, region, country);


        //http
//        HttpClient httpClient = HttpClient.newHttpClient();
//        HttpRequest httpRequest = HttpRequest.newBuilder()
//                .GET()
//                .uri(URI.create(""))
//                .build();
        //

        Location savedLocation = locationRepository.save(location);
        return savedLocation;
    }
}
