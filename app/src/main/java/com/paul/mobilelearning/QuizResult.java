package com.paul.mobilelearning;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Objects;

public class QuizResult extends AppCompatActivity {

    TextView passedOrFailed, scoreTextView, percentage;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        Intent i = getIntent();
        String activeQuiz = i.getStringExtra("quizName");
        String score = i.getStringExtra("score");

        scoreTextView = (TextView) findViewById(R.id.score);
        passedOrFailed = (TextView) findViewById(R.id.passedOrFailed);
        percentage = (TextView) findViewById(R.id.percentage);
        TextView activeQuizTextView = (TextView) findViewById(R.id.activeQuiz);

        activeQuizTextView.setText(activeQuiz);
        setTitle(activeQuiz);

        if(Objects.equals(score, "0") || Objects.equals(score, "1") ||Objects.equals(score, "2") ||
                Objects.equals(score, "3") ||Objects.equals(score, "4") ){
            passedOrFailed.setText("YOU FAILED.");
            scoreTextView.setText(score + "/10");
            percentage.setText(score + "0%");
            passedOrFailed.setTextColor(R.color.bagsak);
        }else{
            passedOrFailed.setText("YOU PASSED!");
            scoreTextView.setText(score + "/10");
            percentage.setText(score + "0%");
            passedOrFailed.setTextColor(R.color.pasado);
        }


    }

    public void onFinish(View view) {
        Intent goToMain = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(goToMain);
    }
}
