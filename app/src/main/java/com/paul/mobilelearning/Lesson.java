package com.paul.mobilelearning;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.security.Key;
import java.util.Locale;
import java.util.Objects;

public class Lesson extends AppCompatActivity {

    TextView title;
    TextView content;
    TextToSpeech toSpeech;
    int result;
    String text;

    int txtSize = 14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        Intent i = getIntent();
        String activeLessonOrQuiz = i.getStringExtra("lessonOrQuizName");
        String term = i.getStringExtra("term");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(activeLessonOrQuiz);

        title = (TextView) findViewById(R.id.lessonOrQuizTitle);
        content = (TextView) findViewById(R.id.lessonOrQuizContent);

        toSpeech = new TextToSpeech(Lesson.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    result = toSpeech.setLanguage(Locale.CANADA);
                } else {
                    Toast.makeText(getApplicationContext(), "Feature not supported in you device", Toast.LENGTH_LONG).show();
                }
            }
        });

        if (Objects.equals(activeLessonOrQuiz, "Lesson 2") && Objects.equals(term, "PRELIM")) {
            title.setText(activeLessonOrQuiz);
            content.setText("PRELIM TO! Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                    "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an " +
                    "unknown printer took a galley of type and scrambled it to make a type specimen book. " +
                    "It has survived not only five centuries, but also the leap into electronic typesetting, " +
                    "remaining essentially unchanged. It was popularised in the 1960s with the release of " +
                    "Letraset sheets containing Lorem Ipsum passages, and more recently with desktop " +
                    "publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        } else if (Objects.equals(activeLessonOrQuiz, "Lesson 1") && Objects.equals(term, "PRELIM")) {
            title.setText(activeLessonOrQuiz);
            content.setText("PRELIM TO! Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                    "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an " +
                    "unknown printer took a galley of type and scrambled it to make a type specimen book. " +
                    "It has survived not only five centuries, but also the leap into electronic typesetting, " +
                    "remaining essentially unchanged. It was popularised in the 1960s with the release of " +
                    "Letraset sheets containing Lorem Ipsum passages, and more recently with desktop " +
                    "publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        } else if (Objects.equals(activeLessonOrQuiz, "Lesson 1") && Objects.equals(term, "MIDTERM")) {
            title.setText(activeLessonOrQuiz);
            content.setText("MIDTERM NA. Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                    "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an " +
                    "unknown printer took a galley of type and scrambled it to make a type specimen book. " +
                    "It has survived not only five centuries, but also the leap into electronic typesetting, " +
                    "remaining essentially unchanged. It was popularised in the 1960s with the release of " +
                    "Letraset sheets containing Lorem Ipsum passages, and more recently with desktop " +
                    "publishing software like Aldus PageMaker including versions of Lorem Ipsum." +
                    "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an " +
                    "unknown printer took a galley of type and scrambled it to make a type specimen book. " +
                    "It has survived not only five centuries, but also the leap into electronic typesetting, " +
                    "remaining essentially unchanged. It was popularised in the 1960s with the release of " +
                    "Letraset sheets containing Lorem Ipsum passages, and more recently with desktop " +
                    "publishing software like Aldus PageMaker including versions of Lorem Ipsum." +
                    "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an " +
                    "unknown printer took a galley of type and scrambled it to make a type specimen book. " +
                    "It has survived not only five centuries, but also the leap into electronic typesetting, " +
                    "remaining essentially unchanged. It was popularised in the 1960s with the release of " +
                    "Letraset sheets containing Lorem Ipsum passages, and more recently with desktop " +
                    "publishing software like Aldus PageMaker including versions of Lorem Ipsum.+" +
                    "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an " +
                    "unknown printer took a galley of type and scrambled it to make a type specimen book. " +
                    "It has survived not only five centuries, but also the leap into electronic typesetting, " +
                    "remaining essentially unchanged. It was popularised in the 1960s with the release of " +
                    "Letraset sheets containing Lorem Ipsum passages, and more recently with desktop " +
                    "publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        } else if (activeLessonOrQuiz.contains("Quiz") && Objects.equals(term, "PRELIM")){
            Intent q = new Intent(getApplicationContext(), Quiz.class);
            q.putExtra("term", term);
            q.putExtra("quizName", activeLessonOrQuiz);
            startActivity(q);
        }

    }

    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public boolean dispatchKeyEvent(KeyEvent event){
        int action = event.getAction();
        int keyCode = event.getKeyCode();

        switch (keyCode) {

            case KeyEvent.KEYCODE_VOLUME_UP:
                if (action == KeyEvent.ACTION_DOWN) {
                    if(txtSize < 30) {
                        txtSize += 2;
                        content.setTextSize(txtSize);
                    }
                }
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                if (action == KeyEvent.ACTION_DOWN) {
                    if (txtSize > 8) {
                        txtSize -= 2;
                        content.setTextSize(txtSize);
                    }
                }
                return true;
            default:
                return super.dispatchKeyEvent(event);
        }
    }

    public void TTS(View view) {
        if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
            Toast.makeText(getApplicationContext(), "Feature not supported in you device", Toast.LENGTH_LONG).show();
        } else if (result == TextToSpeech.SUCCESS){
            if (toSpeech.isSpeaking()){
                toSpeech.stop();
            }else {
                text = title.getText().toString() + content.getText().toString();
                toSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(toSpeech!=null){
            toSpeech.stop();
            toSpeech.shutdown();
        }
    }

    public void backToLessons (View view){
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.activity_main_drawer, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.action_settings){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
