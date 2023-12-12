package com.example.gamedoc.repository

import com.example.gamedoc.model.LoginBodyReq
import com.example.gamedoc.model.LoginBodyRes
import com.example.gamedoc.network.user.UserApiService

class UserRepository(private val userApiService: UserApiService) {
   suspend fun userLogin(
            email: String,
            password: String
        ): LoginBodyRes{
        return userApiService.login(LoginBodyReq(email,password));
    }
}