package com.example.gamedoc.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val BASE_URL = "https://84d8c3a5-117b-49d8-a01f-6627c2f80d9f.mock.pstmn.io"

val retrofitInstance = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()