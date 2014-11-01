package com.example.alexgomes_sws901lab3_ex2;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Alex on 10/31/2014.
 */
public class ListRestaurants extends Activity {

    ListView listView;
    public ListAdapter listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurants_list);

        listView = (ListView)findViewById(R.id.listView);

        listAdapter = new ListAdapter(this);
        listView.setAdapter(listAdapter);

    }
    class ListAdapter extends BaseAdapter{

        Context context;
        String[] mapData = null;
        TextView addressName,addressLat,addressLong;

        public ListAdapter(Context c){
            context = c;
            mapData = getResources().getStringArray(R.array.home);
        }

        @Override
        public int getCount() {
            return mapData.length;
        }

        @Override
        public Object getItem(int i) {
            return mapData[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.single_map_data,null);

            addressName = (TextView)view.findViewById(R.id.addressName);
            addressLat = (TextView)view.findViewById(R.id.addressLat);
            addressLong = (TextView)view.findViewById(R.id.addressLong);

            addressName.setText(mapData[i]);
            addressLat.setText(mapData[i]);
            addressLong.setText(mapData[i]);

            return view;
        }
    }
}
