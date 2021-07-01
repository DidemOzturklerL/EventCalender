package com.didem.eventcalender.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import com.didem.eventcalender.R;
import com.didem.eventcalender.activity.EventPagerActivity;
import com.didem.eventcalender.activity.MainActivity;
import com.didem.eventcalender.utility.EventFactory;
import com.didem.eventcalender.utility.Util;
import com.didem.eventcalender.utility.entity.Event;

import java.util.List;

public class EventListFragment extends ListFragment {


    private Util UTIL;
    private List<Event> eventList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        UTIL = Util.getINSTANCE(getActivity());

        eventList = EventFactory.getEventList();

        BaseAdapter adapter = new EventListAdaptor();

        setListAdapter(adapter); //


    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        Intent intentPager = new Intent(getActivity(), EventPagerActivity.class);

        intentPager.putExtra(EventPagerActivity.EXTRA_EVENT_INDEX,position);

        startActivity(intentPager);


    }

    private class EventListAdaptor extends BaseAdapter {
        @Override
        public int getCount() {
            return eventList.size();
        }

        @Override
        public Object getItem(int position) {
            return eventList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return eventList.get(position).getEventID().getMostSignificantBits(); // longa dönüşüm yapar.
        }


        // bu metot listedeki tek bir elemanın görüntüsünü anlatır. metodu ona göre yapılandırırız.
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if(convertView == null) {

                convertView = getActivity().getLayoutInflater().inflate(R.layout.event_list_unit_member, parent,false);
            }

            Event event = eventList.get(position);
            TextView textName = convertView.findViewById(R.id._event_name);
            textName.setText(event.getName());

            TextView textDate = convertView.findViewById(R.id._event_date);
            textDate.setText(event.getDate());

            CheckBox checkList = convertView.findViewById(R.id._event_check);
            checkList.setChecked(event.isGone());
            

            

            return convertView;
        }


    }
}
