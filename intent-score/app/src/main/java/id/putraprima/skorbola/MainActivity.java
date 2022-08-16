package id.putraprima.skorbola;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText homeTeam, awayTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        homeTeam = findViewById(R.id.home_team);
        awayTeam = findViewById(R.id.away_team);
        //TODO
        //Fitur Main Activity
        //1. Validasi Input Home Team
        //2. Validasi Input Away Team
        //3. Ganti Logo Home Team
        //4. Ganti Logo Away Team
        //5. Next Button Pindah Ke MatchActivity
    }

    public void handleNext(View view) {
        Intent intent = new Intent(this, MatchActivity.class);
        intent.putExtra("home", homeTeam.getText().toString());
        intent.putExtra("away", awayTeam.getText().toString());
        if(validateBlankField() == true) {
            startActivity(intent);
        }
    }

    private boolean validateBlankField() {
        String home = homeTeam.getText().toString().trim();
        String away = awayTeam.getText().toString().trim();
        if (!home.isEmpty() && !away.isEmpty()) {
            return true;
        } else if (home.isEmpty() && !away.isEmpty()) {
            Toast.makeText(MainActivity.this, "Fill The Home Team", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!home.isEmpty() && away.isEmpty()) {
            Toast.makeText(MainActivity.this, "Fill The Away Team", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            Toast.makeText(MainActivity.this, "Fill The All Team", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}