package com.example.gamedoc.repository

import com.example.gamedoc.model.ResponseBody
import com.example.gamedoc.model.gamer.GamerRegisterBodyReq
import com.example.gamedoc.network.gamer.GamerApiService
import org.jetbrains.annotations.Nullable
import retrofit2.HttpException
import retrofit2.awaitResponse

class GamerRepository(
    private val gamerApiService: GamerApiService
) {

    suspend fun gamerRegister(
        gamerRegisterBodyReq: GamerRegisterBodyReq
    ): ResponseBody<Nullable, Map<String, Array<String>>> {

        val response = gamerApiService.register(gamerRegisterBodyReq).awaitResponse()

        when(response.code()) {
            422 -> {
                val data: Map<String, Array<String>> = response.body()!!
                return ResponseBody(
                    response.code(),
                    errorResponse = data
                )
            }

            201 -> {
                return ResponseBody(
                    response.code(),
                )
            }

            else -> {
                    throw HttpException(response)
            }
        }
    }
}