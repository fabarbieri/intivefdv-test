package com.example.intivefdvtest.dtos;

import java.io.Serializable;

/**
 * Created by fbarbieri on 2019-06-05.
 */
public class Registered implements Serializable {

    private final String date;
    private final int age;

    /**
     * @param date the date
     * @param age the age
     */
    public Registered(final String date, final int age) {
        this.date = date;
        this.age = age;
    }

    public String getDate() {
        return date;
    }

    public int getAge() {
        return age;
    }
}
