package com.didem.eventcalender.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.didem.eventcalender.R;
import com.didem.eventcalender.activity.EventPagerActivity;
import com.didem.eventcalender.utility.AdapterTextWatcher;
import com.didem.eventcalender.utility.EventFactory;
import com.didem.eventcalender.utility.entity.Event;

import java.util.List;

public class EventFragment extends Fragment {

    private static final int DEFAULT_INDEX = 0;

    EditText editPageEventName;
    EditText editPageEventDate;
    CheckBox chkPageEventGone;

    private Event clickedEvent;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


       int clickedIndex = getArguments().getInt(EventPagerActivity.EXTRA_EVENT_INDEX, DEFAULT_INDEX);

       clickedEvent = EventFactory.getEventList().get(clickedIndex);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_event, container,false);

        editPageEventName = view.findViewById(R.id._edit_page_event_name);
        editPageEventDate = view.findViewById(R.id._edit_page_event_date);
        chkPageEventGone = view.findViewById(R.id.chk_page_event_gone);

        editPageEventName.setText(clickedEvent.getName());
        editPageEventDate.setText(clickedEvent.getDate());
        chkPageEventGone.setChecked(clickedEvent.isGone());

        listenChanges();


        return view;

    }

    private void listenChanges() {

        // interfaceyi filtreledik. 3 metot içerisinden istediğimiz metodu getirmek için yapıyı ayarladık.
        editPageEventName.addTextChangedListener(new AdapterTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                clickedEvent.setName(s.toString());
            }
        });

        editPageEventDate.addTextChangedListener(new AdapterTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                clickedEvent.setDate(s.toString());
            }
        });

        chkPageEventGone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                clickedEvent.setGone(isChecked);

            }
        });
    }


}
