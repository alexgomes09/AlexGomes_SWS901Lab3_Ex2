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
import android.widget.Button;
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
        Button btnItalian,btnChinese,btnGreek;

        TypedArray restaurantName,restaurantAddress,restaurantLatitude,restaurantLongitude;

        public ListAdapter(Context c){
            context = c;

            btnItalian = (Button)findViewById(R.id.btnItaliean);
            btnChinese= (Button)findViewById(R.id.btnChinese);
            btnGreek = (Button)findViewById(R.id.btnGreek);

            restaurantName = getResources().obtainTypedArray(R.array.italianLocationName);
            restaurantAddress = getResources().obtainTypedArray(R.array.italianLocationAddress);
            restaurantLatitude = getResources().obtainTypedArray(R.array.italianLatitude);
            restaurantLongitude = getResources().obtainTypedArray(R.array.italianLongitude);

            btnItalian.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    restaurantName = getResources().obtainTypedArray(R.array.italianLocationName);
                    restaurantAddress = getResources().obtainTypedArray(R.array.italianLocationAddress);
                    restaurantLatitude = getResources().obtainTypedArray(R.array.italianLatitude);
                    restaurantLongitude = getResources().obtainTypedArray(R.array.italianLongitude);
                    listAdapter.notifyDataSetChanged();
                }

            });
            btnChinese.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    restaurantName = getResources().obtainTypedArray(R.array.chineseLocationName);
                    restaurantAddress = getResources().obtainTypedArray(R.array.chineseLocationAddress);
                    restaurantLatitude = getResources().obtainTypedArray(R.array.chineseLatitude);
                    restaurantLongitude = getResources().obtainTypedArray(R.array.chineseLongitude);
                    listAdapter.notifyDataSetChanged();
                }
            });
            btnGreek.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    restaurantName = getResources().obtainTypedArray(R.array.greekLocationName);
                    restaurantAddress = getResources().obtainTypedArray(R.array.greekLocationAddress);
                    restaurantLatitude = getResources().obtainTypedArray(R.array.greekLatitude);
                    restaurantLongitude = getResources().obtainTypedArray(R.array.greekLongitude);
                    listAdapter.notifyDataSetChanged();
                }
            });
        }

        @Override
        public int getCount() {
            return restaurantName.length();
        }

        @Override
        public Object getItem(int i) {
            return restaurantName.getIndex(i);
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

            addressName.setText(restaurantName.getString(i));
            address.setText(restaurantAddress.getString(i));

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    Intent intent = new Intent(ListRestaurants.this,MapView.class);
                    intent.putExtra("locationName",restaurantName.getText(i));
                    intent.putExtra("latitude",restaurantLatitude.getText(i));
                    intent.putExtra("longitude",restaurantLongitude.getText(i));
                    startActivity(intent);
                }
            });


            return view;
        }
    }
}
