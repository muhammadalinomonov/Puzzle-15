package uz.gita.puzzle15a5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {

    private Settings settings;
    private SharedPreferences pref;
    Chronometer time;
    TextView score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        findViewById(R.id.btn_exit).setOnClickListener(v -> finish());
        settings = Settings.getInstance();
        pref = settings.getSharedPreferences();

        loadView();
    }

    private void loadView() {
        score = findViewById(R.id.stepOfRecord);
        time = findViewById(R.id.timeOfRecord);
        int score = settings.getFirstScore();
        if (score == 100000) {
            findViewById(R.id.empty).setVisibility(View.VISIBLE);
            findViewById(R.id.liner1).setVisibility(View.INVISIBLE);
            findViewById(R.id.liner2).setVisibility(View.INVISIBLE);
            return;
        }

        findViewById(R.id.empty).setVisibility(View.GONE);
        this.score.setText(String.valueOf(score));
        time.setText(pref.getString("time0", "00:00"));
    }
}