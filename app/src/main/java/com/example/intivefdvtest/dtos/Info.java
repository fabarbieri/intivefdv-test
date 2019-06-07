package com.example.intivefdvtest.dtos;

import java.io.Serializable;

/**
 * Created by fbarbieri on 2019-06-05.
 */
public class Info implements Serializable {

    private final String seed;
    private final int results;
    private final int page;
    private final String version;

    /**
     * @param seed the seed
     * @param results the results quantity
     * @param page the page
     * @param version the version
     */
    public Info(final String seed, final int results, final int page, final String version) {
        this.seed = seed;
        this.results = results;
        this.page = page;
        this.version = version;
    }

    public String getSeed() {
        return seed;
    }

    public int getResults() {
        return results;
    }

    public int getPage() {
        return page;
    }

    public String getVersion() {
        return version;
    }
}
