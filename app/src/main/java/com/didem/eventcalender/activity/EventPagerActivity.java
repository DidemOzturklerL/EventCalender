package com.didem.eventcalender.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.didem.eventcalender.R;
import com.didem.eventcalender.fragment.EventFragment;
import com.didem.eventcalender.utility.EventFactory;
import com.didem.eventcalender.utility.entity.Event;

import java.util.List;

public class EventPagerActivity extends FragmentActivity {

    // activityden fragment sınıfına geciş yaparkenki aracı sınıf ==> FragmentActivity

    private List<Event> eventList = EventFactory.getEventList();

    // index bilgisi çekilecek



    public static final String EXTRA_EVENT_INDEX = " ";
    private ViewPager pager;

    private int response;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        pager = new ViewPager(this);

        pager.setId(R.id._event_pager); // a

        response = getIntent().getIntExtra(EXTRA_EVENT_INDEX,0);

        FragmentManager fragmentManager = getSupportFragmentManager();

        pager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) { // b
            @NonNull
            @Override
            public Fragment getItem(int position) {

                EventFragment eventFragment = new EventFragment();

                Bundle bundle = new Bundle();

                bundle.putInt(EXTRA_EVENT_INDEX,position);

                eventFragment.setArguments(bundle); // Fragment'a bilgi yüklemek için

                // "position" bilgisi yüklenen Fragment döndürülür
                return eventFragment;
            }

            @Override
            public int getCount() {
                return eventList.size();
            }
        });


        pager.setCurrentItem(response);


        setContentView(pager); // Viewın yüklenmesini fragment üstlenecek. View ı activity değil fragment kontrol edecek

    }


}
