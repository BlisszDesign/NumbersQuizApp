package com.example.android.numbersquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by Eszti on 2018. 01. 31..
 */

public class QuestionTwo extends AppCompatActivity {
   public int score;
    private ImageButton send;
    private CheckBox answer1;
    private CheckBox answer2;
    private CheckBox answer3;
    private CheckBox answer4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_box);
        Bundle extras = getIntent().getExtras();
        score = extras.getInt("score");
        answer1 = findViewById(R.id.checkAnswer1);
        answer2 = findViewById(R.id.checkAnswer2);
        answer3 = findViewById(R.id.checkAnswer3);
        answer4 = findViewById(R.id.checkAnswer4);
        send = findViewById(R.id.sendCheck);
    }

    public void sendAnswerButton(View view) {
        if (answer1.isChecked() && answer4.isChecked()) {

            score += 3;
            messageCorrect();
        } else {
            messageWrong();
        }

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

    public void nextQuizButton(View view) {
        Intent nextButtonIntent = new Intent(QuestionTwo.this, QuestionThree.class);
        nextButtonIntent.putExtra("score", score);
        startActivity(nextButtonIntent);
    }
}

