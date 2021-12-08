package com.example.calculatortejvir.calculatortejvir.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calculatortejvir.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvQuestion;
    private EditText edAnswer;

    private int operatorFirst = 1 + (int) (Math.random() * 900);
    private int operatorSecond = 1 + (int) (Math.random() * 900);

    private char operator;
    private int num = 1 + (int) (Math.random() * 4);

    private String question="";
    private double answer;
    private String answerString ="";
    private double correctAnswer;
    private int correct = 0;
    private int correctPercent, incorrectPercent = 0;


    private int questionCount = 0;


    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btnDot;
    private Button btnMinus;
    private Button btnClear;
    private Button btnGenerate;
    private Button btnQuit;
    private Button btnEquals;
    private Button btnShowAll;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        generateQuestion();

    }

    private void generateQuestion() {
        edAnswer.setText(null);
        num = (int) (3* Math.random()+1);
        operatorFirst = 1 + (int) (Math.random() * 900);
        operatorSecond = 1 + (int) (Math.random() * 900);
        if(num == 1) {
            operator = '+';
            question = operatorFirst + " " + operator + " " + operatorSecond;
            tvQuestion.setText(question);
            correctAnswer = operatorFirst + operatorSecond;
        }
        else if(num == 2) {
            operator = '-';
            question = operatorFirst + " " + operator + " " + operatorSecond;
            tvQuestion.setText(question);
            correctAnswer = operatorFirst - operatorSecond;
        }
        else if(num == 3) {
            operator = '*';
            question = operatorFirst + " " + operator + " " + operatorSecond;
            tvQuestion.setText(question);
            correctAnswer = operatorFirst * operatorSecond;
        }

    }

    private void initialize() {
        edAnswer = findViewById(R.id.edAnswer);
        tvQuestion = findViewById(R.id.tvQuestion);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnDot = findViewById(R.id.btnDot);
        btnMinus = findViewById(R.id.btnMinus);
        btnClear = findViewById(R.id.btnClear);
        btnGenerate = findViewById(R.id.btnGenerate);
        btnQuit = findViewById(R.id.btnQuit);
        btnEquals = findViewById(R.id.btnEquals);
        btnShowAll = findViewById(R.id.btnShowAll);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnDot.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnGenerate.setOnClickListener(this);
        btnQuit.setOnClickListener(this);
        btnEquals.setOnClickListener(this);
        btnShowAll.setOnClickListener(this);
    }

    @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn0:
                    btn0Pressed();
                    break;
                case R.id.btn1:
                    btn1Pressed();
                    break;
                case R.id.btn2:
                    btn2Pressed();
                    break;
                case R.id.btn3:
                    btn3Pressed();
                    break;
                case R.id.btn4:
                    btn4Pressed();
                    break;
                case R.id.btn5:
                    btn5Pressed();
                    break;
                case R.id.btn6:
                    btn6Pressed();
                    break;
                case R.id.btn7:
                    btn7Pressed();
                    break;
                case R.id.btn8:
                    btn8Pressed();
                    break;
                case R.id.btn9:
                    btn9Pressed();
                    break;
                case R.id.btnMinus:
                    btnMinusPressed();
                    break;
                case R.id.btnDot:
                    btnDotPressed();
                    break;
                case R.id.btnClear:
                    btnClearPressed();
                    break;
                case R.id.btnGenerate:
                    btnGeneratePressed();
                    break;
                case R.id.btnQuit:
                    btnQuitPressed();
                    break;
                case R.id.btnEquals:
                    btnEqualsPressed();
                    break;
                case R.id.btnShowAll:
                    btnShowAllPressed();
                    break;


            }
        }



    private void btnEqualsPressed() {
        questionCount++;
        answer = Integer.parseInt(edAnswer.getText().toString());
        if(answer == correctAnswer)
        {
            correct++;
            answerString += question +"\n" + "Your answer is correct" + "\n" +"___________________"+ "\n";
        }
        else if(answer != correctAnswer)
        {
            answerString += question +"\n" + "Your answer is wrong!" + "\n" + "Correct Answer is: " + correctAnswer + "\n" +"___________________"+ "\n";
        }
        correctPercent = (correct*100)/questionCount;
        incorrectPercent = 100 - correctPercent;
        Toast.makeText(getApplicationContext(), "Answer Saved! Please Proceed", Toast.LENGTH_SHORT).show();
    }

    private void btnShowAllPressed() {
        answerString += "\n\n" +correctPercent+ " % Correct Answers" +"\n"+incorrectPercent+ " % Incorrect Answers";
        Intent intent = new Intent(this, ShowAllActivity.class);


        intent.putExtra("answerString", answerString);

        startActivity(intent);

    }





    private void btnQuitPressed() {
        System.exit(0);
    }

    private void btnGeneratePressed() {
        generateQuestion();
        }

    private void btnClearPressed() {
        edAnswer.setText(null);
    }

    private void btnDotPressed() {
        edAnswer.setText(edAnswer.getText()+".");
    }

    private void btnMinusPressed() {
        edAnswer.setText(edAnswer.getText()+"-");
    }

    private void btn9Pressed() {
        edAnswer.setText(edAnswer.getText()+"9");
    }

    private void btn8Pressed() {
        edAnswer.setText(edAnswer.getText()+"8");
    }

    private void btn7Pressed() {
        edAnswer.setText(edAnswer.getText()+"7");
    }

    private void btn6Pressed() {
        edAnswer.setText(edAnswer.getText()+"6");
    }

    private void btn5Pressed() {
        edAnswer.setText(edAnswer.getText()+"5");
    }

    private void btn4Pressed() {
        edAnswer.setText(edAnswer.getText()+"4");
    }

    private void btn3Pressed() {
        edAnswer.setText(edAnswer.getText()+"3");
    }

    private void btn2Pressed() {
        edAnswer.setText(edAnswer.getText()+"2");
    }

    private void btn1Pressed() {
        edAnswer.setText(edAnswer.getText()+"1");
    }

    private void btn0Pressed() {
        edAnswer.setText(edAnswer.getText()+"0");
    }


}