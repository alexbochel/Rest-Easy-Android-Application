package com.restez.alexbochel.resteasy;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<AlarmModel> alarmModelArrayList;

    public RecyclerViewAdapter(ArrayList<AlarmModel> alarmModelArrayList)
    {
        this.alarmModelArrayList = alarmModelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.
                individual_alarm_cell_layout, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.alarmArmedSwitch.setChecked(alarmModelArrayList.get(i).isAlarmArmedOn());
        viewHolder.alarmTimeView.setText(alarmModelArrayList.get(i).getAlarmTime());

        /*
        viewHolder.sundayButton.setPressed(alarmModelArrayList.get(i).getDaysAlarmIsArmed()[DaysOfTheWeekToIntegers.Sunday]);
        viewHolder.mondayButton.setPressed(alarmModelArrayList.get(i).getDaysAlarmIsArmed()[DaysOfTheWeekToIntegers.Monday]);
        viewHolder.tuesdayButton.setPressed(alarmModelArrayList.get(i).getDaysAlarmIsArmed()[DaysOfTheWeekToIntegers.Tuesday]);
        viewHolder.wednesdayButton.setPressed(alarmModelArrayList.get(i).getDaysAlarmIsArmed()[DaysOfTheWeekToIntegers.Wednesday]);
        viewHolder.thursdayButton.setPressed(alarmModelArrayList.get(i).getDaysAlarmIsArmed()[DaysOfTheWeekToIntegers.Thursday]);
        viewHolder.fridayButton.setPressed(alarmModelArrayList.get(i).getDaysAlarmIsArmed()[DaysOfTheWeekToIntegers.Friday]);
        viewHolder.saturdayButton.setPressed(alarmModelArrayList.get(i).getDaysAlarmIsArmed()[DaysOfTheWeekToIntegers.Saturday]);
        */
    }

    @Override
    public int getItemCount() {
        return alarmModelArrayList.size();
    }

    public void delete(int position) {
        alarmModelArrayList.remove(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout parentLayout;
        TextView alarmTimeView;
        Switch alarmArmedSwitch;

        Button sundayButton;
        Button mondayButton;
        Button tuesdayButton;
        Button wednesdayButton;
        Button thursdayButton;
        Button fridayButton;
        Button saturdayButton;

        public ViewHolder(View itemView)
        {
            super(itemView);

            parentLayout = itemView.findViewById(R.id.parent_recycler_layout);
            alarmTimeView = itemView.findViewById(R.id.alarm_time_display);
            alarmArmedSwitch = itemView.findViewById(R.id.alarm_armed_switch);

            sundayButton = itemView.findViewById(R.id.sunday_button);
            mondayButton = itemView.findViewById(R.id.monday_button);
            tuesdayButton = itemView.findViewById(R.id.tuesday_button);
            wednesdayButton = itemView.findViewById(R.id.wednesday_button);
            thursdayButton = itemView.findViewById(R.id.thursday_button);
            fridayButton = itemView.findViewById(R.id.friday_button);
            saturdayButton = itemView.findViewById(R.id.saturday_button);
        }

        public void onClickDayOfTheWeek(View view) {

        }
    }
}
