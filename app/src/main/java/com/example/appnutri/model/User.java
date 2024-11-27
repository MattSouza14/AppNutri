package com.example.appnutri.model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@RequiresApi(api = Build.VERSION_CODES.O)
public class User {

    private String nome;
    private String email;
    private String senha;
   // private String genero;
    private String cpf;
    private String telefone;
   // private Date dataNascimento;

    DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public User(String nome, String email, String senha,
                String cpf, String telefone) throws ParseException {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        //this.genero= genero;
        this.telefone = telefone;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       // this.dataNascimento = (Date) fmt1.parse(dataNascimento);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

   // public String getGenero() {
        //return genero;
   // }

    //public void setGenero(String genero) {
    //    this.genero = genero;
    //}

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    //public Date getDataNascimento() {
     //  return dataNascimento;
   // }

    //public void setDataNascimento(Date dataNascimento) {
    //    this.dataNascimento = dataNascimento;
    //}

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
