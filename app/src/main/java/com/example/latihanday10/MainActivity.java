package com.example.latihanday10;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText Away = findViewById(R.id.away_team);
        EditText Home = findViewById(R.id.home_team);
        Button btnNext = findViewById(R.id.btn_team);

        //TODO
        //Fitur Main Activity
        //1. Validasi Input Home Team
        //2. Validasi Input Away Team
        //3. Ganti Logo Home Team
        //4. Ganti Logo Away Team
        //5. Next Button Pindah Ke MatchActivity

        btnNext.setOnClickListener(v -> {
            String home = Home.getText().toString();
            String away = Away.getText().toString();

            if (!home.isEmpty() && !away.isEmpty()) {
                Intent intent = new Intent(MainActivity.this, MatchActivity.class);

                intent.putExtra("home", home);
                intent.putExtra("away", away);

                startActivity(intent);
            }
        });
    }
}

