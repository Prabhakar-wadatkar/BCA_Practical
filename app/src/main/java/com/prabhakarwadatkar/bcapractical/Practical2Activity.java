package com.prabhakarwadatkar.bcapractical;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Practical2Activity extends AppCompatActivity {
    private EditText number1EditText, number2EditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical2);

        number1EditText = findViewById(R.id.number1);
        number2EditText = findViewById(R.id.number2);
        resultTextView = findViewById(R.id.result);
        Button addButton = findViewById(R.id.add_button);
        Button subtractButton = findViewById(R.id.subtract_button);
        Button multiplyButton = findViewById(R.id.multiply_button);
        Button divideButton = findViewById(R.id.divide_button);

        addButton.setOnClickListener(v -> calculate('+'));
        subtractButton.setOnClickListener(v -> calculate('-'));
        multiplyButton.setOnClickListener(v -> calculate('*'));
        divideButton.setOnClickListener(v -> calculate('/'));
    }

    private void calculate(char operation) {
        String num1Str = number1EditText.getText().toString();
        String num2Str = number2EditText.getText().toString();

        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            resultTextView.setText("Please enter both numbers");
            return;
        }

        double num1 = Double.parseDouble(num1Str);
        double num2 = Double.parseDouble(num2Str);
        double result;

        switch (operation) {
            case '+':
                result = num1 + num2;
                resultTextView.setText("Result: " + result);
                break;
            case '-':
                result = num1 - num2;
                resultTextView.setText("Result: " + result);
                break;
            case '*':
                result = num1 * num2;
                resultTextView.setText("Result: " + result);
                break;
            case '/':
                if (num2 == 0) {
                    resultTextView.setText("Cannot divide by zero");
                } else {
                    result = num1 / num2;
                    resultTextView.setText("Result: " + result);
                }
                break;
        }
    }
}