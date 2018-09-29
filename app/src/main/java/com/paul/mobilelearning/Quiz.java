package com.paul.mobilelearning;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Objects;

public class Quiz extends AppCompatActivity {

    TextView question1,question2,question3,question4,question5,
             question6,question7,question8,question9,question10,
             result, score;
    RadioGroup choices1,choices2,choices3,choices4,choices5,
               choices6,choices7,choices8,choices9,choices10;
    RadioButton r1a,r2a,r3a,r4a,r5a,r6a,r7a,r8a,r9a,r10a,
                r1b,r2b,r3b,r4b,r5b,r6b,r7b,r8b,r9b,r10b,
                r1c,r2c,r3c,r4c,r5c,r6c,r7c,r8c,r9c,r10c,
                r1d,r2d,r3d,r4d,r5d,r6d,r7d,r8d,r9d,r10d;
    Button checkAnswer, finishQuiz;
    RadioGroup[] choices;
    TextView[] questions, answers;
    String activeQuiz;

    int totalScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Intent i = getIntent();
        activeQuiz = i.getStringExtra("quizName");
        String term = i.getStringExtra("term");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(activeQuiz);

        TextView[] questions = {
                (TextView) findViewById(R.id.question1),(TextView) findViewById(R.id.question2),
                (TextView) findViewById(R.id.question3),(TextView) findViewById(R.id.question4),
                (TextView) findViewById(R.id.question5),(TextView) findViewById(R.id.question6),
                (TextView) findViewById(R.id.question7),(TextView) findViewById(R.id.question8),
                (TextView) findViewById(R.id.question9),(TextView) findViewById(R.id.question10)
        };

        RadioGroup[] choices = {
                (RadioGroup) findViewById(R.id.choices1),(RadioGroup) findViewById(R.id.choices2),
                (RadioGroup) findViewById(R.id.choices3),(RadioGroup) findViewById(R.id.choices4),
                (RadioGroup) findViewById(R.id.choices5),(RadioGroup) findViewById(R.id.choices6),
                (RadioGroup) findViewById(R.id.choices7),(RadioGroup) findViewById(R.id.choices8),
                (RadioGroup) findViewById(R.id.choices10),(RadioGroup) findViewById(R.id.choices10)
        };

        r1a  = (RadioButton) findViewById(R.id.radioButton1a);
        r2a = (RadioButton) findViewById(R.id.radioButton2a);
        r3a = (RadioButton) findViewById(R.id.radioButton3a);
        r4a = (RadioButton) findViewById(R.id.radioButton4a);
        r5a = (RadioButton) findViewById(R.id.radioButton5a);
        r6a = (RadioButton) findViewById(R.id.radioButton6a);
        r7a = (RadioButton) findViewById(R.id.radioButton7a);
        r8a = (RadioButton) findViewById(R.id.radioButton8a);
        r9a = (RadioButton) findViewById(R.id.radioButton9a);
        r10a = (RadioButton) findViewById(R.id.radioButton10a);
        r1b = (RadioButton) findViewById(R.id.radioButton1b);
        r2b = (RadioButton) findViewById(R.id.radioButton2b);
        r3b = (RadioButton) findViewById(R.id.radioButton3b);
        r4b = (RadioButton) findViewById(R.id.radioButton4b);
        r5b = (RadioButton) findViewById(R.id.radioButton5b);
        r6b = (RadioButton) findViewById(R.id.radioButton6b);
        r7b = (RadioButton) findViewById(R.id.radioButton7b);
        r8b = (RadioButton) findViewById(R.id.radioButton8b);
        r9b = (RadioButton) findViewById(R.id.radioButton9b);
        r10b = (RadioButton) findViewById(R.id.radioButton10b);
        r1c = (RadioButton) findViewById(R.id.radioButton1c);
        r2c = (RadioButton) findViewById(R.id.radioButton2c);
        r3c = (RadioButton) findViewById(R.id.radioButton3c);
        r4c = (RadioButton) findViewById(R.id.radioButton4c);
        r5c = (RadioButton) findViewById(R.id.radioButton5c);
        r6c = (RadioButton) findViewById(R.id.radioButton6c);
        r7c = (RadioButton) findViewById(R.id.radioButton7c);
        r8c = (RadioButton) findViewById(R.id.radioButton8c);
        r9c = (RadioButton) findViewById(R.id.radioButton9c);
        r10c = (RadioButton) findViewById(R.id.radioButton10c);
        r1d = (RadioButton) findViewById(R.id.radioButton1d);
        r2d = (RadioButton) findViewById(R.id.radioButton2d);
        r3d = (RadioButton) findViewById(R.id.radioButton3d);
        r4d = (RadioButton) findViewById(R.id.radioButton4d);
        r5d = (RadioButton) findViewById(R.id.radioButton5d);
        r6d = (RadioButton) findViewById(R.id.radioButton6d);
        r7d = (RadioButton) findViewById(R.id.radioButton7d);
        r8d = (RadioButton) findViewById(R.id.radioButton8d);
        r9d = (RadioButton) findViewById(R.id.radioButton9d);
        r10d = (RadioButton) findViewById(R.id.radioButton10d);

