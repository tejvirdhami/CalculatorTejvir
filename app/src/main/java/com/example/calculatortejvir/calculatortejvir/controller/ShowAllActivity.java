package com.example.calculatortejvir.calculatortejvir.controller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calculatortejvir.R;

public class ShowAllActivity extends AppCompatActivity implements View.OnClickListener {


    TextView tvAnswerString;
    Button btnGoBack;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showall);
        initialize();
    }

    private void initialize() {
        tvAnswerString = findViewById(R.id.tvAnswerString);

        btnGoBack = findViewById(R.id.btnGoBack);
        btnGoBack.setOnClickListener(this);

        String answerString = getIntent().getStringExtra("answerString");

        tvAnswerString.setText(answerString);

    }


    @Override
    public void onClick(View v) {
        finish();
    }
}
