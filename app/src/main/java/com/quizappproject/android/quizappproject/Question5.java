package com.quizappproject.android.quizappproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by Emobilis on 7/1/2018.
 */

public class Question5 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question5);
    }

    int score = 0;

    public void checkAnswer(View view){
        Bundle extras = getIntent().getExtras();
        score = extras.getInt("SCORE_TRACKER");

        TextView scoreKeeper = findViewById(R.id.scoreKeeper);
        scoreKeeper.setText(String.valueOf(score));
        TextView answerStatus = findViewById(R.id.answerStatus);
        RadioButton checkReptile = findViewById(R.id.reptiles);

        if (checkReptile.isChecked()) {
            score = score + 1;
            scoreKeeper.setText(String.valueOf(score));
            answerStatus.setText("CORRECT");
        }else{
            score = score + 0;
            scoreKeeper.setText(String.valueOf(score));
            answerStatus.setText("WRONG, TRY AGAIN");
        }
    }

    public void nextPage(View view){
        Intent intent = new Intent(this,Question6.class);
        intent.putExtra("SCORE_TRACKER",score);
        startActivity(intent);
    }
}
