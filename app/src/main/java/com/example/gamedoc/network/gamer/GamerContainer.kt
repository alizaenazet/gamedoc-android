package com.example.gamedoc.network.gamer

import com.example.gamedoc.network.RetrofitInstance
import com.example.gamedoc.repository.GamerRepository

class GamerContainer {

    val gamerService: GamerApiService by lazy {
        RetrofitInstance.instance.create(GamerApiService::class.java);
    }

    val gamerRepository: GamerRepository by lazy {
        GamerRepository(gamerService)
    }
}