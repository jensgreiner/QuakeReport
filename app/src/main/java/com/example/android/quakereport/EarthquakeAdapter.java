package com.example.android.quakereport;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Custom ArrayAdapter to handle earthquake list objects
 * Created by Jens Greiner on 18.06.17.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private final Context mContext;

    /**
     * Constructor
     *
     * @param context     The current context.
     * @param earthquakes The earthquake objects to represent in the ListView.
     */
    public EarthquakeAdapter(@NonNull Context context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
        mContext = context;
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();

            convertView = inflater.inflate(R.layout.earthquake_list_item, parent, false);

            // Using ViewHolder pattern
            holder = new ViewHolder();
            holder.magnitudeText = (TextView) convertView.findViewById(R.id.magnitude_text_view);
            holder.locationText = (TextView) convertView.findViewById(R.id.location_text_view);
            holder.dateText = (TextView) convertView.findViewById(R.id.date_text_view);

            // store the holder with the view
            convertView.setTag(holder);

        } else {
            // we've just avoided calling findViewById() on resource every time
            // just use viewHolder
            holder = (ViewHolder) convertView.getTag();
        }

        Earthquake currentEarthquake = getItem(position);

        if (currentEarthquake != null) {
            holder.magnitudeText.setText(currentEarthquake.getmMagnitude());
            holder.locationText.setText(currentEarthquake.getmLocation());
            holder.dateText.setText(currentEarthquake.getmDate());
        }
        return convertView;

    }

    /**
     * ViewHolder pattern: findViewById method is expensive to use frequently.
     * Having a static class ViewHolder to store the content and retrieve it in an ArrayAdapter
     * is less expensive. (see also code parts above)
     *
     * @link https://stackoverflow.com/a/3832467
     */
    static class ViewHolder {
        TextView magnitudeText;
        TextView locationText;
        TextView dateText;
    }
}
