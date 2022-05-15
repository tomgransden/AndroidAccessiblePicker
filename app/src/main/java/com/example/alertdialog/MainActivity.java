package com.example.alertdialog;

import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Field;

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
        np1.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            np1.setTextColor(getResources().getColor(R.color.sw_red));
        } else {
            setNumberPickerTextColor(np1, getResources().getColor(R.color.sw_red));
        }
        np1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 50));

        NumberPicker np2 = new NumberPicker(this);
        np2.setMinValue(0);
        np2.setMaxValue(20);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            np2.setTextColor(getResources().getColor(R.color.sw_red));
        } else {
            setNumberPickerTextColor(np2, getResources().getColor(R.color.sw_red));
        }

        np2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 50));

        parent.addView(np1);
        parent.addView(np2);

        TextView textView = new TextView(this);
        textView.setText("Select an option");
        textView.setPadding(20, 30, 20, 30);
        textView.setTextSize(20F);
        textView.setTextColor(getResources().getColor(R.color.sw_red));

        builder.setView(parent);
        builder.setCustomTitle(textView);



        builder.show();

    }

    public static void setNumberPickerTextColor(NumberPicker numberPicker, int color)
    {

        try{
            Field selectorWheelPaintField = numberPicker.getClass()
                    .getDeclaredField("mSelectorWheelPaint");
            selectorWheelPaintField.setAccessible(true);
            ((Paint)selectorWheelPaintField.get(numberPicker)).setColor(color);
        }
        catch(NoSuchFieldException e){
            Log.w("setNumberPickerTextColor", e);
        }
        catch(IllegalAccessException e){
            Log.w("setNumberPickerTextColor", e);
        }
        catch(IllegalArgumentException e){
            Log.w("setNumberPickerTextColor", e);
        }

        final int count = numberPicker.getChildCount();
        for(int i = 0; i < count; i++){
            View child = numberPicker.getChildAt(i);
            if(child instanceof EditText)
                ((EditText)child).setTextColor(color);
        }
        numberPicker.invalidate();
    }
}