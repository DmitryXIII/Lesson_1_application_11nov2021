package com.ineedyourcode.lesson1application11nov2021;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SecondLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_layout);

        Button btnChangeLayout2to1 = findViewById(R.id.btn_change_layout_2_to_1);

        btnChangeLayout2to1.setOnClickListener(v -> {
            Intent intent = new Intent(SecondLayout.this, MainActivity.class);
            startActivity(intent);
        });
    }
}
