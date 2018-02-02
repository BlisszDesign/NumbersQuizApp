package com.example.android.numbersquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //        Start the Quiz
    public void onClick(View view) {
        Intent intent = new Intent(this, QuestionOne.class);
        Bundle extras = new Bundle();
        extras.putInt("score", 0);
        intent.putExtras(extras);
        startActivity(intent);
    }



}


