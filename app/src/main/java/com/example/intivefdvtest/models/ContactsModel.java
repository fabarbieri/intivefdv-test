package com.example.intivefdvtest.models;

import com.example.intivefdvtest.dtos.Result;
import com.example.intivefdvtest.servicies.ContactsService;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

public class ContactsModel {

    private static final ContactsModel INSTANCE = new ContactsModel();

    public static final String BASE_URL = "https://randomuser.me/";

    /**
     * Factory method
     *
     * @return the model's singleton
     */
    public static ContactsModel getInstance() {
        return INSTANCE;
    }

    private ContactsService getService() {

        final Retrofit.Builder retrofitBuilder = new Retrofit.Builder().baseUrl(BASE_URL);
        retrofitBuilder.addConverterFactory(GsonConverterFactory.create());
        retrofitBuilder.addCallAdapterFactory(RxJavaCallAdapterFactory.create());
        return retrofitBuilder.build().create(ContactsService.class);
    }

    /**
     * Call the endpoint to retrieve the contacts list
     *
     * @return the response containing the contacts
     */
    public Observable<Result> getContactsData(final String page) {
        return getService().getContactsData(page);
    }
}
