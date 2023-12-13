package com.example.gamedoc.repository

import com.example.gamedoc.data.SettingsDataStore
import com.example.gamedoc.model.user.LoginBodyReq
import com.example.gamedoc.model.user.LoginBodyRes
import com.example.gamedoc.network.user.UserApiService
import retrofit2.HttpException
import retrofit2.awaitResponse
private lateinit var settingsDataStore: SettingsDataStore

class UserRepository(private val userApiService: UserApiService) {
   suspend fun userLogin(
            email: String,
            password: String
        ): LoginBodyRes {
        val response = userApiService.login(LoginBodyReq(email,password)).awaitResponse()

       when(response.code()){
           200 -> {
               val responseData = response.body()!!
               settingsDataStore.saveTokenToPreferencesStore(responseData.token,)
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