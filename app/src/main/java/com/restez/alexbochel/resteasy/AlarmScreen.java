package com.restez.alexbochel.resteasy;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import java.util.ArrayList;
import java.util.Date;

public class AlarmScreen extends AppCompatActivity {

    private FloatingActionButton newAlarmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_screen);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        newAlarmButton = findViewById(R.id.floatingActionButton);

        newAlarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNewAlarmDetailPageActivity();
            }
        });

        initRecyclerView();
    }

    private void initRecyclerView() {
        ArrayList<AlarmModel> dummyAlarmModelList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
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

    private void openNewAlarmDetailPageActivity() {
        Intent intent = new Intent(this, AlarmDetailPageActivity.class);
        startActivity(intent);
    }

}
