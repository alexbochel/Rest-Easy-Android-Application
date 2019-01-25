package com.restez.alexbochel.resteasy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

public class AlarmDetailPageActivity extends AppCompatActivity {

    Button backButton;
    NumberPicker alarmIntensityPicker;
    NumberPicker alarmStylePicker;
    Integer chosenStyle;
    Integer chosenIntensity;
    String[] alarmIntensitiesArray = new String[]{"Soft", "Normal", "Hard"};
    String[] alarmStyleArray = new String[]{"Siren", "Constant", "Pulse", "Beep", "Wave"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_detail_page);

        backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                returnToMainAlarmPage();
            }
        });

        setupAlarmIntensityPicker();
        setupAlarmStylePicker();
    }

    private void setupAlarmStylePicker() {
        alarmStylePicker = findViewById(R.id.alarm_style_picker);
        alarmStylePicker.setMinValue(0);
        alarmStylePicker.setMaxValue(4);
        alarmStylePicker.setDisplayedValues(alarmStyleArray);
        alarmStylePicker.setWrapSelectorWheel(false);
        alarmStylePicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                chosenStyle = newVal;
            }
        });
    }

    private void setupAlarmIntensityPicker() {
        alarmIntensityPicker = findViewById(R.id.alarm_intensity_picker);
        alarmIntensityPicker.setMinValue(0);
        alarmIntensityPicker.setMaxValue(2);
        alarmIntensityPicker.setDisplayedValues(alarmIntensitiesArray);
        alarmIntensityPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                chosenIntensity = newVal;
            }
        });
    }

    private void returnToMainAlarmPage() {
        Intent intent = new Intent(this, AlarmScreen.class);
        startActivity(intent);
    }
}
