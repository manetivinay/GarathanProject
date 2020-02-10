package com.vinay.garathanproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.vinay.garathanproject.Adapters.RequestIssueAdapter;
import com.vinay.garathanproject.DataModel.IssueItemDataModel;

import java.util.ArrayList;
import java.util.List;

import static com.vinay.garathanproject.LoginActivity.LOGIN_PREFS;
import static com.vinay.garathanproject.LoginActivity.LOGIN_STATUS;

public class RequestListActivity extends AppCompatActivity {

    private List<IssueItemDataModel> issueList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RequestIssueAdapter mAdapter;
    private ImageView logout_img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        logout_img = findViewById(R.id.logout_img);

        mAdapter = new RequestIssueAdapter(issueList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        logout_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                SharedPreferences mPrefs = getSharedPreferences(LOGIN_PREFS,0);
                SharedPreferences.Editor editor = mPrefs.edit();
                editor.remove(LOGIN_STATUS);
                editor.apply();
                Intent intent = new Intent(RequestListActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });


        // row click listener
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                IssueItemDataModel movie = issueList.get(position);
                Toast.makeText(getApplicationContext(), movie.getRequestId() + " is selected!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RequestListActivity.this, MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        prepareMovieData();
    }

    private void prepareMovieData() {
        IssueItemDataModel movie = new IssueItemDataModel("Mad Max: Fury Road", "Action & Adventure", "2015");
        issueList.add(movie);

        movie = new IssueItemDataModel("Inside Out", "Animation, Kids & Family", "2015");
        issueList.add(movie);

        movie = new IssueItemDataModel("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        issueList.add(movie);

        movie = new IssueItemDataModel("Shaun the Sheep", "Animation", "2015");
        issueList.add(movie);

        movie = new IssueItemDataModel("The Martian", "Science Fiction & Fantasy", "2015");
        issueList.add(movie);

        movie = new IssueItemDataModel("Mission: Impossible Rogue Nation", "Action", "2015");
        issueList.add(movie);

        movie = new IssueItemDataModel("Up", "Animation", "2009");
        issueList.add(movie);

        movie = new IssueItemDataModel("Star Trek", "Science Fiction", "2009");
        issueList.add(movie);

        movie = new IssueItemDataModel("The LEGO Movie", "Animation", "2014");
        issueList.add(movie);

        movie = new IssueItemDataModel("Iron Man", "Action & Adventure", "2008");
        issueList.add(movie);

        movie = new IssueItemDataModel("Aliens", "Science Fiction", "1986");
        issueList.add(movie);

        movie = new IssueItemDataModel("Chicken Run", "Animation", "2000");
        issueList.add(movie);

        movie = new IssueItemDataModel("Back to the Future", "Science Fiction", "1985");
        issueList.add(movie);

        movie = new IssueItemDataModel("Raiders of the Lost Ark", "Action & Adventure", "1981");
        issueList.add(movie);

        movie = new IssueItemDataModel("Goldfinger", "Action & Adventure", "1965");
        issueList.add(movie);

        movie = new IssueItemDataModel("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        issueList.add(movie);

        mAdapter.notifyDataSetChanged();
    }
}
