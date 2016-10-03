package com.joshuapark.treasurehuntaslibrary;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.joshuapark.treasurehuntlibrary.ActivityLauncher;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_launch = (Button)findViewById(R.id.btn_launch);
        btn_launch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityLauncher.launchTreasureHunt(MainActivity.this);
//                ActivityLauncher.launchEmptyAppcompat(MainActivity.this);
            }
        });
    }
}
