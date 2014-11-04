package com.example.alexgomes_sws901lab3_ex2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
        TextView addressName,address;

        TypedArray xmlName,xmlAddress,xmlLatitude,xmlLongitude;

        public ListAdapter(Context c){
            context = c;

            xmlName = getResources().obtainTypedArray(R.array.locationName);
            xmlAddress = getResources().obtainTypedArray(R.array.locationAddress);
            xmlLatitude = getResources().obtainTypedArray(R.array.latitude);
            xmlLongitude = getResources().obtainTypedArray(R.array.longitude);

        }

        @Override
        public int getCount() {
            return xmlName.length();
        }

        @Override
        public Object getItem(int i) {
            return xmlName.getIndex(i);
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
            address = (TextView)view.findViewById(R.id.address);

            addressName.setText(xmlName.getString(i));
            address.setText(xmlAddress.getString(i));

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(ListRestaurants.this,MapView.class);
                    intent.putExtra("locationName",xmlName.getText(i));
                    intent.putExtra("latitude",xmlLatitude.getText(i));
                    intent.putExtra("longitude",xmlLongitude.getText(i));
                    startActivity(intent);
                }
            });


            return view;
        }
    }
}
