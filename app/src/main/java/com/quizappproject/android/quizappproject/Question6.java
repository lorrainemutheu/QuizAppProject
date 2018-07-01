package com.quizappproject.android.quizappproject;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Emobilis on 7/1/2018.
 */

public class Question6 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question6);
    }

    int score = 0;

    public void checkAnswer(View view){
        Bundle extras = getIntent().getExtras();
        score = extras.getInt("SCORE_TRACKER");

        TextView scoreKeeper = findViewById(R.id.scoreKeeper);
        scoreKeeper.setText(String.valueOf(score));
        TextView answerStatus = findViewById(R.id.answerStatus);
        EditText editText = findViewById(R.id.editText);

        String answer = "lion";
        String textToPass = editText.getText().toString();

        if (textToPass == answer) {
            score = score + 1;
            scoreKeeper.setText(String.valueOf(score));
            answerStatus.setText("CORRECT");
        }else{
            score = score + 0;
            scoreKeeper.setText(String.valueOf(score));
            answerStatus.setText("WRONG, TRY AGAIN");
        }
    }

    public void sound(View view){
        MediaPlayer player = MediaPlayer.create(this,R.raw.roar);
        player.start();
    }

    public void nextPage(View view){
        Intent intent = new Intent(this,Summary.class);
        intent.putExtra("SCORE_TRACKER",score);
        startActivity(intent);
    }
}
