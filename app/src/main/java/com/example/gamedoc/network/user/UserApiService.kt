package com.example.gamedoc.network.user

import com.example.gamedoc.model.user.LoginBodyReq
import com.example.gamedoc.model.user.LoginBodyRes
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApiService {
    @POST("login")
    fun login(@Body loginBodyReq: LoginBodyReq): Call<LoginBodyRes>
}