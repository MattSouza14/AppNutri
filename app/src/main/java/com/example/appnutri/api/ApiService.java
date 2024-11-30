package com.example.appnutri.api;
import com.example.appnutri.model.LoginRequest;
import com.example.appnutri.model.LoginResponse;
import com.example.appnutri.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("/cadastro")
    Call<Void> createUser(@Body User user);

    @POST("/login")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);
}


