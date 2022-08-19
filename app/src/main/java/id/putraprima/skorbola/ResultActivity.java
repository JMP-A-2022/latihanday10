package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView text_result, text_winner;
    String scoreHome, scoreAway, scHome, scAway;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        text_result = findViewById(R.id.txt_result);
        Intent result = getIntent();
        scoreHome = result.getStringExtra("Home Score");
        scoreAway = result.getStringExtra("Away Score");
        scHome = result.getStringExtra("Home");
        scAway = result.getStringExtra("Away");
        text_result.setText(scHome + " vs " + scAway);

        text_winner = findViewById(R.id.txt_winner);
        if (Integer.parseInt(scoreHome) > Integer.parseInt(scoreAway)) {
            text_winner.setText(scHome + " The Winner");
        } else if (Integer.parseInt(scoreHome) < Integer.parseInt(scoreAway)) {
            text_winner.setText(scAway + " The Winner");
        } else {
            text_winner.setText("Draw");
        }
    }
}
