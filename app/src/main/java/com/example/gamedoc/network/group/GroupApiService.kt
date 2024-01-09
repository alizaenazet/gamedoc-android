package com.example.gamedoc.network.group

import com.example.gamedoc.model.group.GroupList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface GroupApiService {
    @GET("gamers/groups/preview")
    fun groupsPreview(): Call<GroupList>
}