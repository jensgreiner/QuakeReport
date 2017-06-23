package com.example.android.quakereport;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

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

        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        if (convertView == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();

            convertView = inflater.inflate(R.layout.earthquake_list_item, parent, false);

            // Using ViewHolder pattern
            holder = new ViewHolder();
            holder.magnitudeText = (TextView) convertView.findViewById(R.id.magnitude);
            holder.locationOffsetText = (TextView) convertView.findViewById(R.id.location_offset);
            holder.primaryLocationText = (TextView) convertView.findViewById(R.id.primary_location);
            holder.dateText = (TextView) convertView.findViewById(R.id.date);
            holder.timeText = (TextView) convertView.findViewById(R.id.time);

            // store the holder with the view
            convertView.setTag(holder);

        } else {
            // we've just avoided calling findViewById() on resource every time
            // just use viewHolder
            holder = (ViewHolder) convertView.getTag();
        }

        // Find the earthquake at the given position in the list of earthquakes
        Earthquake currentEarthquake = getItem(position);

        if (currentEarthquake != null) {
            // Format the magnitude to show 1 decimal place
            String formattedMagnitude = formatMagnitude(currentEarthquake.getMagnitude());
            // Display the magnitude of the current earthquake in that TextView
            holder.magnitudeText.setText(formattedMagnitude);

            // Set the proper background color on the magnitude circle.
            // Fetch the background from the TextView, which is a GradientDrawable.
            GradientDrawable magnitudeCircle = (GradientDrawable) holder.magnitudeText.getBackground();

            // Get the appropriate background color based on the current earthquake magnitude
            int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());

            // Set the color on the magnitude circle
            magnitudeCircle.setColor(magnitudeColor);

            // Create a new String from the location information of the earthquake
            String location = currentEarthquake.getLocation();
            // Format the location strings
            String[] locationParts = formatLocation(location);
            // Display both location parts in their corresponding TextViews
            holder.locationOffsetText.setText(locationParts[0]);
            holder.primaryLocationText.setText(locationParts[1]);

            // Create a new Date object from the time in milliseconds of the earthquake
            Date dateObject = new Date(currentEarthquake.getTimeInMilliseconds());
            // Format the date string (i.e. "Mar 3, 1984")
            String formattedDate = formatDate(dateObject);
            // Display the date of the current earthquake in that TextView
            holder.dateText.setText(formattedDate);
            // Format the time string (i.e. "4:30PM")
            String formattedTime = formatTime(dateObject);
            // Display the time of the current earthquake in that TextView
            holder.timeText.setText(formattedTime);
        }
        return convertView;

    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy", Locale.getDefault());
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a", Locale.getDefault());
        return timeFormat.format(dateObject);
    }

    /**
     * Return a String array with the formatted location parts offset and primary
     */
    private String[] formatLocation(final String locationToFormat) {
        String[] parts = new String[2];
        if (locationToFormat.contains(" of ")) {
            // Use of split with regex: @link https://stackoverflow.com/a/3481842/1469260
            parts = locationToFormat.split("(?<=of) ");
        } else {
            parts[0] = mContext.getString(R.string.location_offset_default);
            parts[1] = locationToFormat;
        }

        return parts;
    }

    /**
     * Return the formatted magnitude string showing 1 decimal place (i.e. "3.2")
     * from a decimal magnitude value.
     */
    private String formatMagnitude(double magnitude) {
        DecimalFormat magFormatter = new DecimalFormat("0.0", DecimalFormatSymbols.getInstance(Locale.getDefault()));
        return magFormatter.format(magnitude);
    }

    /**
     * Return the magnitude color based on the value of magnitude
     */
    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(mContext, magnitudeColorResourceId);
    }

    /**
     * ViewHolder pattern: findViewById method is expensive to use frequently.
     * Having a static class ViewHolder to store the content and retrieve it in an ArrayAdapter
     * is less expensive. (see also code parts above)
     *
     * @link https://stackoverflow.com/a/3832467
     */
    private static class ViewHolder {
        TextView magnitudeText;
        TextView locationOffsetText;
        TextView primaryLocationText;
        TextView dateText;
        TextView timeText;
    }
}
