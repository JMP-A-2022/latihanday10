package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MatchActivity extends AppCompatActivity {

    TextView homeT,awayT, scoreH, scoreA;
    int scoreHo = 0;
    int scoreAw = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        homeT = findViewById(R.id.txt_home);
        awayT = findViewById(R.id.txt_away);
        scoreH = findViewById(R.id.score_home);
        scoreA = findViewById(R.id.score_away);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String homeTe = bundle.getString("home");
            String awayTe = bundle.getString("away");
            homeT.setText(homeTe);
            awayT.setText(awayTe);
        }
        //TODO
        //1.Menampilkan detail match sesuai data dari main activity
        //2.Tombol add score menambahkan satu angka dari angka 0, setiap kali di tekan
        //3.Tombol Cek Result menghitung pemenang dari kedua tim dan mengirim nama pemenang ke ResultActivity, jika seri di kirim text "Draw"
    }

    public void increase(View view){
        int viewID = view.getId();
        switch (viewID){
            case R.id.btn_add_home:
                scoreHo++;
                scoreH.setText(String.valueOf(scoreHo));
                break;
            case R.id.btn_add_away:
                scoreAw++;
                scoreA.setText(String.valueOf(scoreAw));
        }
    }

    public void handleHasil(View view) {
        String winner;
        Intent intent = new Intent(this, ResultActivity.class);
        if(scoreHo > scoreAw){
            winner = getIntent().getExtras().getString("home") + " is the winner";
        } else if(scoreAw > scoreHo){
            winner = getIntent().getExtras().getString("away") + " is the winner";
        } else{
            winner = getIntent().getExtras().getString("home") + " and " +
                    getIntent().getExtras().getString("away") + " are draw";
        }
        intent.putExtra("winner", winner);
        startActivity(intent);
    }
}
