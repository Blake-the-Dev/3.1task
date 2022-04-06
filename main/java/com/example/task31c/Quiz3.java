package com.example.task31c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Quiz3 extends AppCompatActivity implements View.OnClickListener {

    int score = 0;
    int choice = 0;
    boolean nextQuestion = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz3);

        Button quizA = findViewById(R.id.btnA);
        Button quizB = findViewById(R.id.btnB);
        Button quizC = findViewById(R.id.btnC);
        Button quizSub = findViewById(R.id.btnSub);

        quizA.setOnClickListener(this);
        quizB.setOnClickListener(this);
        quizC.setOnClickListener(this);

        quizSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (nextQuestion == true) {
                    openQuiz4();
                } else if (choice == 1) {
                    score++;
                    nextQuestion = true;
                    quizA.setBackgroundColor(Color.GREEN);
                    quizSub.setText("Next");
                } else if (choice == 2) {
                    nextQuestion = true;
                    quizA.setBackgroundColor(Color.GREEN);
                    quizB.setBackgroundColor(Color.RED);
                    quizSub.setText("Next");
                } else if (choice == 3) {
                    nextQuestion = true;
                    quizA.setBackgroundColor(Color.GREEN);
                    quizC.setBackgroundColor(Color.RED);
                    quizSub.setText("Next");
                }
                else
                {
                    Context context = getApplicationContext();
                    CharSequence errorMsg = "Please select an option";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, errorMsg, duration);
                    toast.show();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnA:
                choice = 1;
                answerResult(true);
                ((Button) findViewById(R.id.btnA)).setEnabled(false);
                ((Button) findViewById(R.id.btnB)).setEnabled(false);
                ((Button) findViewById(R.id.btnC)).setEnabled(false);
                break;
            case R.id.btnB:
                choice = 2;
                answerResult(false);
                ((Button) findViewById(R.id.btnA)).setEnabled(false);
                ((Button) findViewById(R.id.btnB)).setEnabled(false);
                ((Button) findViewById(R.id.btnC)).setEnabled(false);
                break;
            case R.id.btnC:
                choice = 3;
                answerResult(false);
                ((Button) findViewById(R.id.btnA)).setEnabled(false);
                ((Button) findViewById(R.id.btnB)).setEnabled(false);
                ((Button) findViewById(R.id.btnC)).setEnabled(false);
                break;
        }
    }

    public static boolean answerResult(boolean isCorrect)
    {
        if(isCorrect == true)
        {
            return true;
        }
        return false;
    }

    public void openQuiz4() {
        Bundle bundle = getIntent().getExtras();
        int oldScore = bundle.getInt("totalScore");
        int newScore = oldScore + score;
        String savedName = bundle.getString("name");

        System.out.println("The score is: " + newScore);

        Intent intent = new Intent(this, Quiz4.class);
        bundle.putInt("totalScore", newScore);
        bundle.putString("name", savedName);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}