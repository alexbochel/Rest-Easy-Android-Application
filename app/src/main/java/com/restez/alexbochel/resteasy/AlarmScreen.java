package com.restez.alexbochel.resteasy;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AlarmScreen extends AppCompatActivity {

    private static final String TAG = "Main Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Log.d(TAG, "On Create: Started");

        initRecyclerView();
    }

    private void initRecyclerView() {

        Log.d(TAG, "Main Alarm View Creation Started");

        ArrayList<AlarmModel> dummyAlarmModelList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Date dummyDate = new Date();

            AlarmModel dummyAlarm = new AlarmModel(dummyDate, "Dummy", "Dummy",
                    true);
            dummyAlarmModelList.add(dummyAlarm);
        }
        RecyclerView scrollableAlarmsView = findViewById(R.id.alarms_recycler_view);
        RecyclerViewAdapter scrollableAlarmsViewAdapter = new RecyclerViewAdapter(dummyAlarmModelList);
        scrollableAlarmsView.setAdapter(scrollableAlarmsViewAdapter);
        scrollableAlarmsView.setLayoutManager(new LinearLayoutManager(this));
    }

}
