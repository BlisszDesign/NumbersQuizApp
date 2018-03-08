package com.example.android.numbersquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by Eszti on 2018. 01. 31..
 */


public class QuestionOne extends AppCompatActivity {
    //        declaring variables
    public int score;
    private RadioButton answer1;
    private RadioButton answer2;
    private RadioButton answer3;
    private ImageButton send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radio_button);
        Bundle extras = getIntent().getExtras();
        score = extras.getInt("score");
        answer1 = findViewById(R.id.radioAnswer1);
        answer2 = findViewById(R.id.radioAnswer2);
        answer3 = findViewById(R.id.radioAnswer3);
        send = findViewById(R.id.sendCheck);

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
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_bad, (ViewGroup) findViewById(R.id.toast_bad));
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }

    public void messageCorrect() {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_correct, (ViewGroup) findViewById(R.id.toast_correct));
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }


    //set next button
    public void nextQuiz(View view) {
        Intent nextButtonIntent = new Intent(QuestionOne.this, QuestionTwo.class);
        nextButtonIntent.putExtra("score", score);
        startActivity(nextButtonIntent);
    }
}


