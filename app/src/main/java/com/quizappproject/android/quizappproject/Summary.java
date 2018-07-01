package com.quizappproject.android.quizappproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by Emobilis on 7/1/2018.
 */

public class Summary extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.summary);
    }

    int score = 0;
    String message;

    public void checkAnswer(View view){
        Bundle extras = getIntent().getExtras();
        score = extras.getInt("SCORE_TRACKER");

        TextView scoreKeeper = findViewById(R.id.scoreKeeper);
        scoreKeeper.setText(String.valueOf(score));
        TextView results = findViewById(R.id.results);

        if (score == 6){
            message = "Congratulations, You have attained the maximum score.You are truly one with nature!!";
            results.setText(message);
        }else{
            message = "Sorry, you were unable to attain the maximum score,better luck next time";
            results.setText(message);
        }
    }
}
