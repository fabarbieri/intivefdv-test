package com.example.intivefdvtest.dtos;

import java.io.Serializable;

/**
 * Created by fbarbieri on 2019-06-05.
 */
public class Coordinates implements Serializable {

    private final String latitude;
    private final String longitude;

    /**
     * @param latitude the latitude
     * @param longitude the longitude
     */
    public Coordinates(final String latitude, final String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }
}
