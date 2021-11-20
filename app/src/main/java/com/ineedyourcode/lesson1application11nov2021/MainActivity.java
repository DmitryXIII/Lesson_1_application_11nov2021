package com.ineedyourcode.lesson1application11nov2021;

/*
====================================
EMS - параметр, определяющий максимальный размер TextView. 1 единица EMS равна ширине заглавной латинской буквы 'M'
в выбранном размере выбранного шрифта. Т.е. при одном и том же шрифте при размерах, например, 12sp и 20sp
размер 1 единицы EMS будет разным.
EMS уитывается только при установленном параметре android:layout_width="wrap_content".
====================================
*/

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private int clickCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout activityMain = findViewById(R.id.layout_main);
        EditText etxtTypeAnything = findViewById(R.id.etxt_type_anything);
        TextView txtNumberOfChars = findViewById(R.id.txt_number_of_chars);
        TextView txtCheckBoxStatus = findViewById(R.id.txt_checkbox_status);
        TextView txtSwitchStatus = findViewById(R.id.txt_switch_status);
        TextView txtBuildNumber = findViewById(R.id.txt_build_number);
        Button btnChangeLayout1to2 = findViewById(R.id.btn_change_layout_1_to_2);
        Button btnCalculateChars = findViewById(R.id.btn_calculate_chars);
        ToggleButton toggleGreenBG = findViewById(R.id.toggle_green_background);
        CheckBox checkBox = findViewById(R.id.cbx_checkbox_1);
        Switch switcher = findViewById(R.id.sw_switch_1);

        btnChangeLayout1to2.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondLayout.class);
            startActivity(intent);
        });

        btnCalculateChars.setOnClickListener(v -> txtNumberOfChars.setText("You entered " + etxtTypeAnything.getText().toString().length() + " chars"));

        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (buttonView.isChecked()) {
                txtCheckBoxStatus.setText(R.string.checkbox_is_checked);
                switcher.setChecked(false);
            } else {
                txtCheckBoxStatus.setText(R.string.checkbox_is_unchecked);
                switcher.setChecked(true);
            }
        });

        switcher.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (buttonView.isChecked()) {
                txtSwitchStatus.setText(R.string.switch_is_checked);
                checkBox.setChecked(false);
            } else {
                txtSwitchStatus.setText(R.string.switch_is_unchecked);
                checkBox.setChecked(true);
            }
        });

        toggleGreenBG.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (buttonView.isChecked()) {
                activityMain.setBackgroundColor(getColor(R.color.mint));
            } else {
                activityMain.setBackgroundColor(getColor(R.color.light_yellow));
            }
        });

        txtBuildNumber.setOnClickListener(v -> {
            clickCounter++;
            if (clickCounter > 3 && clickCounter < 8) {
                Toast toastYouAreDeveloper = Toast.makeText(getApplicationContext(), (clickCounter < 7) ? ("You are in " + (7 - clickCounter) + " steps away from being a developer!") : ("You are developer!"), Toast.LENGTH_SHORT);
                toastYouAreDeveloper.setGravity(Gravity.BOTTOM, 0, 0);
                toastYouAreDeveloper.show();
            }
            if (clickCounter > 7) {
                clickCounter = 0;
            }
        });
    }
}