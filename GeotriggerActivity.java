package com.example.jose.geotrigger;

import android.app.Activity;

import com.esri.android.geotrigger.GeotriggerBroadcastReceiver;


public abstract class GeotriggerActivity extends Activity implements
        GeotriggerBroadcastReceiver.LocationUpdateListener,
        GeotriggerBroadcastReceiver.ReadyListener{
    private static final String TAG="GeotriggerActivity";

    //Create a new application
    private static final String AGO_CLIENT_ID="4iocTmZK6oiZMXyY";

    //The project number from push cloud from google
    private static final String GCM_SENDER_ID="";

    private static final String[] TAGS= new String[]{"carlota","cordoba","rabanales"};

}
