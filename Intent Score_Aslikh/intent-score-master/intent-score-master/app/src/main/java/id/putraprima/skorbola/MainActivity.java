package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText home = findViewById(R.id.home_team);
        final EditText away = findViewById(R.id.away_team);

        //TODO
        //Fitur Main Activity
        //1. Validasi Input Home Team
        //2. Validasi Input Away Team
        //3. Ganti Logo Home Team
        //4. Ganti Logo Away Team
        //5. Next Button Pindah Ke MatchActivity

        btn_next = findViewById(R.id.btn_team);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String home_ = home.getText().toString();
                String away_ = away.getText().toString();

                if(!home_.isEmpty() && !away_.isEmpty()){
                    Intent intent = new Intent(MainActivity.this, MatchActivity.class);
                    intent.putExtra("home", home_.toString());
                    intent.putExtra("away", away_.toString());
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "Please fill in the blank!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
