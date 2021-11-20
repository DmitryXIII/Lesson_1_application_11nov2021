package com.ineedyourcode.lesson1application11nov2021;

import android.content.Intent;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_layout);

        ViewGroup tContainer = findViewById(R.id.layout_second_activity);

        Button btnChangeLayout2to1 = findViewById(R.id.btn_change_layout_2_to_1);
        TextView txtBirthDate = findViewById(R.id.txt_birthdate);
        CalendarView calendar = findViewById(R.id.calendar);
        calendar.setVisibility(View.GONE);

        btnChangeLayout2to1.setOnClickListener(v -> {
            Intent intent = new Intent(SecondLayout.this, MainActivity.class);
            startActivity(intent);
        });

        txtBirthDate.setOnClickListener(v -> {
            TransitionManager.beginDelayedTransition(tContainer);
            calendar.setVisibility(View.VISIBLE);
        });

        calendar.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            String selectedDate = (String.valueOf(dayOfMonth).length() < 2 ? "0" + dayOfMonth : dayOfMonth) + "." +
                    (String.valueOf(month + 1).length() < 2 ? "0" + (month + 1) : (month + 1)) + "." +
                    year;
            txtBirthDate.setText(selectedDate);
            TransitionManager.beginDelayedTransition(tContainer);
            calendar.setVisibility(View.GONE);
        });
    }
}