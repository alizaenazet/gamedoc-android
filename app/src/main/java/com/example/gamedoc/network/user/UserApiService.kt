package com.example.gamedoc.network.user

import com.example.gamedoc.model.LoginBodyReq
import com.example.gamedoc.model.LoginBodyRes
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface UserApiService {
    @POST("login")
    suspend fun login(@Body loginBodyReq: LoginBodyReq): LoginBodyRes
}