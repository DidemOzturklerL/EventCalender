package com.didem.eventcalender.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.didem.eventcalender.R;


/*
 *  FragmentActivity sınıfı, Activity yapısından
 *  Fragment yapısına geçiş yaparken ara sınıftır.
 */
public abstract class AbstractFragmentActivity extends FragmentActivity
{
    /*
     *  Fragment yapısı burada kurulur.
     *  Bu işlemler bellidir.
     *  Ne var ki, yapıyı kuracak olan Fragment'ı döndüren
     *  createFragment() metodunun ne döndürdüğü burada belli değildir.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);

        // getSupportFragmentManager() -> FragmentActivity'den miras kalır.
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id._fragment_container);
        if(fragment == null)
        {
            fragment = createFragment();
            fragmentManager.beginTransaction().add(R.id._fragment_container, fragment).commit();
        }
    }

    /*
     *   Yapının kurulmasını sağlayacak olan Fragment.
     *   Burada ne yaptığı belli değil.
     *   Yavruda belirlenecek.
     */
    protected abstract Fragment createFragment();
}
