package com.example.gamedoc.repository

import android.util.Log
import com.example.gamedoc.model.ResponseBody
import com.example.gamedoc.model.group.DetailGroup
import com.example.gamedoc.model.group.GroupList
import com.example.gamedoc.network.RetrofitInstance
import com.example.gamedoc.network.group.GroupApiService
import org.jetbrains.annotations.Nullable
import retrofit2.awaitResponse

class GroupRepository(
    private val groupApiService: GroupApiService
) {

    suspend fun getGroupDetail(groupId: String): ResponseBody<DetailGroup,Nullable>{
        try {
            val response = groupApiService.groupDetail(groupId).awaitResponse()

            when(response.code()){
                200 -> {
                    return ResponseBody(
                        200,
                        response.body()
                    )
                }

                401 -> {
                    return ResponseBody(
                        401,
                        response.body()
                    )
                }

                404 -> {
                    return ResponseBody(
                        404,
                        response.body()
                    )
                }
            }

        }catch (cause: java.io.EOFException){
            return ResponseBody(
                401,
            )
        }catch (e: Exception) {
            Log.d("Error11", e.message.toString())
            throw Exception(e.message.toString())
        }
        return ResponseBody(
            401,
        )
    }
    suspend fun getGroupList(): ResponseBody<GroupList,Nullable>{
        try {
            Log.e("USER TOKEN on fetch", RetrofitInstance.userToken)
            val response = groupApiService.groupsPreview().awaitResponse()
            when(response.code()){
                200 -> {
                    return ResponseBody(
                        200,
                        response.body()
                    )
                }
                401 -> {
                    return ResponseBody(
                        401
                    )
                }
            }

        }catch (cause: java.io.EOFException){
            return ResponseBody(
                401,
            )
        }catch (e: Exception) {
            Log.d("Error11", e.message.toString())
            throw Exception(e.message.toString())
        }
        return ResponseBody(
            401
        )
    }
}