package com.example.gamedoc.network.doctor

import com.example.gamedoc.model.doctor.DoctorRegisterBodyReq
import com.example.gamedoc.model.gamer.GamerRegisterBodyReq
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface DoctorApiService {
    @POST("doctors/register")
    fun register(@Body registerBodyReq: DoctorRegisterBodyReq): Call<Map<String, Array<String>>>
}