package com.example.gamedoc.repository

import com.example.gamedoc.model.ResponseBody
import com.example.gamedoc.model.doctor.DoctorRegisterBodyReq
import com.example.gamedoc.network.doctor.DoctorApiService
import org.jetbrains.annotations.Nullable
import retrofit2.HttpException
import retrofit2.awaitResponse

class DoctorRepository(
    private  val doctorApiService: DoctorApiService
){

    suspend fun doctorRegister(
        doctorRegisterBodyReq: DoctorRegisterBodyReq
    ) : ResponseBody<Nullable, Map<String, Array<String>>> {
        try {
            val response = doctorApiService.register(doctorRegisterBodyReq).awaitResponse()
            when(response.code()) {
                422 -> {
                    return ResponseBody(
                        response.code(),
                    )
                }

                else -> {
                    throw HttpException(response)
                }
            }
        }catch (cause: java.io.EOFException){
            return ResponseBody(
                201,
            )
        }
    }
}