package com.didem.eventcalender.utility;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class Util
{
    private static Util INSTANCE;
    private static Context context;

    private Util(Context context)
    {
        this.context = context;
    }

    public static Util getINSTANCE(Context context)
    {
        if(INSTANCE == null)
        {
            INSTANCE = new Util(context);
        }

        return INSTANCE;
    }

    public static String formatDate(Date date, boolean isClockAdded)
    {
        String dateFormatWithoutClock = "dd-MM-yyyy";
        String dateFormatWithClock = "dd-MM-yyyy hh:mm:ss";

        return isClockAdded ? new SimpleDateFormat(dateFormatWithClock).format(date)
                : new SimpleDateFormat(dateFormatWithoutClock).format(date);
    }

    public boolean isInternetActive()
    {
        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        return (networkInfo != null) && networkInfo.isConnected();
    }

    public void writeShortTimeMessage(String mesaj)
    {
        Toast.makeText(context,mesaj,Toast.LENGTH_SHORT).show();
    }

    public void writeShortTimeMessage(int mesaj)
    {
        Toast.makeText(context,mesaj,Toast.LENGTH_SHORT).show();
    }

    public void writeLongTimeMessage(String mesaj)
    {
        Toast.makeText(context,mesaj,Toast.LENGTH_LONG).show();
    }

    public void writeLongTimeMessage(int mesaj)
    {
        Toast.makeText(context,mesaj,Toast.LENGTH_LONG).show();
    }

}
