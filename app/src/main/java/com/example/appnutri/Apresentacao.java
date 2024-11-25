package com.example.appnutri;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Apresentacao extends AppCompatActivity {
//teste

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_apresentacao);
    }
    public void entrar(View view){
    Intent troca_tela = new Intent(this, MainActivity.class);
    startActivity(troca_tela);
    finish();
    }
    public void cadastrar(View view){
        Intent troca_tela = new Intent(this,cadastro.class);
        startActivity(troca_tela);
        finish();
    }
}

