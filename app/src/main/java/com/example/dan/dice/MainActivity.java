package com.example.dan.dice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
    }

    public void onButtonClick(View view) {
        Random random = new Random();
        String message = "continue";

        textView.setText("");

        while (message.equals("continue")) {
            int numberA = random.nextInt(6) + 1;
            int numberB = random.nextInt(6) + 1;
            int total = numberA + numberB;
            message = getMessage(total);
            textView.append(numberA + " + " + numberB + " = " + total +
                                                        " " + message + "\n");
        }
    }

    String getMessage(int total) {
        switch (total) {
            case 7:
            case 11:
                return "win";
            case 2:
            case 3:
            case 12:
                return "lose";
            case 4:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
                return "continue";
            default:
                return "not a valid dice roll";
        }
    }
}
