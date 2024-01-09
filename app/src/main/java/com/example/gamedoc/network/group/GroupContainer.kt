package com.example.gamedoc.network.group

import com.example.gamedoc.BuildConfig
import com.example.gamedoc.network.AuthInterceptor
import com.example.gamedoc.network.RetrofitInstance
import com.example.gamedoc.repository.GroupRepository
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class GroupContainer {

    val groupService: GroupApiService by lazy {
        RetrofitInstance.instanceHeaderable().create(GroupApiService::class.java)
    }

    val groupRepository: GroupRepository by lazy {
        GroupRepository(groupService)
    }
}