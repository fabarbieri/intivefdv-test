package com.example.intivefdvtest.views;

import com.example.intivefdvtest.dtos.Contact;
import java.util.ArrayList;

/**
 * Created by fbarbieri on 2019-06-06.
 */
public interface HomeActivityView {

    void showContactsData(ArrayList<Contact> contacts);

    void showProgressBar();

    void hideProgressBar();

    void showRetryView();
}
