package com.example.nutri;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    EditText txtUser;
    EditText txtSenha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
    }
    public void checar_admin(View view) {
        String usuario = "olamundo@gmail.com";
        String senha = "1234";
        txtUser = findViewById(R.id.login2);
        String save = txtUser.getText().toString();
        txtSenha = findViewById(R.id.senha3);
        String save2 = txtSenha.getText().toString();
        if ((save.equals(usuario)) && save2.equals(senha)) {
            Toast.makeText(this, "Login efetuado com Sucesso", Toast.LENGTH_SHORT).show();
            Intent troca_tela = new Intent(this,landingPage.class);
            startActivity(troca_tela);
            finish();


        } else {
            Toast.makeText(this, "Usuario ou senha incorreto", Toast.LENGTH_SHORT).show();
            txtUser.setText("");
            txtSenha.setText("");
        }
//teste

    }
    public void cadastro_admin(View view){
        Intent troca_tela = new Intent(this,cadastro.class);
        startActivity(troca_tela);
    }
}