package com.example.intivefdvtest.dtos;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by fbarbieri on 2019-06-05.
 */
public class Result implements Serializable {

    private final ArrayList<Contact> results;
    private final Info info;

    /**
     * @param results the contacts results
     * @param info the info
     */
    public Result(final ArrayList<Contact> results, final Info info) {
        this.results = results;
        this.info = info;
    }

    public ArrayList<Contact> getResults() {
        return results;
    }

    public Info getInfo() {
        return info;
    }
}
