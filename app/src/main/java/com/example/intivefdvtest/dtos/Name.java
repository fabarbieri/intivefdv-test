package com.example.intivefdvtest.dtos;

import java.io.Serializable;

/**
 * Created by fbarbieri on 2019-06-05.
 */
public class Name implements Serializable {

    private final String title;
    private final String first;
    private final String last;

    /**
     * @param title the contact title
     * @param first the contact first name
     * @param last the contact last name
     */
    public Name(final String title, final String first, final String last) {
        this.title = title;
        this.first = first;
        this.last = last;
    }

    public String getTitle() {
        return title;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }
}
