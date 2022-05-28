package com.example.task31c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String nameString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonStartQuiz = findViewById(R.id.startButton);
        EditText nameData = findViewById(R.id.enterName);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
        {
            String strName = bundle.getString("name");
            nameData.setText(strName);
        }

        buttonStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameString = nameData.getText().toString();

                if(nameString.isEmpty())
                {
                    Context context = getApplicationContext();
                    CharSequence errorMsg = "Please enter a name.";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, errorMsg, duration);
                    toast.show();
                }
                else
                {
                    openQuiz1();
                }
            }
        });
    }

    public void openQuiz1() {
        Intent intent = new Intent(this, Quiz1.class);
        Bundle bundle = new Bundle();
        bundle.putString("name", nameString);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}