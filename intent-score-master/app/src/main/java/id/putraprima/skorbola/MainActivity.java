package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
        EditText home_team;
        EditText away_team;
        Button btn_team;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            home_team = findViewById(R.id.home_team);
            away_team = findViewById(R.id.away_team);

            btn_team = findViewById(R.id.btn_team);
            btn_team.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            String home = home_team.getText().toString();
            String away = away_team.getText().toString();

            if(home.trim().equals("")){
                home_team.setError(" Fill home team");
            }
            else if(away.trim().equals("")){
                away_team.setError("Fill in away team");
            }
            else{
                Intent kirim = new Intent(MainActivity.this, MatchActivity.class);
                kirim.putExtra("home_team", home);
                kirim.putExtra("away_team", away);
                startActivity(kirim);
            }
        }
    }