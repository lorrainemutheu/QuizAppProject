package com.quizappproject.android.quizappproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int score = 0;
    TextView answerStatus;
    TextView scoreKeeper;
    CheckBox lionCheckBox;
    CheckBox rhinoCheckBox;
    CheckBox leopardCheckBox;

    public void checkAnswer(View view){
        answerStatus = findViewById(R.id.answerStatus);
        scoreKeeper = findViewById(R.id.scoreKeeper);
        lionCheckBox = findViewById(R.id.lion);
        rhinoCheckBox = findViewById(R.id.rhino);
        leopardCheckBox = findViewById(R.id.leopard);

        if (lionCheckBox.isChecked() && rhinoCheckBox.isChecked() && leopardCheckBox.isChecked()) {
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
        Intent intent = new Intent(this,Question2.class);
        intent.putExtra("SCORE_TRACKER",score);
        startActivity(intent);
    }
}
