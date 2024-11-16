package com.example.nutri;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class landingPage extends AppCompatActivity {

    private ImageView home, consulta, cronograma, aval;
    private int imagemAtualLigada = 1;  // Começa com home "ligado"
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_landing_page);

        // Configurar a Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Configurar o DrawerLayout e o NavigationView
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
//teste

        // Configurar o botão de menu na Toolbar
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Lidar com cliques nos itens do NavigationView
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.nav_home) {
                    Toast.makeText(landingPage.this, "Home selecionado", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.nav_profile) {
                    Toast.makeText(landingPage.this, "Perfil selecionado", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.nav_settings) {
                    Toast.makeText(landingPage.this, "Configurações selecionadas", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.nav_logout) {
                    Toast.makeText(landingPage.this, "Sair selecionado", Toast.LENGTH_SHORT).show();
                }

                // Fechar o menu após o clique
                drawerLayout.closeDrawers();
                return true;
            }
        });

        // Inicialize os ImageViews
        home = findViewById(R.id.home);
        consulta = findViewById(R.id.consulta);
        cronograma = findViewById(R.id.cronograma);
        aval = findViewById(R.id.aval);

        // Defina os onClickListeners para as imagens
        home.setOnClickListener(v -> alternarImagem(1));
        consulta.setOnClickListener(v -> alternarImagem(2));
        cronograma.setOnClickListener(v -> alternarImagem(3));
        aval.setOnClickListener(v -> alternarImagem(4));
    }


    private void alternarImagem(int imagemSelecionada) {
        // Verifica qual imagem está ligada e a desliga
        if (imagemAtualLigada != -1) {
            desativarImagem(imagemAtualLigada);
        }

        // Liga a nova imagem e atualiza o estado
        ligarImagem(imagemSelecionada);
        imagemAtualLigada = imagemSelecionada;
    }

    private void ligarImagem(int imagem) {
        // Usa o switch para alterar a imagem selecionada para o estado "ligado"
        switch (imagem) {
            case 1:
                home.setImageResource(R.drawable.botao_home_ligado);
                break;
            case 2:
                consulta.setImageResource(R.drawable.calendario_ligado);
                break;
            case 3:
                cronograma.setImageResource(R.drawable.tempo_ligado);
                break;
            case 4:
                aval.setImageResource(R.drawable.estrela_ligado);
                break;
        }
    }

    private void desativarImagem(int imagem) {
        // Usa o switch para retornar a imagem selecionada ao estado "desligado"
        switch (imagem) {
            case 1:
                home.setImageResource(R.drawable.botao_home);
                break;
            case 2:
                consulta.setImageResource(R.drawable.calendario);
                break;
            case 3:
                cronograma.setImageResource(R.drawable.tempo);
                break;
            case 4:
                aval.setImageResource(R.drawable.estrela);
                break;
        }
    }
    public void onBackPressed() {
        // Fechar o menu lateral se estiver aberto ao pressionar "voltar"
        if (drawerLayout.isDrawerOpen(navigationView)) {
            drawerLayout.closeDrawers();
        } else {
            super.onBackPressed();
        }
}
}
