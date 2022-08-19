package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MatchActivity extends AppCompatActivity {

    TextView start, end;
    Button button_home, button_away, button_result;
    int sc_home, sc_away;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        final TextView score_home = findViewById(R.id.score_home);
        final TextView score_away = findViewById(R.id.score_away);
        final TextView home = findViewById(R.id.txt_home);
        final TextView away = findViewById(R.id.txt_away);

        Intent match = getIntent();
        String hmTeam = match.getStringExtra("Home");
        String awTeam = match.getStringExtra("Away");

        start = findViewById(R.id.txt_home);
        end = findViewById(R.id.txt_away);

        start.setText(hmTeam);
        end.setText(awTeam);

        button_home = findViewById(R.id.btn_add_home);
        button_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sc_home = Integer.parseInt(score_home.getText().toString());
                sc_home++;
                score_home.setText(String.valueOf(sc_home));
            }
        });

        button_away = findViewById(R.id.btn_add_away);
        button_away.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sc_away = Integer.parseInt(score_away.getText().toString());
                sc_away++;
                score_away.setText(String.valueOf(sc_away));
            }
        });

        button_result = findViewById(R.id.btn_result);
        button_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String hmTeam = score_home.getText().toString();
            String awTeam = score_away.getText().toString();
            String scdHome = home.getText().toString();
            String scdAway = away.getText().toString();
            Intent match = new Intent(MatchActivity.this, ResultActivity.class);
            match.putExtra("Home Score", hmTeam);
            match.putExtra("Away Score", awTeam);
            match.putExtra("Home", scdHome);
            match.putExtra("Away", scdAway);
            startActivity(match);
            }
        });
        //TODO
        //1.Menampilkan detail match sesuai data dari main activity
        //2.Tombol add score menambahkan satu angka dari angka 0, setiap kali di tekan
        //3.Tombol Cek Result menghitung pemenang dari kedua tim dan mengirim nama pemenang ke ResultActivity, jika seri di kirim text "Draw"
    }
}
