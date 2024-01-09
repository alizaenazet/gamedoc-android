package com.example.gamedoc.network.doctor

import com.example.gamedoc.network.retrofitInstance
import com.example.gamedoc.repository.DoctorRepository

class DoctorContainer {
    val doctorService: DoctorApiService by lazy {
        retrofitInstance.create(DoctorApiService::class.java)
    }

    val doctorRepository: DoctorRepository by lazy {
        DoctorRepository(doctorApiService = doctorService)
    }
}