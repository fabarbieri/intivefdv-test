package com.example.intivefdvtest.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.example.intivefdvtest.R;
import com.example.intivefdvtest.adapters.GridDataAdapter;
import com.example.intivefdvtest.dtos.Contact;
import com.example.intivefdvtest.presenters.HomeActivityPresenter;
import com.example.intivefdvtest.views.HomeActivityView;
import java.util.ArrayList;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by fbarbieri on 2019-06-05.
 */
public class HomeActivity extends AppCompatActivity implements HomeActivityView {

    private GridDataAdapter adapter;
    GridView gridView;
    ProgressBar progressBar, progressBarPaging;
    LinearLayout llRetry;
    private Button btnRetry;
    HomeActivityPresenter homeActivityPresenter;
    int page = 1;
    boolean isLoading = false;
    private ArrayList<Contact> contacts;

    public static final String CONTACT_INFO = "contact_info";

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setupActionBar();

        gridView = findViewById(R.id.gridView);
        progressBar = findViewById(R.id.progressBar);
        progressBarPaging = findViewById(R.id.progressBarPaging);
        llRetry = findViewById(R.id.llRetry);
        btnRetry = findViewById(R.id.btnRetry);

        homeActivityPresenter = new HomeActivityPresenter(this);
        homeActivityPresenter.getContactData(String.valueOf(page));
    }

    private void setupActionBar() {
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.main_activity_title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void showContactsData(final ArrayList<Contact> contacts) {

        isLoading = false;

        if (progressBarPaging.getVisibility() == View.VISIBLE) {
            progressBarPaging.setVisibility(View.GONE);
        }

        if (adapter == null) {
            this.contacts = contacts;
            adapter = new GridDataAdapter(this, R.layout.layout_grid_imageview, this.contacts);
            gridView.setAdapter(adapter);
        } else {
            this.contacts.addAll(contacts);
            adapter.notifyDataSetChanged();
        }

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> adapterView, final View view, final int i, final long l) {

                final Contact selectedContact = (Contact) gridView.getAdapter().getItem(i);
                goDetailActivity(selectedContact);
            }
        });

        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(final AdapterView<?> adapterView, final View view, final int i,
                final long l) {

                final Contact selectedContact = (Contact) gridView.getAdapter().getItem(i);

                final String fullName = StringUtils.capitalize(selectedContact.getName().getFirst())
                    + StringUtils.SPACE + StringUtils.capitalize(selectedContact.getName().getLast());

                Toast.makeText(HomeActivity.this, fullName, Toast.LENGTH_SHORT).show();

                return true;
            }
        });

        gridView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(final AbsListView absListView, final int i) {
                //Nothing to do
            }

            @Override
            public void onScroll(final AbsListView absListView, final int firstVisibleItem, final int visibleItemCount,
                final int totalItemCount) {
                if (totalItemCount > 0) {
                    final int lastVisibleItem = firstVisibleItem + visibleItemCount;
                    if (!isLoading && (lastVisibleItem == totalItemCount)) {
                        progressBarPaging.setVisibility(View.VISIBLE);
                        isLoading = true;
                        page++;
                        homeActivityPresenter.getContactData(String.valueOf(page));
                    }
                }
            }
        });
        hideProgressBar();
    }

    void goDetailActivity(final Contact selectedContact) {

        final Intent intent = new Intent(HomeActivity.this, DetailActivity.class);
        intent.putExtra(CONTACT_INFO, selectedContact);
        startActivity(intent);
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showRetryView() {
        llRetry.setVisibility(View.VISIBLE);
        btnRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                llRetry.setVisibility(View.GONE);
                homeActivityPresenter.getContactData(String.valueOf(page));
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return false;
    }
}
