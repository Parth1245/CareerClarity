package com.parth.careerclarity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CareerDetailActivity extends AppCompatActivity {

    TextView title, description, skills, salary, roadmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_career_detail);

        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        skills = findViewById(R.id.skills);
        salary = findViewById(R.id.salary);
        roadmap = findViewById(R.id.roadmap);

        String career = getIntent().getStringExtra("career");

        if (career == null) career = "";

        if (career.equals("SE")) {
            title.setText(R.string.se_title);
            description.setText(R.string.se_desc);
            skills.setText(R.string.se_skills);
            salary.setText(R.string.se_salary);
            roadmap.setText(R.string.se_roadmap);
        }
        else if (career.equals("DA")) {
            title.setText(R.string.da_title);
            description.setText(R.string.da_desc);
            skills.setText(R.string.da_skills);
            salary.setText(R.string.da_salary);
            roadmap.setText(R.string.da_roadmap);
        }
        else {
            title.setText(R.string.ui_title);
            description.setText(R.string.ui_desc);
            skills.setText(R.string.ui_skills);
            salary.setText(R.string.ui_salary);
            roadmap.setText(R.string.ui_roadmap);
        }
    }
}