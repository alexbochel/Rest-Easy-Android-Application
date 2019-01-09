package com.restez.alexbochel.resteasy;

import java.util.Date;

public class AlarmModel {

    private static final int numberOfDaysPerWeek = 7;

    private Date AlarmTime;
    private String AlarmIntensity;
    private String AlarmVibrationPattern;
    private boolean AlarmArmedOn;
    private boolean[] DaysAlarmIsArmed = new boolean[numberOfDaysPerWeek];

    public AlarmModel(Date alarmTime, String alarmIntensity, String alarmVibrationPattern,
                      boolean alarmArmedOn)
    {
        AlarmTime = alarmTime;
        AlarmIntensity = alarmIntensity;
        AlarmVibrationPattern = alarmVibrationPattern;
        AlarmArmedOn = alarmArmedOn;

        for (int i = 0; i < numberOfDaysPerWeek; i++)
        {
            DaysAlarmIsArmed[i] = true;
        }
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

    public boolean[] getDaysAlarmIsArmed() {
        return DaysAlarmIsArmed;
    }
}
