package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MatchActivity extends AppCompatActivity {
    Button  btn_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        final TextView sc_home = findViewById(R.id.score_home);
        final TextView sc_away = findViewById(R.id.score_away);
        final TextView home = findViewById(R.id.txt_home);
        final TextView away = findViewById(R.id.txt_away);

        //TODO
        //1.Menampilkan detail match sesuai data dari main activity
        //2.Tombol add score menambahkan satu angka dari angka 0, setiap kali di tekan
        //3.Tombol Cek Result menghitung pemenang dari kedua tim dan mengirim nama pemenang ke ResultActivity, jika seri di kirim text "Draw"

        Intent intent = getIntent();
        String home_  = intent.getStringExtra("home");
        String away_  = intent.getStringExtra("away");

        TextView first  = findViewById(R.id.txt_home);
        TextView second = findViewById(R.id.txt_away);

        first.setText(home_);
        second.setText(away_);

        //add score
        Button btn_home = findViewById(R.id.btn_add_home);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int score_home = Integer.parseInt(sc_home.getText().toString());
                score_home++;
                sc_home.setText(String.valueOf(score_home));
            }
        });

        Button btn_away = findViewById(R.id.btn_add_away);
        btn_away.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int score_away = Integer.parseInt(sc_away.getText().toString());
                score_away++;
                sc_away.setText(String.valueOf(score_away));
            }
        });

        Button result = findViewById(R.id.btn_result);
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

        // int score_home = Integer.parseInt(sc_home.getText().toString());
        // int score_away = Integer.parseInt(sc_away.getText().toString());

                String home_ = sc_home.getText().toString();
                String away_ = sc_away.getText().toString();
                String home1 = home.getText().toString();
                String away1 = away.getText().toString();
                Intent intent = new Intent(MatchActivity.this, ResultActivity.class);
                intent.putExtra("home_score", home_);
                intent.putExtra("away_score", away_);
                intent.putExtra("home", home1);
                intent.putExtra("away", away1);
                startActivity(intent);
            }
        });
    }
}
