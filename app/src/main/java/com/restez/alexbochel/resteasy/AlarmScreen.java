package com.restez.alexbochel.resteasy;

import android.content.ClipData;
import android.content.Intent;
import android.content.SharedPreferences;
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

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class AlarmScreen extends AppCompatActivity {

    private FloatingActionButton newAlarmButton;
    public ArrayList<AlarmModel> currentAlarmModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_screen);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        loadAlarmData();

        newAlarmButton = findViewById(R.id.floatingActionButton);

        newAlarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNewAlarmDetailPageActivity();
            }
        });

        checkForAdditionalAlarm();
        initRecyclerView();
    }

    private void checkForAdditionalAlarm() {
        String isAM = "AM";
        Intent intentFromNewAlarmPage = getIntent();

        int alarmHour = intentFromNewAlarmPage.getIntExtra("hourValue", 12);
        int alarmMinute = intentFromNewAlarmPage.getIntExtra("minuteValue", 00);
        String alarmStyle = intentFromNewAlarmPage.getStringExtra("styleValue");
        String alarmIntensity = intentFromNewAlarmPage.getStringExtra("intensityValue");

        if (alarmStyle != null) {

            if (alarmHour == 12) {
                isAM = "PM";
            } else if (alarmHour == 0) {
                alarmHour = 12;
                isAM = "AM";
            } else if (alarmHour > 12) {
                alarmHour = alarmHour - 12;
                isAM = "PM";
            }

            String alarmTime = alarmHour + ":" + String.format("%02d", alarmMinute)
                    + " " + isAM;

            AlarmModel newAlarm = new AlarmModel(alarmTime, alarmIntensity, alarmStyle, true);
            currentAlarmModelList.add(newAlarm);
            saveAlarmData();
        }
    }

    private void initRecyclerView() {
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

    private void saveAlarmData() {
        SharedPreferences sharedPreferences =  getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(currentAlarmModelList);
        editor.putString("alarmsList", json);
        editor.apply();
    }

    private void loadAlarmData() {
        SharedPreferences sharedPreferences =  getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("alarmsList", null);
        Type type = new TypeToken<ArrayList<AlarmModel>>() {}.getType();
        currentAlarmModelList = gson.fromJson(json, type);

        if (currentAlarmModelList == null) {
            currentAlarmModelList = new ArrayList<>();
        }
    }

    private void removeItem(int itemIndexToRemove) {
        //currentAlarmModelList.remove();
    }

    private void openNewAlarmDetailPageActivity() {
        Intent intent = new Intent(this, AlarmDetailPageActivity.class);
        startActivity(intent);
    }

}
