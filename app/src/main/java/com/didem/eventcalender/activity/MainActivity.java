package com.didem.eventcalender.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.os.Bundle;

import com.didem.eventcalender.R;
import com.didem.eventcalender.fragment.EventListFragment;

public class MainActivity extends AbstractFragmentActivity {


    @Override
    protected Fragment createFragment() {



        return new EventListFragment();
    }
}
