package com.example.intivefdvtest.dtos;

import java.io.Serializable;

/**
 * Created by fbarbieri on 2019-06-05.
 */
public class Picture implements Serializable {

    private final String large;
    private final String medium;
    private final String thumbnail;

    /**
     * @param large the large picture
     * @param medium the medium picture
     * @param thumbnail the thumbnail
     */
    public Picture(final String large, final String medium, final String thumbnail) {
        this.large = large;
        this.medium = medium;
        this.thumbnail = thumbnail;
    }

    public String getLarge() {
        return large;
    }

    public String getMedium() {
        return medium;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}
