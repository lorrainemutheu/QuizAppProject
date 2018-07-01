package com.quizappproject.android.quizappproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;

/**
 * Created by Emobilis on 7/1/2018.
 */

public class Question3 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question3);
    }

    int score = 0;

    public void showDropDown(View view){
        final Button showMenu = findViewById(R.id.show_dropdown_menu);
        showMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu dropdownMenu = new PopupMenu(getApplicationContext(),showMenu);
                dropdownMenu.getMenuInflater().inflate(R.menu.drop_down_menu,dropdownMenu.getMenu());
                dropdownMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        return true;
                    }
                });
                dropdownMenu.show();
            }
        });
    }

    public void checkAnswer(View view){
        Bundle extras = getIntent().getExtras();
        score = extras.getInt("SCORE_TRACKER");

        TextView scoreKeeper = findViewById(R.id.scoreKeeper);
        scoreKeeper.setText(String.valueOf(score));
        TextView answerStatus = findViewById(R.id.answerStatus);
        EditText editText = findViewById(R.id.editText);

        String answer = "gills";
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

    public void nextPage(View view){
        Intent intent = new Intent(this,Question4.class);
        intent.putExtra("SCORE_TRACKER",score);
        startActivity(intent);
    }
}
