package com.example.texzad.zad1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.texzad.R;

public class SecondActivity extends AppCompatActivity {
    TextView tv;
    final String TAG = "States2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "MainActivity2: onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tv = findViewById(R.id.tv2);
        tv.setText(this.getClass().getSimpleName());
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText("My name is ");
                tv.append(State.name);
                tv.append(" i'm ");
                tv.append(Integer.toString(State.age));
                tv.append(" years old");
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        State.name = "Mikhail";
        //вызывается при открытии 2 активити и может показывать, мб написали потому что юзер может нажать на кнопку раньше вызова onStop1() где имя игорюхи
        Log.d(TAG, "MainActivity2: onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        State.name = "Igor";
        Log.d(TAG, "MainActivity2: onStop()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        State.age = 21;
        Log.d(TAG, "MainActivity2: onPause()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        State.age = 22;
        //OnCreate2() -> OnStart2() -> OnResume2() для показа в текствью возраста
        Log.d(TAG, "MainActivity2: onResume()");
    }
}