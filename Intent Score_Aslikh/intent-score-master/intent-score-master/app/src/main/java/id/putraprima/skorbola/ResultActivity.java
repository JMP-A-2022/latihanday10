package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //show score
        TextView txt_score = findViewById(R.id.txt_result);
        Intent intent = getIntent();
        String score1 = intent.getStringExtra("home_score");
        String score2 = intent.getStringExtra("away_score");
        String home1 = intent.getStringExtra("home");
        String away1 = intent.getStringExtra("away");
        txt_score.setText(score1 + " - " + score2);

        //show winner or draw
        TextView txt_winner = findViewById(R.id.txt_team);
        if (Integer.parseInt(score1) > Integer.parseInt(score2)) {
            txt_winner.setText(home1 + " win");
        } else if (Integer.parseInt(score1) < Integer.parseInt(score2)) {
            txt_winner.setText(away1 + " win");
        } else {
            txt_winner.setText("Draw");

        }


    }
}
