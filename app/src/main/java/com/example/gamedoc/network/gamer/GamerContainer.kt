package com.example.gamedoc.network.gamer

import com.example.gamedoc.network.retrofitInstance
import com.example.gamedoc.network.user.UserApiService
import com.example.gamedoc.repository.GamerRepository

class GamerContainer {

    val gamerService: GamerApiService by lazy {
        retrofitInstance.create(GamerApiService::class.java);
    }

    val gamerRepository: GamerRepository by lazy {
        GamerRepository(gamerService)
    }
}