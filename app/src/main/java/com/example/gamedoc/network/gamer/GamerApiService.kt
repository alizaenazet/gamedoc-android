package com.example.gamedoc.network.gamer

import com.example.gamedoc.model.gamer.GamerRegisterBodyReq
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.Call


interface GamerApiService {
    @POST("doctors/register")
    fun register(@Body registerBodyReq: GamerRegisterBodyReq): Call<Map<String,Array<String>>>
}