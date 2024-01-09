package com.example.gamedoc.network.doctor

import com.example.gamedoc.network.RetrofitInstance
import com.example.gamedoc.repository.DoctorRepository

class DoctorContainer {
    val doctorService: DoctorApiService by lazy {
        RetrofitInstance.instance.create(DoctorApiService::class.java)
    }

    val doctorRepository: DoctorRepository by lazy {
        DoctorRepository(doctorApiService = doctorService)
    }
}