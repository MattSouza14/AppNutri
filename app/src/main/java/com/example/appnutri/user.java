package com.example.appnutri;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class user extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user);
//teste
    }
    public void user(View view){
        Intent troca_tela = new Intent(this, Apresentacao.class);
        startActivity(troca_tela);
    }
    public void admin(View view){
        Intent troca_tela = new Intent(this,apresentacao_admin.class);
        startActivity(troca_tela);
    }
}