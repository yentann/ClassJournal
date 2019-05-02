package com.example.classjournal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    private ArrayList<Class> infoLists;
    private Context context;
    private TextView tvWeek;
    private TextView tvGrade;


    public CustomAdapter(Context context, int resource, ArrayList<Class> objects) {
        super(context, resource, objects);
        // Store Context object as we would need to use it later
        this.context = context;
        // Store the data that is passed to this adapter
        infoLists = objects;
    }


    // getView() is the method ListView will call to get the View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        // The usual way to get the LayoutInflater object to "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.custom_row, parent,false);

        // Get the TextView object
        tvWeek =  rowView.findViewById(R.id.textViewWeek);
        tvGrade = rowView.findViewById(R.id.textViewGrade);

        // The parameter "position" is the index of the row ListView is requesting. We get back the food at the same index.
        Class current = infoLists.get(position);
        // Set the TextView to show the food
        tvWeek.setText(current.getWeek());
        tvGrade.setText(current.getGrade());
        // Return the nicely done up View to the ListView
        return rowView;
     }

}

