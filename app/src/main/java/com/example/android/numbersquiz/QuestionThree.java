package com.example.android.numbersquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Eszti on 2018. 01. 31..
 */

public class QuestionThree extends AppCompatActivity {
    int score;
    Button send;
    EditText text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_text);
        Bundle extras = getIntent().getExtras();
        score = extras.getInt("score");
        text = findViewById(R.id.textAnswer);
        send = findViewById(R.id.send_button);
    }

    public void send(View view) {
        String answer = text.getText().toString().toLowerCase().trim();
        if (answer.equals("6")) {
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

    public void next(View view) {
        Intent nextButtonIntent = new Intent(QuestionThree.this, QuestionFour.class);
        nextButtonIntent.putExtra("score", score);
        startActivity(nextButtonIntent);
    }
}
