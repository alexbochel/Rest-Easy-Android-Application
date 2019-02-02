package com.restez.alexbochel.resteasy;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import java.util.ArrayList;
import java.util.Date;

public class AlarmScreen extends AppCompatActivity {

    private FloatingActionButton newAlarmButton;
    public ArrayList<AlarmModel> currentAlarmModelList = new ArrayList<>();

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

        for (int i = 0; i < 5; i++) {
            Date dummyDate = new Date();

            AlarmModel dummyAlarm = new AlarmModel(dummyDate, "Dummy", "Dummy",
                    true);
            currentAlarmModelList.add(dummyAlarm);
        }

        RecyclerView scrollableAlarmsView = findViewById(R.id.alarms_recycler_view);
        RecyclerViewAdapter scrollableAlarmsViewAdapter = new RecyclerViewAdapter(currentAlarmModelList);
        scrollableAlarmsView.setAdapter(scrollableAlarmsViewAdapter);
        scrollableAlarmsView.setLayoutManager(new LinearLayoutManager(this));

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                removeItem(i);
            }
        }).attachToRecyclerView(scrollableAlarmsView);
    }

    private void removeItem(int itemIndexToRemove) {
        //currentAlarmModelList.remove();
    }

    private void openNewAlarmDetailPageActivity() {
        Intent intent = new Intent(this, AlarmDetailPageActivity.class);
        startActivity(intent);
    }

}
