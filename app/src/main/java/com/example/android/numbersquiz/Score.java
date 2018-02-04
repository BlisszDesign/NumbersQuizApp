package com.example.android.numbersquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Eszti on 2018. 02. 02..
 */

public class Score extends AppCompatActivity {
    //    declaring variables
    int score;
    int score1 = 4;
    int score2 = 8;
    ImageView image;
    TextView scoreNumber, rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score1);
        Bundle extras = getIntent().getExtras();
        score = extras.getInt("score");
        image = findViewById(R.id.scoreImage);
        scoreNumber = findViewById(R.id.scoreNumber);
        rating = findViewById(R.id.scoreText);
        displayScore();
    }

    //  set the score image and text
    public void displayScore() {
        if (score <= score1) {
            image.setImageResource(R.drawable.mushroom);
            scoreNumber.setText(String.valueOf(score));
            rating.setText(R.string.score1);
            return;
        } else if (score > score1 && score <= score2) {
            image.setImageResource(R.drawable.bee);
            scoreNumber.setText(String.valueOf(score));
            rating.setText(R.string.score2);
            return;
        } else {
            image.setImageResource(R.drawable.ladybug);
            scoreNumber.setText(String.valueOf(score));
            rating.setText(R.string.score3);
            return;
        }
    }
// return to mainActivity
    public void returnToStart(View view) {
        finish();
        Intent intent = new Intent(Score.this, MainActivity.class);
        startActivity(intent);
    }
}
