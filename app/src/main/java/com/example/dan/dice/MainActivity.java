package com.example.dan.dice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTotal();
            }
        });
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

    public void displayTotal() {
        String message = "";
        Random random = new Random();
        label:
        while (!message.equals("win")) {
            int numberA = random.nextInt(6) + 1;
            int numberB = random.nextInt(6) + 1;
            int total = numberA + numberB;
            message = getMessage(total);
            switch (message) {
                case "continue":
                    textView.append(numberA + " + " + numberB + " = " + total + " " + message + "\n");
                    break;
                case "win":
                    textView.append(numberA + " + " + numberB + " = " + total + " " + "You Win" + "\n");
                    break;
                case "lose":
                    textView.append(numberA + " + " + numberB + " = " + total + " " + "You Lose" + "\n");
                    break label;
            }
        }
    }
}