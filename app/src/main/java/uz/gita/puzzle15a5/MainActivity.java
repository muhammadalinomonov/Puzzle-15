package uz.gita.puzzle15a5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView start;
    private TextView chempiones;
    private Settings settings;
    private TextView info;
    private TextView exit;
    private ImageView musicButton;

    @Override
    protected void onPause() {
//        settings.pauseMusicO();
        super.onPause();
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        settings = Settings.getInstance();

        settings.setMusic(this);
        loadView();

    }



    private void loadView() {

        musicButton = findViewById(R.id.music);
        setMusicStatus();
        info = findViewById(R.id.text_info);

        musicButton.setOnClickListener(view -> {
            settings.startTouch();
            if (settings.isMusicOn()){
                musicButton.setImageResource(R.drawable.sound_off);
                settings.pauseMusic();
            }else{
                musicButton.setImageResource(R.drawable.sound);
                settings.startMusic();
            }
        });


        start = findViewById(R.id.text_start);
        chempiones = findViewById(R.id.text_results);

        start.setOnClickListener(view ->      startActivity(new Intent(MainActivity.this, PlayActivity.class)));
        chempiones.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, MainActivity4.class)));
        info.setOnClickListener(view ->       startActivity(new Intent(MainActivity.this, MainActivity3.class)));


        exit = findViewById(R.id.text_exit);
        exit.setOnClickListener(v -> finish());

    }


    private void setMusicStatus() {
        if(settings.isMusicOn()){
            musicButton.setImageResource(R.drawable.sound);
            settings.startMusic();
        } else {
            musicButton.setImageResource(R.drawable.sound_off);
        }
    }

    private void setMusicStatus(boolean status) {
        if(status){
            musicButton.setImageResource(R.drawable.sound);
            settings.startMusic();
        } else {
            musicButton.setImageResource(R.drawable.sound_off);
        }
    }
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        boolean musicStatus = savedInstanceState.getBoolean("MUSIC_STATUS", true);
        setMusicStatus(musicStatus);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("MUSIC_STATUS", settings.isMusicOn());
    }

    @Override
    protected void onStart() {
        if (settings.isMusicOn()){
            settings.startMusic();
            musicButton.setImageResource(R.drawable.sound);
        }else{
            musicButton.setImageResource(R.drawable.sound_off);
        }
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        settings.releaseMusic();
        super.onDestroy();
    }


}

