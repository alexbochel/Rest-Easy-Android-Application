package com.restez.alexbochel.resteasy;

import java.util.Date;

public class AlarmModel {

    private Date AlarmTime;
    private String AlarmIntensity;
    private String AlarmVibrationPattern;
    private boolean AlarmArmedOn;

    public AlarmModel(Date alarmTime, String alarmIntensity, String alarmVibrationPattern,
                      boolean alarmArmedOn)
    {
        AlarmTime = alarmTime;
        AlarmIntensity = alarmIntensity;
        AlarmVibrationPattern = alarmVibrationPattern;
        AlarmArmedOn = alarmArmedOn;

    }

    public Date getAlarmTime() {
        return AlarmTime;
    }

    public String getAlarmIntensity() {
        return AlarmIntensity;
    }

    public String getAlarmVibrationPattern() {
        return AlarmVibrationPattern;
    }

    public boolean isAlarmArmedOn() {
        return AlarmArmedOn;
    }
}
