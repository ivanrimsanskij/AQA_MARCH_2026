package org.prog.session11.dto;


import lombok.Data;

@Data
public class LocationDTo {
    private StreetDto street;
    private String city;
    private String state;
    private String country;
    private String postcode;
    private CoordinatesDto coordinates;
    private TimeZoneDto timezone;
}
