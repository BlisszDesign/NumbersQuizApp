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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by Eszti on 2018. 01. 31..
 */

public class QuestionThree extends AppCompatActivity {
    public int score;
    private ImageButton send;
    private EditText text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_text);
        Bundle extras = getIntent().getExtras();
        score = extras.getInt("score");
        text = findViewById(R.id.textAnswer);
        send = findViewById(R.id.sendCheck);
    }

    public void sendAnswerButton(View view) {
        String answer = text.getText().toString().toLowerCase().trim();
        if (answer.equals("6")) {
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
        Intent nextButtonIntent = new Intent(QuestionThree.this, QuestionFour.class);
        nextButtonIntent.putExtra("score", score);
        startActivity(nextButtonIntent);
    }
}
