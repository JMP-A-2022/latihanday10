package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button button_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText homeTeam = findViewById(R.id.home_team);
        final EditText awayTeam = findViewById(R.id.away_team);
        button_next = findViewById(R.id.btn_team);
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String home_team = homeTeam.getText().toString();
                String away_team = awayTeam.getText().toString();

                if (!home_team.isEmpty() && !away_team.isEmpty()) {
                    Intent match = new Intent(MainActivity.this, MatchActivity.class);
                    match.putExtra("Home", home_team.toString());
                    match.putExtra("Away", away_team.toString());
                    startActivity(match);
                } else {
                    Toast.makeText(MainActivity.this, "Lengkapi bagian yang masoh kosong!!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        //TODO
        //Fitur Main Activity
        //1. Validasi Input Home Team
        //2. Validasi Input Away Team
        //3. Ganti Logo Home Team
        //4. Ganti Logo Away Team
        //5. Next Button Pindah Ke MatchActivity
    }
}
