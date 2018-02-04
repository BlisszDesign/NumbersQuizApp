package com.example.android.numbersquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

/**
 * Created by Eszti on 2018. 01. 31..
 */

public class QuestionTwo extends AppCompatActivity {
    int score;
    Button send;
    CheckBox answer1, answer2, answer3, answer4;

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

    public void messageWrong() {
        Toast.makeText(this, getString(R.string.toast_wrong), Toast.LENGTH_SHORT).show();
    }

    public void messageCorrect() {
        Toast.makeText(this, getString(R.string.toast_correct), Toast.LENGTH_SHORT).show();
    }

    public void nextQuizButton(View view) {
        Intent nextButtonIntent = new Intent(QuestionTwo.this, QuestionThree.class);
        nextButtonIntent.putExtra("score", score);
        startActivity(nextButtonIntent);
    }
}

