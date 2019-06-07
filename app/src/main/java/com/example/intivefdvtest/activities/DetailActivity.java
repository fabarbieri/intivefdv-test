package com.example.intivefdvtest.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import com.example.intivefdvtest.R;
import com.example.intivefdvtest.dtos.Contact;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by fbarbieri on 2019-06-05.
 */
public class DetailActivity extends AppCompatActivity {

    public static final String CONTACT_INFO = "contact_info";

    private SimpleDraweeView simpleDraweeview;
    private TextView tvUserName;
    private TextView tvFirstName;
    private TextView tvLastName;
    private TextView tvEmailAddress;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        setupActionBar();

        final Contact contact = (Contact) getIntent().getSerializableExtra(CONTACT_INFO);

        simpleDraweeview = findViewById(R.id.simpleDraweeview);
        tvUserName = findViewById(R.id.tvUserName);
        tvFirstName = findViewById(R.id.tvFirstName);
        tvLastName = findViewById(R.id.tvLastName);
        tvEmailAddress = findViewById(R.id.tvEmailAddress);

        setContactData(contact);
    }

    private void setContactData(final Contact contact) {

        simpleDraweeview.setImageURI(contact.getPicture().getLarge());

        tvUserName.setText(contact.getLogin().getUsername());
        tvFirstName.setText(StringUtils.capitalize(contact.getName().getFirst()));
        tvLastName.setText(StringUtils.capitalize(contact.getName().getLast()));
        tvEmailAddress.setText(contact.getEmail());
    }

    private void setupActionBar() {
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.detail_activity_title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
