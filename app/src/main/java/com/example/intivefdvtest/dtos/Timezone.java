package com.example.intivefdvtest.dtos;

import java.io.Serializable;

/**
 * Created by fbarbieri on 2019-06-05.
 */
public class Timezone implements Serializable {

    private final String offset;
    private final String description;

    /**
     * @param offset the offset
     * @param description the description
     */
    public Timezone(final String offset, final String description) {
        this.offset = offset;
        this.description = description;
    }

    public String getOffset() {
        return offset;
    }

    public String getDescription() {
        return description;
    }
}
