package com.example.texzad.zad1;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.texzad.R;

import java.util.ArrayList;
import java.util.Arrays;

public class FirstActivity extends AppCompatActivity {
    TextView tv;
    final String TAG = "States1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "MainActivity: onCreate()");

        //zad1
        Vacancy vacancy = new Vacancy("developer");
        User tester = new User(7,vacancy);

        System.out.println(tester.getId());
        System.out.println(tester.getVacancy());

        //zad2
        int[] oldPrice = new int[]{20, 40, 60, 80 ,100, 120, 140, 160, 180};
        System.out.println("discountPrice is: " + Arrays.toString(decryptData(oldPrice, 20, 2,5)));

        //zad3
        tv = findViewById(R.id.tv1);
        tv.setText(this.getClass().getSimpleName());
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText("My name is ");
                tv.append(State.name);
                tv.append(" i'm ");
                tv.append(Integer.toString(State.age));
                tv.append(" years old");
            }
        });
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    public @Nullable
    int[] decryptData(@NonNull int[] price,
                      @IntRange(from = 1) int discount,
                      @IntRange(from = 0) int offset,
                      @IntRange(from = 1) int readLength) {
//TODO реализовать метод
        int totalLenght = readLength + offset;
        int[] discountPrice = new int[readLength];

        for (int i = offset; i < totalLenght; i++){
            discountPrice[i-offset] = price[i]/discount;
        }

        return discountPrice;
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "MainActivity: onStart()");
        State.name = "Mikhail";
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "MainActivity: onStop()");
        //вызывается после закрытия 1 активити поэтому показывает имя Игорюхи во втором активити после клика по кнопке после onResume2()
        State.name = "Igor";
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "MainActivity: onPause()");
        State.age = 21;
    }
    @Override
    protected void onResume() {
        super.onResume();
        //OnCreate() -> OnStart() -> OnResume() мб написали потому что юзер может нажать на кнопку до вызова onResume2()
        Log.d(TAG, "MainActivity: onResume()");
        State.age = 22;
    }
}