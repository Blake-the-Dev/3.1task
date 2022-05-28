package com.example.task21p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.unitList);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource( this,R.array.unitType, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String spinnerItem = parent.getItemAtPosition(position).toString();
        parent.getItemAtPosition(position);

        EditText getValue = findViewById(R.id.enterValue);
        TextView unitType1 = findViewById(R.id.unit1);
        TextView unitType2 = findViewById(R.id.unit2);
        TextView unitType3 = findViewById(R.id.unit3);
        TextView resultValue1 = findViewById(R.id.result1);
        TextView resultValue2 = findViewById(R.id.result2);
        TextView resultValue3 = findViewById(R.id.result3);
        ImageButton meterClicked = findViewById(R.id.meterButton);
        ImageButton kilogramClicked = findViewById(R.id.kilogramButton);
        ImageButton celciusClicked = findViewById(R.id.celciusButton);
        Context context = getApplicationContext();
        CharSequence errorMsg = "Please select the correct conversion icon.";
        int duration = Toast.LENGTH_SHORT;


            meterClicked.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view) {
                    if (position == 0 && getValue.length() > 0)
                    {
                        double numValue = Double.parseDouble(getValue.getText().toString());
                        double cmValue = numValue * 100;
                        double ftValue = numValue * 3.28084;
                        double inValue = numValue * 39370.1;

                        String cmString = String.valueOf(cmValue).format("%.2f", cmValue);
                        String ftString = String.valueOf(ftValue).format("%.2f", ftValue);
                        String inString = String.valueOf(inValue).format("%.2f", inValue);

                        resultValue1.setText(cmString);
                        resultValue1.setVisibility(View.VISIBLE);
                        resultValue2.setText(ftString);
                        resultValue2.setVisibility(View.VISIBLE);
                        resultValue3.setText(inString);
                        resultValue3.setVisibility(View.VISIBLE);
                        unitType1.setText("cm");
                        unitType1.setVisibility(View.VISIBLE);
                        unitType2.setText("ft");
                        unitType2.setVisibility(View.VISIBLE);
                        unitType3.setText("in");
                        unitType3.setVisibility(View.VISIBLE);
                        }
                        else
                        {
                            Toast toast = Toast.makeText(context, errorMsg, duration);
                            toast.show();
                        }
                }
            });

        celciusClicked.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                if (position == 1 && getValue.length() > 0)
                {
                    double numValue = Double.parseDouble(getValue.getText().toString());
                    double fValue = numValue * 32;
                    double kValue = numValue * 273.15;

                    String fString = String.valueOf(fValue).format("%.2f", fValue);
                    String kString = String.valueOf(kValue).format("%.2f", kValue);

                    resultValue1.setText(fString);
                    resultValue1.setVisibility(View.VISIBLE);
                    resultValue2.setText(kString);
                    resultValue2.setVisibility(View.VISIBLE);
                    resultValue3.setVisibility(View.INVISIBLE);
                    unitType1.setText("f");
                    unitType1.setVisibility(View.VISIBLE);
                    unitType2.setText("k");
                    unitType2.setVisibility(View.VISIBLE);
                    unitType3.setVisibility(View.INVISIBLE);

                }
                else
                {
                    Toast toast = Toast.makeText(context, errorMsg, duration);
                    toast.show();
                }
            }
        });

        kilogramClicked.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                if (position == 2 && getValue.length() > 0)
                {
                    double numValue = Double.parseDouble(getValue.getText().toString());
                    double gValue = numValue * 1000;
                    double ozValue = numValue * 35.274;
                    double lbValue = numValue * 2.20462;

                    String gString = String.valueOf(gValue).format("%.2f", gValue);
                    String lbString = String.valueOf(ozValue).format("%.2f", ozValue);
                    String ozString = String.valueOf(lbValue).format("%.2f", lbValue);

                    resultValue1.setText(gString);
                    resultValue1.setVisibility(View.VISIBLE);
                    resultValue2.setText(lbString);
                    resultValue2.setVisibility(View.VISIBLE);
                    resultValue3.setText(ozString);
                    resultValue3.setVisibility(View.VISIBLE);
                    unitType1.setText("g");
                    unitType1.setVisibility(View.VISIBLE);
                    unitType2.setText("oz");
                    unitType2.setVisibility(View.VISIBLE);
                    unitType3.setText("lb");
                    unitType3.setVisibility(View.VISIBLE);
                }
                else
                {
                    Toast toast = Toast.makeText(context, errorMsg, duration);
                    toast.show();
                }
            }
        });

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) { }
}