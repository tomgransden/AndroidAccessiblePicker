package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.NumberPicker;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openPickerAlert(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Hi");
        builder.setPositiveButton("Confirm", (dialogInterface, i) -> {

        });
        builder.setNegativeButton("Cancel", (dialogInterface, i) -> {
        });

        LinearLayout parent = new LinearLayout(this);
        parent.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 100));
        parent.setGravity(Gravity.CENTER);
        parent.setOrientation(LinearLayout.HORIZONTAL);

        NumberPicker np1 = new NumberPicker(this);
        np1.setMinValue(0);
        np1.setMaxValue(20);
        np1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 50));

        NumberPicker np2 = new NumberPicker(this);
        np2.setMinValue(0);
        np2.setMaxValue(20);
        np2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 50));

        parent.addView(np1);
        parent.addView(np2);

        builder.setView(parent);



        builder.show();

    }
}