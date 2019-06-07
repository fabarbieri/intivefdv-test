package com.example.intivefdvtest.dtos;

import java.io.Serializable;

/**
 * Created by fbarbieri on 2019-06-05.
 */
public class Location implements Serializable {

    private final String street;
    private final String city;
    private final String state;
    private final String postcode;
    private final Coordinates coordinates;
    private final Timezone timezone;

    /**
     * @param street the address street
     * @param city the address city
     * @param state the address state
     * @param postcode the address postcode
     * @param coordinates the address coordinates
     * @param timezone the contact timezone
     */
    public Location(final String street, final String city, final String state, final String postcode,
        final Coordinates coordinates, final Timezone timezone) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.postcode = postcode;
        this.coordinates = coordinates;
        this.timezone = timezone;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostcode() {
        return postcode;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Timezone getTimezone() {
        return timezone;
    }
}