        checkAnswer = (Button) findViewById(R.id.checkAnswer);


        if (Objects.equals(activeQuiz, "Prelim Quiz") && Objects.equals(term, "PRELIM")){
            answers = displayPrelimQuiz();
        } else if (Objects.equals(activeQuiz, "Midterm Quiz") && Objects.equals(term, "MIDTERM")){
            answers = displayMidtermQuiz();
        } else if (Objects.equals(activeQuiz, "Finals Quiz")&& Objects.equals(term, "MIDTERM")){
            answers = displayFinalsQuiz();
        }
    }

    @SuppressLint("ResourceAsColor")
    public void onCheck(View[] correctAnswer){

        RadioGroup[] choices = new RadioGroup[]{
                (RadioGroup) findViewById(R.id.choices1),(RadioGroup) findViewById(R.id.choices2),
                (RadioGroup) findViewById(R.id.choices3),(RadioGroup) findViewById(R.id.choices4),
                (RadioGroup) findViewById(R.id.choices5),(RadioGroup) findViewById(R.id.choices6),
                (RadioGroup) findViewById(R.id.choices7),(RadioGroup) findViewById(R.id.choices8),
                (RadioGroup) findViewById(R.id.choices9),(RadioGroup) findViewById(R.id.choices10)
        };

        for (int ctr=0; ctr<10; ctr++){
            int selectedId = choices[ctr].getCheckedRadioButtonId();
            if (selectedId == correctAnswer[ctr].getId()){
                totalScore++;
            }
        }
    }

    public TextView[] displayPrelimQuiz(){

        //Edit questions here
        String[] questionsStr = {
                "1. Who is the developer",
                "2. kingina 230 AM na",
                "3. tanginang yan",
                "4. gago ka ba",
                "5. KINANGINA MO!!! AHAHA",
                "6. MGA BOBO!!!",
                "7. LARRY GADON",
                "8. gusto ko magdota",
                "9. fuck you tenderjucy",
                "10. hikhak"
        };
        //Edit choices per number
        String[] choices1 = {
                "pak",
                "pek",
                "pek",
                "ka"
        };
        String[] choices2 = {
                "puta",
                "kinangina",
                "hayuf",
                "eut"
        };
        String[] choices3 = {
                "kinangina",
                "hayuf",
                "eut",
                "lingon ka eut ka"
        };
        String[] choices4 = {
                "pek",
                "pek",
                "ka",
                "gago?"
        };
        String[] choices5 = {
                "pak",
                "pek",
                "pek",
                "ka"
        };
        String[] choices6 = {
                "puta",
                "kinangina",
                "hayuf",
                "eut"
        };
        String[] choices7 = {
                "kinangina",
                "hayuf",
                "eut",
                "lingon ka eut ka"
        };
        String[] choices8 = {
                "pek",
                "pek",
                "ka",
                "gago?"
        };
        String[] choices9 = {
                "pak",
                "pek",
                "pek",
                "ka"
        };
        String[] choices10 = {
                "puta",
                "kinangina",
                "hayuf",
                "eut"
        };

        //Edit correct answer
        TextView[] correctAnswers = {
                r1a,
                r2b,
                r3c,
                r4d,
                r5a,
                r6b,
                r7c,
                r8d,
                r9a,
                r10b
        };

        TextView[] questions = {
                (TextView) findViewById(R.id.question1),(TextView) findViewById(R.id.question2),
                (TextView) findViewById(R.id.question3),(TextView) findViewById(R.id.question4),
                (TextView) findViewById(R.id.question5),(TextView) findViewById(R.id.question6),
                (TextView) findViewById(R.id.question7),(TextView) findViewById(R.id.question8),
                (TextView) findViewById(R.id.question9),(TextView) findViewById(R.id.question10)
        };

        RadioButton[] c1 = {r1a, r1b,r1c,r1d};
        RadioButton[] c2 = {r2a, r2b,r2c,r2d};
        RadioButton[] c3 = {r3a, r3b,r3c,r3d};
        RadioButton[] c4 = {r4a, r4b,r4c,r4d};
        RadioButton[] c5 = {r5a, r5b,r5c,r5d};
        RadioButton[] c6 = {r6a, r6b,r6c,r6d};
        RadioButton[] c7 = {r7a, r7b,r7c,r7d};
        RadioButton[] c8 = {r8a, r8b,r8c,r8d};
        RadioButton[] c9 = {r9a, r9b,r9c,r9d};
        RadioButton[] c10 = {r10a, r10b,r10c,r10d};


        for (int ctr=0; ctr<10; ctr++){
            questions[ctr].setText(questionsStr[ctr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c1[cCtr].setText(choices1[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c2[cCtr].setText(choices2[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c3[cCtr].setText(choices3[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c4[cCtr].setText(choices4[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c5[cCtr].setText(choices5[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c6[cCtr].setText(choices6[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c7[cCtr].setText(choices7[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c8[cCtr].setText(choices8[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c9[cCtr].setText(choices9[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c10[cCtr].setText(choices10[cCtr]);
        }
        //onNext(nextQuestion, questions[0],aChoices[0],bChoices[0],cChoices[0],dChoices[0],correctAnswers[0]);
        //display totalScore
        //Log.i("total score", String.valueOf(totalScore));
        return correctAnswers;
    }

    public TextView[] displayMidtermQuiz(){

        String[] questionsStr = {
                "1. Who is the developer",
                "2. kingina 230 AM na",
                "3. tanginang yan",
                "4. gago ka ba",
                "5. KINANGINA MO!!! AHAHA",
                "6. MGA BOBO!!!",
                "7. LARRY GADON",
                "8. gusto ko magdota",
                "9. fuck you tenderjucy",
                "10. hikhak"
        };
        String[] choices1 = {
                "pak",
                "pek",
                "pek",
                "ka"
        };
        String[] choices2 = {
                "puta",
                "kinangina",
                "hayuf",
                "eut"
        };
        String[] choices3 = {
                "kinangina",
                "hayuf",
                "eut",
                "lingon ka eut ka"
        };
        String[] choices4 = {
                "pek",
                "pek",
                "ka",
                "gago?"
        };
        String[] choices5 = {
                "pak",
                "pek",
                "pek",
                "ka"
        };
        String[] choices6 = {
                "puta",
                "kinangina",
                "hayuf",
                "eut"
        };
        String[] choices7 = {
                "kinangina",
                "hayuf",
                "eut",
                "lingon ka eut ka"
        };
        String[] choices8 = {
                "pek",
                "pek",
                "ka",
                "gago?"
        };
        String[] choices9 = {
                "pak",
                "pek",
                "pek",
                "ka"
        };
        String[] choices10 = {
                "puta",
                "kinangina",
                "hayuf",
                "eut"
        };

        TextView[] correctAnswers = {
                r1a,
                r2b,
                r3c,
                r4d,
                r5a,
                r6b,
                r7c,
                r8d,
                r9a,
                r10b
        };

        TextView[] questions = {
                (TextView) findViewById(R.id.question1),(TextView) findViewById(R.id.question2),
                (TextView) findViewById(R.id.question3),(TextView) findViewById(R.id.question4),
                (TextView) findViewById(R.id.question5),(TextView) findViewById(R.id.question6),
                (TextView) findViewById(R.id.question7),(TextView) findViewById(R.id.question8),
                (TextView) findViewById(R.id.question9),(TextView) findViewById(R.id.question10)
        };

        RadioButton[] c1 = {r1a, r1b,r1c,r1d};
        RadioButton[] c2 = {r2a, r2b,r2c,r2d};
        RadioButton[] c3 = {r3a, r3b,r3c,r3d};
        RadioButton[] c4 = {r4a, r4b,r4c,r4d};
        RadioButton[] c5 = {r5a, r5b,r5c,r5d};
        RadioButton[] c6 = {r6a, r6b,r6c,r6d};
        RadioButton[] c7 = {r7a, r7b,r7c,r7d};
        RadioButton[] c8 = {r8a, r8b,r8c,r8d};
        RadioButton[] c9 = {r9a, r9b,r9c,r9d};
        RadioButton[] c10 = {r10a, r10b,r10c,r10d};


        for (int ctr=0; ctr<10; ctr++){
            questions[ctr].setText(questionsStr[ctr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c1[cCtr].setText(choices1[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c2[cCtr].setText(choices2[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c3[cCtr].setText(choices3[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c4[cCtr].setText(choices4[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c5[cCtr].setText(choices5[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c6[cCtr].setText(choices6[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c7[cCtr].setText(choices7[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c8[cCtr].setText(choices8[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c9[cCtr].setText(choices9[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c10[cCtr].setText(choices10[cCtr]);
        }
        //onNext(nextQuestion, questions[0],aChoices[0],bChoices[0],cChoices[0],dChoices[0],correctAnswers[0]);
        //display totalScore
        //Log.i("total score", String.valueOf(totalScore));
        return correctAnswers;
    }

    public TextView[] displayFinalsQuiz(){

        String[] questionsStr = {
                "1. Who is the developer",
                "2. kingina 230 AM na",
                "3. tanginang yan",
                "4. gago ka ba",
                "5. KINANGINA MO!!! AHAHA",
                "6. MGA BOBO!!!",
                "7. LARRY GADON",
                "8. gusto ko magdota",
                "9. fuck you tenderjucy",
                "10. hikhak"
        };
        String[] choices1 = {
                "pak",
                "pek",
                "pek",
                "ka"
        };
        String[] choices2 = {
                "puta",
                "kinangina",
                "hayuf",
                "eut"
        };
        String[] choices3 = {
                "kinangina",
                "hayuf",
                "eut",
                "lingon ka eut ka"
        };
        String[] choices4 = {
                "pek",
                "pek",
                "ka",
                "gago?"
        };
        String[] choices5 = {
                "pak",
                "pek",
                "pek",
                "ka"
        };
        String[] choices6 = {
                "puta",
                "kinangina",
                "hayuf",
                "eut"
        };
        String[] choices7 = {
                "kinangina",
                "hayuf",
                "eut",
                "lingon ka eut ka"
        };
        String[] choices8 = {
                "pek",
                "pek",
                "ka",
                "gago?"
        };
        String[] choices9 = {
                "pak",
                "pek",
                "pek",
                "ka"
        };
        String[] choices10 = {
                "puta",
                "kinangina",
                "hayuf",
                "eut"
        };

        TextView[] correctAnswers = {
                r1a,
                r2b,
                r3c,
                r4d,
                r5a,
                r6b,
                r7c,
                r8d,
                r9a,
                r10b
        };

        TextView[] questions = {
                (TextView) findViewById(R.id.question1),(TextView) findViewById(R.id.question2),
                (TextView) findViewById(R.id.question3),(TextView) findViewById(R.id.question4),
                (TextView) findViewById(R.id.question5),(TextView) findViewById(R.id.question6),
                (TextView) findViewById(R.id.question7),(TextView) findViewById(R.id.question8),
                (TextView) findViewById(R.id.question9),(TextView) findViewById(R.id.question10)
        };

        RadioButton[] c1 = {r1a, r1b,r1c,r1d};
        RadioButton[] c2 = {r2a, r2b,r2c,r2d};
        RadioButton[] c3 = {r3a, r3b,r3c,r3d};
        RadioButton[] c4 = {r4a, r4b,r4c,r4d};
        RadioButton[] c5 = {r5a, r5b,r5c,r5d};
        RadioButton[] c6 = {r6a, r6b,r6c,r6d};
        RadioButton[] c7 = {r7a, r7b,r7c,r7d};
        RadioButton[] c8 = {r8a, r8b,r8c,r8d};
        RadioButton[] c9 = {r9a, r9b,r9c,r9d};
        RadioButton[] c10 = {r10a, r10b,r10c,r10d};


        for (int ctr=0; ctr<10; ctr++){
            questions[ctr].setText(questionsStr[ctr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c1[cCtr].setText(choices1[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c2[cCtr].setText(choices2[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c3[cCtr].setText(choices3[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c4[cCtr].setText(choices4[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c5[cCtr].setText(choices5[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c6[cCtr].setText(choices6[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c7[cCtr].setText(choices7[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c8[cCtr].setText(choices8[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c9[cCtr].setText(choices9[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c10[cCtr].setText(choices10[cCtr]);
        }
        //onNext(nextQuestion, questions[0],aChoices[0],bChoices[0],cChoices[0],dChoices[0],correctAnswers[0]);
        //display totalScore
        //Log.i("total score", String.valueOf(totalScore));
        return correctAnswers;
    }



    public void displayResult(View view) {
        onCheck(answers);
        Log.i("SCORE", String.valueOf(totalScore));

        Intent goToQuizResult = new Intent(getApplicationContext(), QuizResult.class);
        goToQuizResult.putExtra("score", String.valueOf(totalScore));
        goToQuizResult.putExtra("quizName", activeQuiz);
        startActivity(goToQuizResult);
    }
}
