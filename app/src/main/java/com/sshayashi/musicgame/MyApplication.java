package com.sshayashi.musicgame;

import android.app.Application;
import android.content.Context;

/**
 * Created by starprince on 2017/06/28.
 */

public class MyApplication extends Application {

    private static Context context;

    public void onCreate(){
        super.onCreate();
        MyApplication.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return MyApplication.context;
    }
}