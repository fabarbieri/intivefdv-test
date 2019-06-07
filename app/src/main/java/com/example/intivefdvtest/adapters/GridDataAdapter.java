package com.example.intivefdvtest.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.example.intivefdvtest.R;
import com.example.intivefdvtest.dtos.Contact;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;

/**
 * Created by fbarbieri on 2019-06-05.
 */
public class GridDataAdapter extends BaseAdapter {

    private final LayoutInflater mInflater;
    private final int mLayoutResource;
    private final ArrayList<Contact> mContacts;

    public GridDataAdapter(final Context context, final int layoutResource, final ArrayList<Contact> contacts) {
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mLayoutResource = layoutResource;
        mContacts = contacts;
    }

    private static class ViewHolder {
        SimpleDraweeView image;
    }

    @Override
    public int getCount() {
        return mContacts.size();
    }

    @Override
    public Contact getItem(final int i) {
        return mContacts.get(i);
    }

    @Override
    public long getItemId(final int i) {
        return i;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull final ViewGroup parent) {

        final ViewHolder holder;

        if (convertView == null) {
            convertView = mInflater.inflate(mLayoutResource, parent, false);
            holder = new ViewHolder();
            holder.image = convertView.findViewById(R.id.simpleDraweeview);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final String imageUrl = getItem(position).getPicture().getThumbnail();
        holder.image.setImageURI(imageUrl);

        return convertView;
    }
}
