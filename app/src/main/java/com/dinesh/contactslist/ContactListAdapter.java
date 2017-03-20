package com.dinesh.contactslist;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

/**
 * Created by dinesh on 3/8/2017.
 */

public class ContactListAdapter extends BaseAdapter{
    private Activity activity;
    private LayoutInflater inflater;
    private List<ContactList> conItems;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();



    public ContactListAdapter(Activity activity, List<ContactList> conItems) {
        this.activity = activity;
        this.conItems = conItems;
    }

    @Override
    public int getCount() {
        return conItems.size();
    }

    @Override
    public Object getItem(int location) {
        return conItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_items, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        NetworkImageView thumbNail = (NetworkImageView) convertView
                .findViewById(R.id.ProfileImage);
        TextView name = (TextView) convertView.findViewById(R.id.PersonName);
        TextView rating = (TextView) convertView.findViewById(R.id.Homenumber);

        ContactList m = conItems.get(position);

        // smallImageURL
        thumbNail.setImageUrl(m.getSmallImageURL(), imageLoader);

        // Name
        name.setText(m.getName());
        rating.setText(m.getHome());

        return convertView;
    }
}
