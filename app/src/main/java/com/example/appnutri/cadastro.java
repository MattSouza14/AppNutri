package com.example.appnutri;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appnutri.api.ApiService;
import com.example.appnutri.model.User;

import java.io.IOException;
import java.text.ParseException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@RequiresApi(api = Build.VERSION_CODES.O)
public class cadastro extends AppCompatActivity {
    private Button cadastroBtn;
    private EditText nomeUsuario, cpfUsuario, telefoneUsuario, emailUsuario, senhaUsuario, dataNascimento;

    private Retrofit retrofit;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);


        cadastroBtn = findViewById(R.id.cadastro);
        nomeUsuario = findViewById(R.id.name);
        cpfUsuario = findViewById(R.id.cpf);
        telefoneUsuario = findViewById(R.id.telefone);
        emailUsuario = findViewById(R.id.email);
        senhaUsuario = findViewById(R.id.senha2);
        dataNascimento = findViewById(R.id.data);


        retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);


        cadastroBtn.setOnClickListener(view -> {
            String nome = nomeUsuario.getText().toString();
            String cpf = cpfUsuario.getText().toString();
            String senha = senhaUsuario.getText().toString();
            String telefone = telefoneUsuario.getText().toString();
            String email = emailUsuario.getText().toString();
           // String dataNasc = dataNascimento.getText().toString();

            if (!nome.isEmpty() && !email.isEmpty() && !senha.isEmpty() && !cpf.isEmpty() && !telefone.isEmpty() ) {
                try {
                    User user = new User(nome, email, senha, cpf, telefone);
                    cadastrarUsuario(user); // Chama o método para realizar o cadastro
                } catch (ParseException e) {
                    // Exibe uma mensagem de erro caso a conversão da data falhe
                    Toast.makeText(this, "Formato de data inválido. Use yyyy-MM-dd.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void cadastrarUsuario(User user) {
        Call<Void> call = apiService.createUser(user);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(cadastro.this, "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                } else {
                    // Log para entender o problema
                    int statusCode = response.code();
                    String errorBody = "";
                    try {
                        if (response.errorBody() != null) {
                            errorBody = response.errorBody().string(); // Obtém o corpo do erro como String
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    // Mostra a mensagem para depuração
                    Log.e("CadastroError", "Erro ao cadastrar. Código: " + statusCode + ", Detalhes: " + errorBody);

                    Toast.makeText(cadastro.this, "Erro ao cadastrar usuário. Código: " + statusCode, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }
}
