package com.example.latihanday10;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();

        String scoreX = intent.getStringExtra("home_score");
        String scoreY = intent.getStringExtra("away_score");
        TextView Score = findViewById(R.id.txt_result);
        Score.setText(scoreX + " - " + scoreY);

        String Home = intent.getStringExtra("home");
        String Away = intent.getStringExtra("away");

        TextView txt_winner = findViewById(R.id.txt_team);

        if (Integer.parseInt(scoreX) > Integer.parseInt(scoreY)) txt_winner.setText(Home + " Win");
        else if (Integer.parseInt(scoreX) < Integer.parseInt(scoreY)) txt_winner.setText(Away + " Win");
        else txt_winner.setText("Draw");
    }
}
