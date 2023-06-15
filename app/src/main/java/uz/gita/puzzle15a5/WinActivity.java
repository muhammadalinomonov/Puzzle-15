package uz.gita.puzzle15a5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class WinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        Intent intent = getIntent();

        TextView text = findViewById(R.id.result);

        text.setText(String.valueOf(intent.getIntExtra("score",0)));

        findViewById(R.id.home).setOnClickListener(v -> finish());
    }
}