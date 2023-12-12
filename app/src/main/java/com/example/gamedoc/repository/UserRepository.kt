package com.example.gamedoc.repository

import com.example.gamedoc.model.InvalidMessgRes
import com.example.gamedoc.model.user.LoginBodyReq
import com.example.gamedoc.model.user.LoginBodyRes
import com.example.gamedoc.network.user.UserApiService
import retrofit2.Call
import retrofit2.HttpException
import retrofit2.Response
import retrofit2.awaitResponse

class UserRepository(private val userApiService: UserApiService) {
   suspend fun userLogin(
            email: String,
            password: String
        ): LoginBodyRes {
        val response = userApiService.login(LoginBodyReq(email,password)).awaitResponse()
       when(response.code()){
           200 -> {
               val responseData = response.body()!!
               return LoginBodyRes(responseData.id, responseData.role, responseData.token)
           }
           404 -> {
               throw Throwable("user not found")
           }
           else -> {
                throw HttpException(response)
           }
       }
    }
}