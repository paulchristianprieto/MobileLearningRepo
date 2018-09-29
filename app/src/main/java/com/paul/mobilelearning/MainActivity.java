package com.paul.mobilelearning;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.lang.String;
import java.lang.Object;
import java.util.Objects;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView termTextView;
    ListView lessonList;
    ArrayAdapter arrayAdapter;

    ArrayList prelimLessons;
    ArrayList midtermLessons;
    ArrayList finalsLessons;
    ArrayList videos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme_NoActionBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prelimLessons = new ArrayList<String>();
        midtermLessons = new ArrayList<String>();
        finalsLessons = new ArrayList<String>();
        videos = new ArrayList<String>();

        prelimLessons.add("Lesson 1");
        prelimLessons.add("Lesson 2");
        prelimLessons.add("Lesson 3");
        prelimLessons.add("Prelim Quiz");

        midtermLessons.add("Lesson 1");
        midtermLessons.add("Lesson 2");
        midtermLessons.add("Lesson 3");
        midtermLessons.add("Lesson 4");
        midtermLessons.add("Midterm Quiz");

        finalsLessons.add("Lesson 1");
        finalsLessons.add("Lesson 2");
        finalsLessons.add("Finals Quiz");

        videos.add("Video 1");
        videos.add("Video 2");

        termTextView = (TextView) findViewById(R.id.term);
        lessonList = (ListView) findViewById(R.id.lessonList);
        displayTerm("PRELIM", prelimLessons);

        //arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lessons);
        //lessonList.setAdapter(arrayAdapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void displayTerm(final String term, final ArrayList<String> lesson){
        termTextView.setText(term);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lesson);
        lessonList.setAdapter(arrayAdapter);


        lessonList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {

                Intent i = new Intent(getApplicationContext(), Lesson.class);
                i.putExtra("lessonOrQuizName", (String) lesson.get(pos));
                i.putExtra("term", term);
                startActivity(i);
            }
        });

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_prelim) {
            displayTerm("PRELIM", prelimLessons);

        } else if (id == R.id.nav_midterm) {
            displayTerm("MIDTERM", midtermLessons);

        } else if (id == R.id.nav_finals){
            displayTerm("FINALS", finalsLessons);

        } else if (id == R.id.nav_videos) {
            termTextView.setText("VIDEOS");
            arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, videos);
            lessonList.setAdapter(arrayAdapter);
            lessonList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {

                    Intent i = new Intent(getApplicationContext(), Videos.class);
                    i.putExtra("videoName", (String) videos.get(pos));
                    i.putExtra("term", "VIDEOS");
                    startActivity(i);
                }
            });

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
