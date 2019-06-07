package com.example.intivefdvtest.servicies;

import com.example.intivefdvtest.dtos.Result;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by fbarbieri on 23/01/2019.
 */
public interface ContactsService {

    String URL_CONTACTS = "api/?results=50";

    /**
     * @return the contacts list
     */
    @GET(URL_CONTACTS)
    Observable<Result> getContactsData(@Query("page") String page);
}