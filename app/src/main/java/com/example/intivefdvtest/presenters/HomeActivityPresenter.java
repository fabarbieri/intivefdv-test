package com.example.intivefdvtest.presenters;

import android.util.Log;
import com.example.intivefdvtest.dtos.Result;
import com.example.intivefdvtest.models.ContactsModel;
import com.example.intivefdvtest.views.HomeActivityView;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by fbarbieri on 2019-06-06.
 */
public class HomeActivityPresenter {

    private HomeActivityView mView;
    private static final String REQUEST_ERROR = "Request error";
    private static final String FIRST_PAGE = "1";

    public HomeActivityPresenter(final HomeActivityView view) {
        mView = view;
    }

    public void getContactData(final String page) {

        if (FIRST_PAGE.equals(page)) {
            mView.showProgressBar();
        }

        final Observable<Result> observable = ContactsModel.getInstance().getContactsData(page);
        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(new Subscriber<Result>() {
                @Override
                public void onCompleted() {
                    //Nothing to do
                }

                @Override
                public void onError(final Throwable e) {

                    mView.hideProgressBar();
                    mView.showRetryView();

                    Log.e(REQUEST_ERROR, e.getMessage());
                }

                @Override
                public void onNext(final Result result) {
                    if (result == null) {
                        mView.hideProgressBar();
                        mView.showRetryView();
                    } else {
                        mView.showContactsData(result.getResults());
                    }
                }
            });
    }
}
