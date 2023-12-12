package com.example.gamedoc.network.user

import com.example.gamedoc.repository.UserRepository
import com.example.gamedoc.network.retrofitInstance

class UserContainer {

    val userService: UserApiService by lazy {
        retrofitInstance.create(UserApiService::class.java);
    }

    val userRepository: UserRepository by lazy {
        UserRepository(userService);
    }

}