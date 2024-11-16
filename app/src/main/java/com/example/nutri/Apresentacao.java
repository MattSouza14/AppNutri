package com.example.nutri;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Apresentacao extends AppCompatActivity {
//teste

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_apresentacao);
    }
    public void entrar(View view){
    Intent troca_tela = new Intent(this,MainActivity.class);
    startActivity(troca_tela);
    finish();
    }
    public void cadastrar(View view){
        Intent troca_tela = new Intent(this,cadastro.class);
        startActivity(troca_tela);
        finish();
    }
}

