package com.ineedyourcode.lesson1application11nov2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnChangeLayout1to2 = findViewById(R.id.btn_change_layout_1_to_2);

        btnChangeLayout1to2.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondLayout.class);
            startActivity(intent);
        });
    }
}