package com.example.alexgomes_sws901lab3_ex2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

/**
 * Created by Alex on 10/31/2014.
 */
public class ListRestaurants extends Activity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurants_list);

        listView = (ListView)findViewById(R.id.listView);



    }
    class ListAdapter extends BaseAdapter{

        Context context;
        String[] mapData;

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

            

            return view;
        }
    }
}
