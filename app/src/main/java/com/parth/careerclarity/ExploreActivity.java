package com.parth.careerclarity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExploreActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Career> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        list.add(new Career("Software Engineer", "Build apps and software"));
        list.add(new Career("Data Analyst", "Analyze data"));
        list.add(new Career("UI/UX Designer", "Design user interfaces"));

        CareerAdapter adapter = new CareerAdapter(this, list);
        recyclerView.setAdapter(adapter);
    }
}