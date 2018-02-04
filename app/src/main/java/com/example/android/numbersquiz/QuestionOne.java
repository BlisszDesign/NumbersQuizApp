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


public class QuestionOne extends AppCompatActivity {
    //        declaring variables
    int score;
    RadioButton answer1, answer2, answer3;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radio_button);
        Bundle extras = getIntent().getExtras();
        score = extras.getInt("score");
        answer1 = findViewById(R.id.radioAnswer1);
        answer2 = findViewById(R.id.radioAnswer2);
        answer3 = findViewById(R.id.radioAnswer3);
        send = findViewById(R.id.send_button);

    }

    // sending and checking answer
    public void sendAnswer(View view) {
        if (answer3.isChecked()) {
            score += 3;
            messageCorrect();
        } else {
            messageWrong();
        }
//        set the send button visibility
        send.setVisibility(View.INVISIBLE);
    }

    // set toast messages
    public void messageWrong() {
        Toast.makeText(this, getString(R.string.toast_wrong), Toast.LENGTH_SHORT).show();
    }

    public void messageCorrect() {
        Toast.makeText(this, getString(R.string.toast_correct), Toast.LENGTH_SHORT).show();
    }

    //set next button
    public void nextQuiz(View view) {
        Intent nextButtonIntent = new Intent(QuestionOne.this, QuestionTwo.class);
        nextButtonIntent.putExtra("score", score);
        startActivity(nextButtonIntent);
    }
}


