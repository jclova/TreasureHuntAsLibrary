package com.joshuapark.treasurehuntlibrary;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

public class ActivityLauncher {

    public static void launchTreasureHunt(Activity activity) {
        Log.e("Unity", "launchTreasureHunt");
        Intent intent = new Intent(activity, TreasureHuntActivity.class);
        activity.startActivity(intent);
    }

    public static void launchEmpty(Activity activity) {
        Log.e("Unity", "launchEmptyActivity");
        Intent intent = new Intent(activity, EmptyActivity.class);
        activity.startActivity(intent);
    }

    public static void launchEmptyAppcompat(Activity activity) {
        Log.e("Unity", "launchEmptyActivityAppcompat");
        Intent intent = new Intent(activity, EmptyActivityAppcompat.class);
        activity.startActivity(intent);
    }

}