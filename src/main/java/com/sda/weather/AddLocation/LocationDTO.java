package com.sda.weather.AddLocation;

import lombok.Data;

@Data
public class LocationDTO {
    private Long id;
    private String city;
    private Long longitude;
    private Long latitude;
    private String region;
    private String country;
}
