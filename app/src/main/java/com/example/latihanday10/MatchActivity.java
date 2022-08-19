package com.example.latihanday10;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MatchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView home = findViewById(R.id.txt_home);
        TextView away = findViewById(R.id.txt_away);
        TextView scoreHome = findViewById(R.id.score_home);
        TextView scoreAway = findViewById(R.id.score_away);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        //TODO
        //1.Menampilkan detail match sesuai data dari main activity
        //2.Tombol add score menambahkan satu angka dari angka 0, setiap kali di tekan
        //3.Tombol Cek Result menghitung pemenang dari kedua tim dan mengirim nama pemenang ke ResultActivity, jika seri di kirim text "Draw"

        Intent intent = getIntent();
        String home_ = intent.getStringExtra("home");
        String away_ = intent.getStringExtra("away");

        TextView first = findViewById(R.id.txt_home);
        TextView second = findViewById(R.id.txt_away);

        first.setText(home_);
        second.setText(away_);

        Button btn_home = findViewById(R.id.btn_add_home);
        btn_home.setOnClickListener(v -> {
            int score_home = Integer.parseInt(scoreHome.getText().toString());
            score_home++;
            scoreHome.setText(String.valueOf(score_home));
        });

        Button btn_away = findViewById(R.id.btn_add_away);
        btn_away.setOnClickListener(v -> {
            int ScoreAway = Integer.parseInt(scoreAway.getText().toString());
            ScoreAway++;
            scoreAway.setText(String.valueOf(ScoreAway));
        });

        Button result = findViewById(R.id.btn_result);
        result.setOnClickListener(v -> {
            String HOME = scoreHome.getText().toString();
            String AWAY = scoreAway.getText().toString();
            String Home = home.getText().toString();
            String Away = away.getText().toString();

            Intent INTENT = new Intent(MatchActivity.this, ResultActivity.class);
            INTENT.putExtra("home_score", HOME);
            INTENT.putExtra("away_score", AWAY);
            INTENT.putExtra("home", Home);
            INTENT.putExtra("away", Away);
            startActivity(INTENT);
        });
    }
}