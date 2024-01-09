package com.example.gamedoc.network.user

import com.example.gamedoc.network.RetrofitInstance
import com.example.gamedoc.repository.UserRepository
class UserContainer {

    val userService: UserApiService by lazy {
        RetrofitInstance.instance.create(UserApiService::class.java);
    }

    val userRepository: UserRepository by lazy {
        UserRepository(userService);
    }

}