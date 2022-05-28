package com.example.task31c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Results extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Button newQuiz = findViewById(R.id.btnNewQuiz);
        Button finishQuiz = findViewById(R.id.btnFinishQuiz);
        TextView displayName = findViewById(R.id.txtName);
        TextView displayScore = findViewById(R.id.txtScore);

        Bundle bundle = getIntent().getExtras();
        int intFinalScore = bundle.getInt("totalScore");
        String strName = bundle.getString("name");
        String strFinalScore = String.valueOf(intFinalScore);

        displayName.setText(strName);
        displayScore.setText(strFinalScore + "/5");

        newQuiz.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                newQuiz();
            }
        });

        finishQuiz.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finishQuiz();
            }
        });
    }

    public void newQuiz() {
        Bundle bundle = getIntent().getExtras();
        String savedName = bundle.getString("name");

        Intent intent = new Intent(this, MainActivity.class);
        bundle.putString("name", savedName);
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void finishQuiz() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}