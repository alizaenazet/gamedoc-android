package com.example.gamedoc.repository

import com.example.gamedoc.model.user.LoginBodyReq
import com.example.gamedoc.model.user.LoginBodyRes
import com.example.gamedoc.network.user.UserApiService

class UserRepository(private val userApiService: UserApiService) {
   suspend fun userLogin(
            email: String,
            password: String
        ): LoginBodyRes {
        val response = userApiService.login(LoginBodyReq(email,password))
        println("response")
       println(response.toString())
        return response;
    }
}