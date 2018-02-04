package com.example.android.numbersquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by Eszti on 2018. 01. 31..
 */

public class QuestionFour extends AppCompatActivity {
    int score;
    RadioButton answer1, answer2, answer3;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radio_button2);
        Bundle extras = getIntent().getExtras();
        score = extras.getInt("score");
        answer1 = findViewById(R.id.radio2Answer1);
        answer2 = findViewById(R.id.radio2Answer2);
        send = findViewById(R.id.send_button);

    }

    public void sendButton(View view) {
        if (answer1.isChecked()) {
            score += 3;
            messageCorrect();
        } else {
            messageWrong();
        }
        send.setVisibility(View.INVISIBLE);
    }

    public void messageWrong() {
        Toast.makeText(this, getString(R.string.toast_wrong), Toast.LENGTH_SHORT).show();
    }

    public void messageCorrect() {
        Toast.makeText(this, getString(R.string.toast_correct), Toast.LENGTH_SHORT).show();
    }

    public void nextButton(View view) {
        Intent nextButtonIntent = new Intent(QuestionFour.this, Score.class);
        nextButtonIntent.putExtra("score", score);
        startActivity(nextButtonIntent);
    }
}
