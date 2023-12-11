package com.example.gamedoc.network

import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Retrofit
class RetrofitInstance {
    private val BASE_URL = "https://dummyjson.com";

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

//    Register Api services Below:
}