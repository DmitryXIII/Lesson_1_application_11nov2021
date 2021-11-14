package com.ineedyourcode.lesson1application11nov2021;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_layout);

        Button btnChangeLayout2to1 = findViewById(R.id.btn_change_layout_2_to_1);
        TextView txtBirthDate = findViewById(R.id.txt_birthdate);
        CalendarView calendar = findViewById(R.id.calendar);
        calendar.setVisibility(View.GONE);

        btnChangeLayout2to1.setOnClickListener(v -> {
            Intent intent = new Intent(SecondLayout.this, MainActivity.class);
            startActivity(intent);
        });

        txtBirthDate.setOnClickListener(v -> calendar.setVisibility(View.VISIBLE));

        calendar.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            int mYear = year;
            int mMonth = month;
            int mDay = dayOfMonth;
            String selectedDate = new StringBuilder().append(String.valueOf(mDay).length() < 2 ? "0" + mDay : mDay).append(".")
                    .append(String.valueOf(mMonth + 1).length() < 2 ? "0" + (mMonth + 1) : (mMonth + 1)).append(".")
                    .append(mYear).toString();
            txtBirthDate.setText(selectedDate);
            calendar.setVisibility(View.GONE);
        });
    }
}