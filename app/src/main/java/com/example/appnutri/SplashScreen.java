package com.example.appnutri;
import android.os.Handler;
import android.os.Bundle;
import android.content.Intent;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
private static final int Splash_TIME_OUT = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);
new Handler().postDelayed(() -> {
    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
    startActivity(intent);
    finish();
}, Splash_TIME_OUT);

    }
}