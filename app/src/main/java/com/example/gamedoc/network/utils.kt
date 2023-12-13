package com.example.gamedoc.network

import com.example.gamedoc.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofitInstance = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BuildConfig.BASE_URL)
    .build()