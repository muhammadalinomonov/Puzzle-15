package uz.gita.puzzle15a5;

import android.app.Application;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Settings.init(this);
    }
}
